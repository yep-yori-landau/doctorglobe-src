package com.dg.patient.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dg.patient.service.UserService;
/**
 * @author DoctorGlobe
 * 
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(AuthenticationInterceptor.class);

	private UserService userService;

	/**
	 * 
	 * @return userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * 
	 * @param userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if (!userService.isLoggedIn()) {			
			logger.info("Access denied");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		if (userService.isLoggedIn() && userService.getAssociateUser()) {	
			logger.info("Access denied");
			response.sendRedirect(request.getContextPath() + "/admin-area");
			return false;
		}
		
		String currentUri = request.getRequestURI().toString();
		if(currentUri.contains("profile") && !userService.getIsProfileShow()){
			logger.info("Access denied");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		if(currentUri.contains("myarea") && !userService.getIsMyareaShow()){
			logger.info("Access denied");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		if(currentUri.contains("select-doc") && !userService.getIsMyareaShow()){
			logger.info("Access denied");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		
		return true;
	}
}