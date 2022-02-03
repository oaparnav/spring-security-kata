package com.kata.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("getAuthTokenFilter")
	private AuthTokenFilter authTokenFilter;

	@Autowired
	@Qualifier("getBearerTokenFilter")
	private BearerTokenFilter bearerTokenFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.addFilter(authTokenFilter)
			.addFilter(bearerTokenFilter)
			.authorizeRequests().anyRequest().authenticated();
	}
}
