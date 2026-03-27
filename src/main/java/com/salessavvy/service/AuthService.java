package com.salessavvy.service;

import com.salessavvy.dto.request.LoginRequest;
import com.salessavvy.dto.request.RegisterRequest;

public interface AuthService {

	String register(RegisterRequest request);

	String login(LoginRequest request);

}
