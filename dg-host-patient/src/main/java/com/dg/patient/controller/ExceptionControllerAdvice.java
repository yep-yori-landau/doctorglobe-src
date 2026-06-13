package com.dg.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle Global Error 
 * @author DoctorGlobe
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LoggerFactory
			.getLogger(ExceptionControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error/error");
		logger.info("Exception found {}", ex.getMessage());
		model.addObject("exception", ex.getMessage());
		return model;
	}

}