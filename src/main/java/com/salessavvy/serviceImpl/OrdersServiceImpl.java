package com.salessavvy.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salessavvy.entity.CartItem;
import com.salessavvy.entity.OrderItem;
import com.salessavvy.entity.Orders;
import com.salessavvy.entity.User;
import com.salessavvy.repository.CartRepositroy;
import com.salessavvy.repository.OrderItemRepository;
import com.salessavvy.repository.OrdersRepository;
import com.salessavvy.repository.UserRepository;
import com.salessavvy.service.OrdersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class OrdersServiceImpl implements OrdersService{

	private final UserRepository userRepository;
	
	private final CartRepositroy cartRepositroy;
	
	private final OrdersRepository ordersRepository;
	
	private final OrderItemRepository orderItemRepository;

	@Override
	public String checkout(String email) {
		
		User user = userRepository.findByEmail(email).orElseThrow();
		
		List<CartItem> cartItems = cartRepositroy.findByUser(user);
		
		if(cartItems.isEmpty() ) {
			
			throw new RuntimeException("Cart is empty");
			
		}
		
		Orders orders = new Orders();
		
		orders.setUser(user);
		orders.setStatus("CREATED");
		
		Orders savedOrder = ordersRepository.save(orders);
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(CartItem item : cartItems) {
			
			OrderItem orderItem = new OrderItem();
			
			orderItem.setOrders(savedOrder);
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setPrice(item.getProduct().getPrice());
			
			BigDecimal price = item.getProduct().getPrice();
			BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
			
			total = total.add(price.multiply(quantity));
			
			orderItemRepository.save(orderItem);
			
		}
		
		savedOrder.setTotalAmount(total);
		ordersRepository.save(savedOrder);
		
		return "Order placed successfully";
	}

	@Override
	public List<Orders> getUserOrders(String email) {
		
		User user = userRepository.findByEmail(email).orElseThrow();
		
		return ordersRepository.findByUser(user);
	}

	@Override
	public Orders getOrderById(Long id) {
		
		return ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}
	
}
