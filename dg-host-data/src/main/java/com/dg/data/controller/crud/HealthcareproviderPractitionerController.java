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

import com.dg.data.model.db.HealthcareproviderPractitioner;
import com.dg.data.service.HealthcareproviderPractitionerService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.PractitionerService;
import com.dg.data.service.PractitionertypeService;

/**
 * Handles all crud operations for HealthcareproviderPractitioner table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-practitioner")
public class HealthcareproviderPractitionerController
		extends AbstractController<HealthcareproviderPractitioner> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderPractitionerController.class);

	@Autowired
	public HealthcareproviderPractitionerService healthcareproviderPractitionerService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public PractitionerService practitionerService;

	@Autowired
	public PractitionertypeService practitionertypeService;

	@Autowired
	public HealthcareproviderPractitionerController(
			HealthcareproviderPractitionerService healthcareproviderPractitionerService) {
		super.setGenericService(healthcareproviderPractitionerService);
	}

	/**
	 * 
	 * handle healthcareprovider-practitioner edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderPractitioner healthcareproviderPractitioner,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderPractitioner",
					healthcareproviderPractitionerService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("practitionerList", practitionerService.getAll());
		model.addAttribute("practitionertypeList",
				practitionertypeService.getAll());
		return "healthcareprovider-practitioner/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-practitioner edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderPractitioner healthcareproviderPractitioner,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-practitioner",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("practitionerList",
					practitionerService.getAll());
			model.addAttribute("practitionertypeList",
					practitionertypeService.getAll());
			return "healthcareprovider-practitioner/edit";
		}
		healthcareproviderPractitionerService
				.edit(healthcareproviderPractitioner);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-practitioner/index";
	}

}