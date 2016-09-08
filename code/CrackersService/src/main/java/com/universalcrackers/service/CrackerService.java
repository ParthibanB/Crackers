package com.universalcrackers.service;

import com.universalcrackers.service.model.CrackerServiceResponse;
import com.universalcrackers.service.model.OrderDetails;

public interface CrackerService {

	public CrackerServiceResponse createOrder(OrderDetails orderDetails);
}
