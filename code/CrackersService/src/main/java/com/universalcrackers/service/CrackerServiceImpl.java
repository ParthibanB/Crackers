package com.universalcrackers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.universalcrackers.dataaccess.CategoryDAO;
import com.universalcrackers.dataaccess.OrderDAO;
import com.universalcrackers.dataaccess.ProductDAO;
import com.universalcrackers.dataaccess.model.Category;
import com.universalcrackers.dataaccess.model.Order;
import com.universalcrackers.dataaccess.model.OrderItems;
import com.universalcrackers.dataaccess.model.Product;
import com.universalcrackers.service.common.CrackersCommon;
import com.universalcrackers.service.model.CategoryVO;
import com.universalcrackers.service.model.CrackerServiceResponse;
import com.universalcrackers.service.model.OrderDetails;
import com.universalcrackers.service.model.ProductVO;

@Service
public class CrackerServiceImpl implements CrackerService {
	
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private OrderDAO orderDao;
	@Autowired
	private CategoryDAO categoryDao;
	
	public CrackerServiceResponse createOrder(OrderDetails orderDetails) {
		CrackerServiceResponse crackerResponse = new CrackerServiceResponse();
		if(orderDetails != null){
			try{
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
				crackerResponse.setMessage(CrackersCommon.SUCCESS_MESSAGE);
				crackerResponse.setCode(CrackersCommon.SUCCESS_CODE);
				crackerResponse.setResponseObject("Order number");
			}catch(CrackerServiceException e){
				crackerResponse.setMessage(e.getMessage());
			}catch(Exception e){
				crackerResponse.setMessage(e.getMessage());
			}
		}else{
			System.out.println("Order details request is empty.");
			crackerResponse.setMessage("Order details request is empty.");
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

	public CrackerServiceResponse getCategories() {
		CrackerServiceResponse crackerResponse = new CrackerServiceResponse();
		try{
			List<Category> categories = categoryDao.findAll();
			crackerResponse.setCode(CrackersCommon.SUCCESS_CODE);
			if(!CollectionUtils.isEmpty(categories)){
				List<CategoryVO> categoriesVo = new ArrayList<CategoryVO>();
				for(Category category : categories){
					CategoryVO categoryVo = new CategoryVO();
					categoryVo.setId(category.getId());
					categoryVo.setName(category.getName());
					//categoryVo.setProductCount(category.getProducts().size());
					categoriesVo.add(categoryVo);
				}
				crackerResponse.setMessage(CrackersCommon.SUCCESS_MESSAGE);
				crackerResponse.setResponseObject(categoriesVo);
			}else{
				crackerResponse.setMessage(CrackersCommon.NO_CATEGORIES_PRESENT);
			}
		}catch(Exception e){
			crackerResponse.setMessage(e.getMessage());
		}
		return crackerResponse;
	}

	public CrackerServiceResponse getProductList(List<Long> categories) {
		CrackerServiceResponse crackerResponse = new CrackerServiceResponse();
		try{
			List<Product> products = productDao.getProducts(categories);
			crackerResponse.setCode(CrackersCommon.SUCCESS_CODE);
			if(!CollectionUtils.isEmpty(products)){
				List<ProductVO> productVos = new ArrayList<ProductVO>();
				for(Product product : products){
					ProductVO productVo = new ProductVO();
					productVo.setDescription(product.getDisplayName());
					productVo.setName(product.getName());
					productVo.setId(product.getId());
					productVo.setUnitPrice(product.getPrice());
					productVos.add(productVo);
				}
				crackerResponse.setMessage(CrackersCommon.SUCCESS_MESSAGE);
				crackerResponse.setResponseObject(productVos);
			}else{
				crackerResponse.setMessage(CrackersCommon.NO_CATEGORIES_PRESENT);
			}
		}catch(Exception e){
			crackerResponse.setMessage(e.getMessage());
		}
		return crackerResponse;
	}
}
