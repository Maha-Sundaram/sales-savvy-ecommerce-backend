package com.salessavvy.serviceImpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salessavvy.dto.request.LoginRequest;
import com.salessavvy.dto.request.RegisterRequest;
import com.salessavvy.entity.User;
import com.salessavvy.repository.UserRepository;
import com.salessavvy.service.AuthService;
import com.salessavvy.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService{

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final JwtUtil jwtUtil;

	public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public String register(RegisterRequest request) {

        Optional<User> existing = userRepository.findByEmail(request.getEmail());
        
        if (existing.isPresent()) {
            return "User with this email already exists";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }

	@Override
	public String login(LoginRequest request) {

		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

			throw new RuntimeException("Invalid credentials");

		}

		return jwtUtil.generateToken(user.getEmail());
	}



}
