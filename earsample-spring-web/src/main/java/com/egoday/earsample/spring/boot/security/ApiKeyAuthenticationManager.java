package com.egoday.earsample.spring.boot.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthenticationManager implements AuthenticationManager {

    @Value("${earsample.http.auth-token}")
    private String authToken;

    @Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String principal = (String) authentication.getPrincipal();

		if (!authToken.equals(principal)) {
			throw new BadCredentialsException("The API key was not found or not the expected value.");
		}

		authentication.setAuthenticated(true);

		return authentication;
	}

}
