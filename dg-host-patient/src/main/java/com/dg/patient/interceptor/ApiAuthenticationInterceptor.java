package com.dg.patient.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dg.patient.exception.ApiException;
import com.dg.patient.service.ApiService;

public class ApiAuthenticationInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApiAuthenticationInterceptor.class);
	
	private ApiService apiService;
	
	public void setApiService(ApiService apiService){
		this.apiService = apiService;
	}
	
	public ApiService getApiService(){
		return this.apiService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws ApiException {
		logger.info("data ");
		if(request.getHeader("user_name") != null && request.getHeader("password") != null){
			if(!apiService.getAuthentication(request.getHeader("user_name"), request.getHeader("password"))){
				throw new ApiException("Bad credentials",1001);				
			}
		}else{
			throw new ApiException("Bad credentials",1001);
		}
		return true;
	}
	
}