package com.salessavvy.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salessavvy.dto.request.AddCartRequest;
import com.salessavvy.dto.response.CartResponse;
import com.salessavvy.entity.CartItem;
import com.salessavvy.entity.Product;
import com.salessavvy.entity.User;
import com.salessavvy.repository.CartRepositroy;
import com.salessavvy.repository.ProductRepository;
import com.salessavvy.repository.UserRepository;
import com.salessavvy.service.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CartServiceImpl implements CartService{
	
	private final CartRepositroy cartRepositroy;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;
	
	@Override
	public String addToCart(AddCartRequest request, String email) {
		
		User user = userRepository.findByEmail(email).orElseThrow();
		
		Product product = productRepository.findById(request.getProductId()).orElseThrow();
		
		CartItem cartItem = new CartItem();
		
		cartItem.setUser(user);
		cartItem.setProduct(product);
		cartItem.setQuantity(request.getQuantity());
		
		cartRepositroy.save(cartItem);
		
		return "Product added to cart";
	}

	@Override
	public List<CartResponse> getCart(String email) {
		
		User user = userRepository.findByEmail(email).orElseThrow();
		
		List<CartItem> items = cartRepositroy.findByUser(user);
		
		return items.stream().map(item -> new CartResponse(
				item.getId(), item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice())).toList();
	}

	@Override
	public void removeFromCart(Long id) {
		
		cartRepositroy.deleteById(id);
		
	}

}
