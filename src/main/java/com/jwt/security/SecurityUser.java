package com.jwt.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.dao.UserRepository;
import com.jwt.entity.User;

@Service
public class SecurityUser implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByEmail(username);
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("Admin"));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
	
	

}
