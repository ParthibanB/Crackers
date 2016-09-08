package com.universalcrackers.service;

import java.util.List;

import com.universalcrackers.service.model.CrackerServiceResponse;
import com.universalcrackers.service.model.OrderDetails;

public interface CrackerService {

	public CrackerServiceResponse createOrder(OrderDetails orderDetails);
	
	public CrackerServiceResponse getCategories();
	
	public CrackerServiceResponse getProductList(List<Long> categories);
}
