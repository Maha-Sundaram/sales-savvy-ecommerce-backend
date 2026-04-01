package com.salessavvy.entity;

import jakarta.persistence.OneToOne;

public class Payment extends BaseEntity {

	@OneToOne
	private Orders orders;

	private String paymentMethod;

	private String paymentStatus;

}
