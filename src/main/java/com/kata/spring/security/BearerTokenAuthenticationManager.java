package com.kata.spring.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BearerTokenAuthenticationManager implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String principal = authentication.getPrincipal().toString();
		if (!("xyz".equals(principal))) {
			log.error(">>>>Authentication Failed");
			throw new BadCredentialsException("Invalid token");
		}
		log.info(">>>>Authentication successful");
		authentication.setAuthenticated(true);
		return authentication;
	}

}
