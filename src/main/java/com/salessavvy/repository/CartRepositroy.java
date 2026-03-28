package com.salessavvy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salessavvy.entity.CartItem;
import com.salessavvy.entity.User;

public interface CartRepositroy extends JpaRepository<CartItem, Long>{

	List<CartItem> findByUser(User user);
	
	Optional<CartItem> findByUserAndProduct(User user);
	
}
