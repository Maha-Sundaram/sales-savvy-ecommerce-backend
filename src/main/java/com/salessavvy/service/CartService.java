package com.salessavvy.service;

import java.util.List;

import com.salessavvy.dto.request.AddCartRequest;
import com.salessavvy.dto.response.CartResponse;

public interface CartService {

	String addToCart(AddCartRequest request, String email);
	
	List<CartResponse> getCart(String email);
	
	void removeFromCart(Long id);
	
}
