package com.example.demo.config;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.entity.Authority;

public class AuthorityService implements GrantedAuthority {

	private final Authority authority;

	public AuthorityService(Authority authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority.getRole();
	}

}
