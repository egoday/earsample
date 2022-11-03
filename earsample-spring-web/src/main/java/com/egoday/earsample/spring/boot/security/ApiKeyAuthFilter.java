package com.egoday.earsample.spring.boot.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Value("${earsample.http.auth-token-header-name}")
    private String authTokenHeaderName;

    public ApiKeyAuthFilter(ApiKeyAuthenticationManager apiKeyAuthenticationManager) {
    	setAuthenticationManager(apiKeyAuthenticationManager);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(authTokenHeaderName);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }

}
