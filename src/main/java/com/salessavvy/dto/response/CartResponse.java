package com.salessavvy.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class CartResponse {

	private Long id;
	
	private String productName;
	
	private int quantity;
	
	private BigDecimal price;
	
}
