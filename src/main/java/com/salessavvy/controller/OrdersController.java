package com.salessavvy.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salessavvy.entity.Orders;
import com.salessavvy.service.OrdersService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrdersController {

	private final OrdersService ordersService;
	
	@PostMapping("/checkout")
	public String checkout(Authentication authentication) {
		
		String email = authentication.getName();
		
		return ordersService.checkout(email);
		
	}
	
	@GetMapping
	public List<Orders> getOrders(Authentication authentication) {
		
		String email = authentication.getName();
		
		return ordersService.getUserOrders(email);
		
	}
	
	@GetMapping("/{id}")
	public Orders getOrder(@PathVariable Long id) {
		
		return ordersService.getOrderById(id);
		
	}
	
	
	
}
