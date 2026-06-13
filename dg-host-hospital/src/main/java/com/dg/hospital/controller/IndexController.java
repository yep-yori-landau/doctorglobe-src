package com.dg.hospital.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.hospital.form.ResetFormValidator;
import com.dg.hospital.form.ResetPasswordForm;
import com.dg.hospital.form.ForgotForm;
import com.dg.hospital.form.LoginForm;
import com.dg.hospital.model.HospitalUserModel;
import com.dg.hospital.service.MailService;
import com.dg.hospital.service.UserService;

@Controller
public class IndexController{
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private ResetFormValidator resetFormValidator;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginAction(@RequestParam(value = "error", required = false) Integer errors,LoginForm loginForm,Model model){
		if(userService.isLoggedIn()){
			return "redirect:/home/index";
		}		
		model.addAttribute("errors",errors);
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
	
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgot(@RequestParam(value = "errors", required = false) Integer errors,ForgotForm forgotForm, Model model) {
		model.addAttribute("errors",errors);
		return "index/forgot";
	}
	
	/**
	 * Forgot Password Handler
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String forgothandler(@Valid ForgotForm forgotform,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {		
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during forgot password user",
					bindingResult.getErrorCount());
			model.addAttribute("errors", 1);
			return "index/forgot";
		}
		HospitalUserModel hospitalUserModel = userService.getHospitalUserModelByEmail(forgotform.getEmail());
		if(hospitalUserModel.getId() != null){		
			mailService.sendResetMail(forgotform.getEmail(), "Reset Password", "Please click below url to change your password.","reset.html",hospitalUserModel.getId().intValue(),hospitalUserModel.getFirstName()+' '+hospitalUserModel.getLastName(),hospitalUserModel.getPassword());
			model.addAttribute("emailaddress", forgotform.getEmail());
			model.addAttribute("errors", 0);
		}else{
			model.addAttribute("errors", 1);
		}
		return "index/forgot";
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	 public String reset(@RequestParam(value = "r", required = false) BigInteger id,@RequestParam(value = "p", required = false) String password,ResetPasswordForm resetPasswordForm,Model model) {
		if(id != null){
			resetPasswordForm.setId(id);
		}
		if(password != null){
			resetPasswordForm.setOldPassword(password);
		}		
		return "index/reset";
	 }	
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resethandler(@ModelAttribute("resetPasswordForm") ResetPasswordForm resetPasswordForm,BindingResult bindingResult,Model model) {		
		model.addAttribute("passworderror", 0);
		resetFormValidator.validate(resetPasswordForm, bindingResult);	
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during hospital user reset password",
			bindingResult.getErrorCount());
			logger.error("message {}",bindingResult.getAllErrors());
			return "index/reset";
		}		
		if(resetPasswordForm.getId() != null && resetPasswordForm.getOldPassword() !=null){
			Boolean result = userService.resetPassword(resetPasswordForm.getId(),resetPasswordForm.getOldPassword(),resetPasswordForm.getNewPassword());
			if(result){
				model.addAttribute("error", 0);
			}else{
				model.addAttribute("error", 1);
			}
		}
		return "index/reset";
	}
}