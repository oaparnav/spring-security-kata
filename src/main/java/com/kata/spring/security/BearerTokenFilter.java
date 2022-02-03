package com.kata.spring.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class BearerTokenFilter extends AbstractPreAuthenticatedProcessingFilter {
	private String headerName = "Authorization";
	
	public BearerTokenFilter(AuthenticationManager authTokenAuthenticationManager) {
		super();
		this.setAuthenticationManager(authTokenAuthenticationManager);
	}

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		return request.getHeader(headerName);
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return null;
	}

}
