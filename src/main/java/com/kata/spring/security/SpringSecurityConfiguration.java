package com.kata.spring.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	@Qualifier("getAuthTokenFilter")
	public AuthTokenFilter getAuthTokenFilter() {
		return new AuthTokenFilter(new AuthTokenAuthenticationManager());
	}
	
	@Bean
	@Qualifier("getBearerTokenFilter")
	public BearerTokenFilter getBearerTokenFilter() {
		return new BearerTokenFilter(new BearerTokenAuthenticationManager());
	}
}
