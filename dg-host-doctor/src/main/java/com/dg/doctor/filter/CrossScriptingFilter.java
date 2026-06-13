package com.dg.doctor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossScriptingFilter implements Filter{
	
	private static final Logger logger = LoggerFactory.getLogger(CrossScriptingFilter.class);	

	public void init(FilterConfig filterConfig) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {    	
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);        
    }	
}