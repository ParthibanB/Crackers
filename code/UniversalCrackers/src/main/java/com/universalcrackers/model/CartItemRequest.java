package com.universalcrackers.model;

import java.util.List;

public class CartItemRequest {
	private List<CartItem> cartItems;
	
	public CartItemRequest(){
		
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}	
}
