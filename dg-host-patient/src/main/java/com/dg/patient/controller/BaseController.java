package com.dg.patient.controller;

import java.math.BigInteger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.dg.patient.model.PatientModel;
import com.dg.patient.model.UserModel;
import com.dg.patient.service.UserService;
/**
 * 
 * @author DoctorGlobe
 *
 */
public abstract class BaseController {

	@Autowired
	private UserService userService;

	@ModelAttribute("userImage")
	public String getUserImage() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			PatientModel model = userService
					.getPatientByEmail(user.getUsername());
			return "/doctorglobe/patient/" + user.getId() + "/photo/"
					+ model.getPhoto();
		}
		return null;
	}

	@ModelAttribute("userName")
	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Object myuser = (auth != null) ? auth.getPrincipal() : null;
		if (myuser instanceof UserModel) {
			UserModel user = (UserModel) myuser;
			return user.getName();
		}
		return null;
	}

	@ModelAttribute("userAgreement")
	public Boolean getUserAgreement() {
		return userService.getUserAgreement();
	}

	@ModelAttribute("associateUser")
	public Boolean getAssociateUser() {
		return userService.getAssociateUser();
	}

	@ModelAttribute("theme")
	public String getTheme(HttpServletRequest request) {
		return userService.getUserTheme(request);
	}

	@ModelAttribute("isProfileShow")
	public Boolean getIsProfileShow() {
		return userService.getIsProfileShow();
	}
	
	@ModelAttribute("isMyareaShow")
	public Boolean getIsMyareaShow() {
		return userService.getIsMyareaShow();
	}

	@ModelAttribute("associateId")
	public BigInteger getAssociateId() {
		return userService.getAssociateId();
	}
}