package com.salessavvy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class CartItem extends BaseEntity {

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Product product;
	
	private int quantity;
}
