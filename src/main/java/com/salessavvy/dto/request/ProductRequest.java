package com.salessavvy.dto.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductRequest {

	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private int stock;
	
}
