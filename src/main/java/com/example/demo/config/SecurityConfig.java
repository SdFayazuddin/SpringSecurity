package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("Fayaz").authorities("Admin").password(passwordEncoder().encode("Chotu")).build();
		UserDetails user2 = User.builder().username("Manohar").authorities("User").password(passwordEncoder().encode("Manohar")).build();
		UserDetails user3 = User.builder().username("Madhu").authorities("User").password(passwordEncoder().encode("Madhu")).build();
		return new InMemoryUserDetailsManager(user,user2,user3);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain defauSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/hi","bye","/hello")
				.authenticated()
				.requestMatchers("/openApi")
				.permitAll()
				.requestMatchers("/noAccess")
				.denyAll()
				)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}

}
