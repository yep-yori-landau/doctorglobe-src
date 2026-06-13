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

import com.dg.data.model.db.Healthcareprovidertype;
import com.dg.data.service.HealthcareprovidertypeService;

/**
 * Handles all crud operations for Healthcareprovidertype table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovidertype")
public class HealthcareprovidertypeController
		extends AbstractController<Healthcareprovidertype> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareprovidertypeController.class);

	@Autowired
	public HealthcareprovidertypeService healthcareprovidertypeService;

	@Autowired
	public HealthcareprovidertypeController(
			HealthcareprovidertypeService healthcareprovidertypeService) {
		super.setGenericService(healthcareprovidertypeService);
	}

	/**
	 * 
	 * handle healthcareprovidertype edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Healthcareprovidertype healthcareprovidertype, Model model) {
		if (id != null) {
			model.addAttribute("healthcareprovidertype",
					healthcareprovidertypeService.get(id));
		}
		return "healthcareprovidertype/edit";
	}

	/**
	 * 
	 * handle healthcareprovidertype edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Healthcareprovidertype healthcareprovidertype,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareprovidertype",
					bindingResult.getErrorCount());
			return "healthcareprovidertype/edit";
		}
		healthcareprovidertypeService.edit(healthcareprovidertype);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovidertype/index";
	}
}