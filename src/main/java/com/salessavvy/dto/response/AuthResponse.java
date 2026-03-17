package com.salessavvy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {

	private String token;

	public AuthResponse(String token) {
		super();
		this.token = token;
	}
	
}
