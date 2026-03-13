package com.salessavvy.entity;

import jakarta.persistence.OneToOne;

public class Payment extends BaseEntity {

	@OneToOne
	private Order order;
	
	private String paymentMethod;
	
	private String paymentStatus;
	
}
