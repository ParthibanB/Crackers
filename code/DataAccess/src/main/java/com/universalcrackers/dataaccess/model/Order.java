/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universalcrackers.dataaccess.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;
    
    @Column(name = "refNo")
    private String refNo;
    
    @Column(name = "emailId")
    private String emailId;
    
    @Column(name = "shippingAddress")
    private String shippingAddress;
    
    @Column(name = "mobileNumber")
    private String mobileNumber;
    
    @Column(name = "totalAmount")
    private Double totalAmount;
    
    @Column(name = "tax")
    private Double tax;
    
    @Column(name = "vat")
    private Double vat;
    
    @Column(name = "productTotal")
    private Long productTotal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = OrderItems.class)
	@JoinColumn(name = "orderId")
    private Collection<OrderItems> orderItems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Long getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(Long productTotal) {
		this.productTotal = productTotal;
	}

	public Collection<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Collection<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
}
