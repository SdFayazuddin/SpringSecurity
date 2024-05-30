package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.User;
import com.jwt.security.JwtService;
import com.jwt.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		return userService.signUp(user);
	}
	
	@GetMapping("/get")
	public User getUser(@RequestParam(name = "id") int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		
		User authenticatedUser = userService.authenticateUser(user);
		String jwtToken = jwtService.generateToken(authenticatedUser.getEmail());
		
		return jwtToken;
	}
	
	@GetMapping("/secured")
	public String secured() {
		return "Hi you are authenticated";
	}

}
