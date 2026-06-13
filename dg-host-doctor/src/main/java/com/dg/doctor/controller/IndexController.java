package com.dg.doctor.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.doctor.form.LoginForm;
import com.dg.doctor.service.MailService;
import com.dg.doctor.service.UserService;
/**
 * 
 * Handles requests for the application home page.
 *
 */
@Controller
public class IndexController
{
	private static final Logger logger = LoggerFactory
			.getLogger(IndexController.class);
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@RequestParam(value = "error", required = false) Integer error,LoginForm loginForm, Model model) {
		model.addAttribute("error",error);
		model.addAttribute("loginerror",1);
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
			logger.error("Got {} errors during authentication practitioner",
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