package com.dg.hospital.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.LoginForm;

@Controller
public class IndexController{
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginAction(@RequestParam(value = "error", required = false) Integer error,LoginForm loginForm,Model model){
		model.addAttribute("error",error);
		return "index/login";
	}
	
	/**
	 * Login
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String authentication(@Valid LoginForm loginform,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		logger.info("authentication action called");
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during authentication hospital user",
					bindingResult.getErrorCount());
			return "index/login";
		}
		return "null";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {
		logger.info("practitioner logout successfully");
	}	
}