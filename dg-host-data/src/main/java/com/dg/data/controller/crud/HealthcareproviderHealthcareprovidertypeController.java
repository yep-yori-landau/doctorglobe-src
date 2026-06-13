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

import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;
import com.dg.data.service.HealthcareproviderHealthcareprovidertypeService;
import com.dg.data.service.HealthcareprovidertypeService;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for HealthcareproviderHealthcareprovidertype
 * table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-healthcareprovidertype")
public class HealthcareproviderHealthcareprovidertypeController
		extends AbstractController<HealthcareproviderHealthcareprovidertype> {

	private static final Logger logger = LoggerFactory.getLogger(
			HealthcareproviderHealthcareprovidertypeController.class);

	@Autowired
	public HealthcareproviderHealthcareprovidertypeService healthcareproviderHealthcareprovidertypeService;

	@Autowired
	public HealthcareprovidertypeService healthcareprovidertypeService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderHealthcareprovidertypeController(
			HealthcareproviderHealthcareprovidertypeService healthcareproviderHealthcareprovidertypeService) {
		super.setGenericService(
				healthcareproviderHealthcareprovidertypeService);
	}

	/**
	 * 
	 * handle healthcareprovider-healthcareprovidertype edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderHealthcareprovidertype healthcareproviderHealthcareprovidertype,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderHealthcareprovidertype",
					healthcareproviderHealthcareprovidertypeService.get(id));
		}
		model.addAttribute("healthcareprovidertypeList",
				healthcareprovidertypeService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		return "healthcareprovider-healthcareprovidertype/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-healthcareprovidertype edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderHealthcareprovidertype healthcareproviderHealthcareprovidertype,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-healthcareprovidertype",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareprovidertypeList",
					healthcareprovidertypeService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareprovider-healthcareprovidertype/edit";
		}
		healthcareproviderHealthcareprovidertypeService
				.edit(healthcareproviderHealthcareprovidertype);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-healthcareprovidertype/index";
	}
}