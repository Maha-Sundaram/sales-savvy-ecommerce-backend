package com.salessavvy.service;

import java.util.List;

import com.salessavvy.entity.Orders;

public interface OrdersService {

	String checkout(String email);
	
	List<Orders> getUserOrders(String email);
	
	Orders getOrderById(Long id);
}
