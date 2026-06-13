package com.dg.data.controller.crud;

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

import com.dg.data.model.db.HealthcareproviderUser;
import com.dg.data.service.HealthcareproviderUserService;
import com.dg.data.service.UserService;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for HealthcareproviderUserController table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-user")
public class HealthcareproviderUserController
		extends AbstractController<HealthcareproviderUser> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderUserController.class);

	@Autowired
	public HealthcareproviderUserService healthcareprovideruserService;

	@Autowired
	public UserService userService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderUserController(
			HealthcareproviderUserService healthcareprovideruserService) {
		super.setGenericService(healthcareprovideruserService);
	}

	/**
	 * 
	 * handle healthcareprovider-user edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderUser healthcareproviderUser, Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderUser",
					healthcareprovideruserService.get(id));
		}
		model.addAttribute("userList", userService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		return "healthcareprovider-user/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-user edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid HealthcareproviderUser healthcareproviderUser,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareprovider-user",
					bindingResult.getErrorCount());
			model.addAttribute("userList", userService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareprovider-user/edit";
		}
		healthcareprovideruserService.edit(healthcareproviderUser);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-user/index";
	}
}