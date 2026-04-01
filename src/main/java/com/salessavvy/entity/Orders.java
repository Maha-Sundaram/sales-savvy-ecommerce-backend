package com.salessavvy.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Orders extends BaseEntity {

	@ManyToOne
	private User user;

	private BigDecimal totalAmount;

	private String status;
}
