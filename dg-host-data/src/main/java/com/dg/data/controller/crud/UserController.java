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

import com.dg.data.model.db.User;
import com.dg.data.model.validator.UserValidator;
import com.dg.data.service.UserService;
import com.dg.data.service.AclRolesService;

/**
 * Handles all crud operations for User table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractCrudController<User> {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	public UserService userService;

	@Autowired
	public AclRolesService aclRolesService;

	@Autowired
	public UserValidator userValidator;

	@Autowired
	public UserController(UserService userService) {
		super.setGenericService(userService);
	}

	/**
	 * 
	 * handle user edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			User user, Model model) {
		if (id != null) {
			model.addAttribute("user", userService.get(id));
		}
		model.addAttribute("aclRolesList", aclRolesService.getAll());
		return "user/edit";
	}

	/**
	 * 
	 * handle user edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save user",
					bindingResult.getErrorCount());
			model.addAttribute("aclRolesList", aclRolesService.getAll());

			return "user/edit";
		}
		try {
			if (user.getId() != null) {
				User userModel = userService.get(user.getId().intValue());
				if (userModel.getPassword().equals(user.getPassword())) {
					userService.edit(user);
				}
				else {
					user.setPassword(userService.getSHA1(user.getPassword()));
					userService.edit(user);
				}
			}
			else {
				userService.edit(user);
			}
			redirectAttributes.addFlashAttribute("message",
					"Successfully Created/Edited");
		}
		catch (Exception ex) {
			logger.info("save action error found {}", ex.getMessage());
		}
		return "redirect:/user/index";
	}
}