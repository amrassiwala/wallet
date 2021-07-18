package com.saltside.wallet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		boolean auth = true;
		
		if(auth)
			chain.doFilter(request, response);
		else
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid Auth Credentials");
		
	}

	
	
}
