package com.dg.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Handles all errors pages
 * @author DoctorGlobe
 *
 */
@Controller
public class ErrorController {

	/**
	 * Gets /404 error page
	 * @return String error page
	 */
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String handleError404() {
		return "/error/404";
	}

	/**
	 * Gets /500 error page
	 * @return String error page
	 */
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String handleError500() {
		return "/error/error";
	}
}