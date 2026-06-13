package com.dg.data.controller.crud;

import java.io.File;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dg.data.model.db.Practitioner;
import com.dg.data.service.PractitionerService;
import com.dg.data.service.PractitionertypeService;
import com.dg.data.service.AclRolesService;
import com.dg.data.service.CityService;

/**
 * Handles all crud operations for Practitioner table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/practitioner")
public class PractitionerController
		extends AbstractCrudController<Practitioner> {

	private static final Logger logger = LoggerFactory
			.getLogger(PractitionerController.class);

	@Autowired
	public PractitionerService practitionerService;

	@Autowired
	public PractitionertypeService practitionertypeService;

	@Autowired
	public AclRolesService aclRolesService;

	@Autowired
	public CityService cityService;

	@Autowired
	public PractitionerController(PractitionerService practitionerService) {
		super.setGenericService(practitionerService);
	}

	/**
	 * 
	 * handle practitioner edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Practitioner practitioner, Model model) {
		if (id != null) {
			model.addAttribute("practitioner", practitionerService.get(id));
		}
		model.addAttribute("practitionertypeList",
				practitionertypeService.getAll());
		model.addAttribute("aclRolesList", aclRolesService.getAll());
		model.addAttribute("cityList", cityService.getAll());
		return "practitioner/edit";
	}

	/**
	 * 
	 * handle practitioner edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Practitioner practitioner,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			@RequestParam("file") MultipartFile file, Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save practitioner",
					bindingResult.getErrorCount());
			model.addAttribute("practitionertypeList",
					practitionertypeService.getAll());
			model.addAttribute("aclRolesList", aclRolesService.getAll());
			model.addAttribute("cityList", cityService.getAll());
			return "practitioner/edit";
		}
		try {
			if (!file.isEmpty()) {
				try {
					String filename = file.getOriginalFilename();
					File f = new File("/tmp/" + file.getOriginalFilename());
					file.transferTo(f);
					practitioner.setPhoto(filename);
				}
				catch (Exception ex) {
					logger.info(ex.getMessage());
				}
			}
			if (practitioner.getId() != null) {
				Practitioner practitionerModel = practitionerService
						.get(practitioner.getId().intValue());
				if (!practitionerModel.getPassword()
						.equals(practitioner.getPassword())) {
					practitioner.setPassword(practitionerService
							.getSHA1(practitioner.getPassword()));
				}
				practitionerService.edit(practitioner);
			}
			else {
				practitionerService.edit(practitioner);
			}
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/practitioner/index";
	}
}