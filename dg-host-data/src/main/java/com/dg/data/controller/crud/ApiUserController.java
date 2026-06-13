package com.dg.data.controller.crud;

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

import com.dg.data.model.db.ApiUser;
import com.dg.data.model.validator.ApiUserValidator;
import com.dg.data.service.ApiUserService;

/**
 * Handles all crud operations for User table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/api-user")
public class ApiUserController extends AbstractCrudController<ApiUser> {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	public ApiUserService apiUserService;
	
	@Autowired
	public ApiUserValidator apiUserValidator;

	@Autowired
	public ApiUserController(ApiUserService apiUserService) {
		super.setGenericService(apiUserService);
	}

	/**
	 * 
	 * handle user edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			ApiUser apiUser, Model model) {
		if (id != null) {
			model.addAttribute("apiUser", apiUserService.get(id));
		}		
		return "api-user/edit";
	}

	/**
	 * 
	 * handle user edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("apiUser") ApiUser apiUser,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		apiUserValidator.validate(apiUser, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save user",
					bindingResult.getErrorCount());
			return "api-user/edit";
		}
		try {
			if (apiUser.getId() != null) {
				ApiUser apiUserModel = apiUserService.get(apiUser.getId().intValue());
				if (apiUserModel.getPassword().equals(apiUser.getPassword())) {
					apiUserService.edit(apiUser);
				}
				else {
					apiUser.setPassword(apiUserService.getSHA1(apiUser.getPassword()));
					apiUserService.edit(apiUser);
				}
			}
			else {
				apiUserService.edit(apiUser);
			}
			redirectAttributes.addFlashAttribute("message",
					"Successfully Created/Edited");
		}
		catch (Exception ex) {
			logger.info("save action error found {}", ex.getMessage());
		}
		return "redirect:/api-user/index";
	}
}