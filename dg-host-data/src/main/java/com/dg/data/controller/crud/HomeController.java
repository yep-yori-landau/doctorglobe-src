package com.dg.data.controller.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles Home controller request
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * 
	 * handle home index get action
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "home/index";
	}
}
