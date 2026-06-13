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

import com.dg.data.model.db.AclPermissions;
import com.dg.data.service.AclPermissionsService;
import com.dg.data.service.AclResourcesService;
import com.dg.data.service.AclRolesService;

/**
 * Handles all crud operations for AclPermissions table.
 * @author DoctorGlobe
 */

@Controller
@RequestMapping(value = "/acl-permissions")
public class AclPermissionsController
		extends AbstractController<AclPermissions> {

	private static final Logger logger = LoggerFactory
			.getLogger(AclPermissionsController.class);

	@Autowired
	public AclPermissionsService aclpermissionsService;

	@Autowired
	public AclResourcesService aclResourcesService;

	@Autowired
	public AclRolesService aclRolesService;

	@Autowired
	public AclPermissionsController(
			AclPermissionsService aclpermissionsService) {
		super.setGenericService(aclpermissionsService);
	}

	/**
	 * 
	 * handle acl-permissions edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			AclPermissions aclPermissions, Model model) {
		if (id != null) {
			model.addAttribute("aclPermissions", aclpermissionsService.get(id));
		}
		model.addAttribute("aclResourcesList", aclResourcesService.getAll());
		model.addAttribute("aclRolesList", aclRolesService.getAll());
		return "acl-permissions/edit";
	}

	/**
	 * 
	 * handle acl-permissions edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid AclPermissions aclPermissions,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save acl-permissions",
					bindingResult.getErrorCount());
			model.addAttribute("aclResourcesList",
					aclResourcesService.getAll());
			model.addAttribute("aclRolesList", aclRolesService.getAll());
			return "acl-permissions/edit";
		}
		aclpermissionsService.edit(aclPermissions);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/acl-permissions/index";
	}

}