package com.salessavvy.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salessavvy.dto.request.AddCartRequest;
import com.salessavvy.dto.response.CartResponse;
import com.salessavvy.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor

public class CartController {

	private final CartService cartService;

	@PostMapping("/add")
	public String addToCart(@RequestBody AddCartRequest request, Authentication authentication) {
		
		String email = authentication.getName();
		
		return cartService.addToCart(request, email);
		
	}
	
	@GetMapping
	public List<CartResponse> getCart(Authentication authentication) {
		
		String email = authentication.getName();
		
		return cartService.getCart(email);
		
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeItem(@PathVariable Long id) {
		
		cartService.removeFromCart(id);
		
	}
	
}
