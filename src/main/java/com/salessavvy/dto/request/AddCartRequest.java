package com.salessavvy.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AddCartRequest {

	private Long productId;
	
	private int quantity;
	
}
