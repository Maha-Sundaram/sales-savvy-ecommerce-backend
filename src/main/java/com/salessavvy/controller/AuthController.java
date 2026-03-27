package com.salessavvy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salessavvy.dto.request.LoginRequest;
import com.salessavvy.dto.request.RegisterRequest;
import com.salessavvy.dto.response.AuthResponse;
import com.salessavvy.service.AuthService;

@RestController
@RequestMapping("/auth")

public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/register")
	public String regiter(@RequestBody RegisterRequest request) {

		return authService.register(request);

	}

	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {

		String token = authService.login(request);

		return new AuthResponse(token);

	}

}
