package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.dao.UserRepository;
import com.jwt.entity.User;
import com.jwt.security.SecurityUser;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User signUp(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User user2 = userRepository.save(user);
		return user2;
	}
	
	public User authenticateUser(User user) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		
		User user2 = userRepository.findUserByEmail(user.getEmail());
		return user2;
	}
	
	public User getUser(int id) {
		User user = userRepository.findById(id).get();
		return user;
	}

}
