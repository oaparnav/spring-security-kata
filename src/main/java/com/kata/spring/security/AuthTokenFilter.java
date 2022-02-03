package com.kata.spring.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class AuthTokenFilter extends AbstractPreAuthenticatedProcessingFilter {
	private String authHeaderName = "auth-token";
	
	public AuthTokenFilter(AuthenticationManager authTokenAuthenticationManager) {
		super();
		this.setAuthenticationManager(authTokenAuthenticationManager);
	}

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		return request.getHeader(authHeaderName);
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return null;
	}

}
