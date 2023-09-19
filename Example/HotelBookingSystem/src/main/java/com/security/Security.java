package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indicates that the class has @Bean definition methods
public class Security {
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// Needs authentication
		http.authorizeHttpRequests().anyRequest().authenticated();

		http.httpBasic();

		// http.formLogin();
		http.csrf().disable();

		return http.build();
	}
}
