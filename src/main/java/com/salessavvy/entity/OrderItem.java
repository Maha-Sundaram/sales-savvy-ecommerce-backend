package com.salessavvy.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class OrderItem extends BaseEntity {

	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;
	
	private int quantity;
	
	private BigDecimal price;
	
}
