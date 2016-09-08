package com.universalcrackers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.universalcrackers.dataaccess.OrderDAO;
import com.universalcrackers.dataaccess.ProductDAO;
import com.universalcrackers.dataaccess.model.Order;
import com.universalcrackers.dataaccess.model.OrderItems;
import com.universalcrackers.dataaccess.model.Product;
import com.universalcrackers.service.model.CrackerServiceResponse;
import com.universalcrackers.service.model.OrderDetails;
import com.universalcrackers.service.model.ProductVO;

@Service
public class CrackerServiceImpl implements CrackerService {

	private static ObjectMapper objectMapper;
	
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private OrderDAO orderDao;
	
	static{
		objectMapper = new ObjectMapper();
	}
	
	public CrackerServiceResponse createOrder(OrderDetails orderDetails) {
		CrackerServiceResponse crackerResponse = new CrackerServiceResponse();
		if(orderDetails != null){
			try{
				System.out.println("Order Request :"+objectMapper.writeValueAsString(orderDetails));
				validateOrderCreationRequest(orderDetails);
				Order order = new Order();
				order.setEmailId(orderDetails.getEmailId());
				order.setMobileNumber(orderDetails.getPhoneNumber());
				order.setShippingAddress(orderDetails.getShippingAddress());
				List<OrderItems> products = new ArrayList<OrderItems>();
				Double totalAmt = new Double("0");
				for(ProductVO orderItem : orderDetails.getOrderItems()){
					Product product = productDao.find(orderItem.getId());
					if(product != null){
						OrderItems tempOrderItem = new OrderItems();
						tempOrderItem.setAmount(product.getPrice());
						tempOrderItem.setProduct(product);
						tempOrderItem.setQuantity(orderItem.getQty());
						products.add(tempOrderItem);
						totalAmt += product.getPrice();
					}else{
						throw new CrackerServiceException("Invalid product with id "+orderItem.getId());
					}
				}
				order.setOrderItems(products);
				order.setTotalAmount(totalAmt);
				order.setVat(new Double("0"));
				order.setTax(new Double("0"));
				orderDao.create(order);
			}catch(CrackerServiceException e){
				crackerResponse.setMessage(e.getMessage());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Order details request is empty.");
		}
		
		return crackerResponse;
	}

	private void validateOrderCreationRequest(OrderDetails orderDetails) throws CrackerServiceException{
		if(StringUtils.isEmpty(orderDetails.getEmailId())){
			throw new CrackerServiceException("Customer Email Id is empty.");
		}
		if(StringUtils.isEmpty(orderDetails.getPhoneNumber())){
			throw new CrackerServiceException("Phone number is empty.");
		}
		if(StringUtils.isEmpty(orderDetails.getShippingAddress())){
			throw new CrackerServiceException("Shipping address is empty.");
		}
		if(CollectionUtils.isEmpty(orderDetails.getOrderItems())){
			throw new CrackerServiceException("No products.");
		}
	}
	
	public static void main(String args[]){
		ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("crackerServicesApplicationContext.xml");
		CrackerServiceImpl service = ct.getBean(CrackerServiceImpl.class);
		System.out.println("ajdfkljdfkldj");
	}
}
