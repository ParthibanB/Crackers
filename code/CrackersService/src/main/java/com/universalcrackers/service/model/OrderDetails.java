package com.universalcrackers.service.model;

import java.util.List;

public class OrderDetails {

	private String emailId;
	private String phoneNumber;
	private String shippingAddress;
	private Double orderTotal;
	private Long orderId;
	private String orderReferenceNo;
	private Double taxAmt;
	private Double vat;
	private List<ProductVO> orderItems;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderReferenceNo() {
		return orderReferenceNo;
	}
	public void setOrderReferenceNo(String orderReferenceNo) {
		this.orderReferenceNo = orderReferenceNo;
	}
	public Double getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(Double taxAmt) {
		this.taxAmt = taxAmt;
	}
	public Double getVat() {
		return vat;
	}
	public void setVat(Double vat) {
		this.vat = vat;
	}
	public List<ProductVO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<ProductVO> orderItems) {
		this.orderItems = orderItems;
	}
}
