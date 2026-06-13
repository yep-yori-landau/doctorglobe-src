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

import com.dg.data.model.db.HealthcareproviderCuisine;
import com.dg.data.service.HealthcareproviderCuisineService;
import com.dg.data.service.CuisineService;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for HealthcareproviderCuisine table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-cuisine")
public class HealthcareproviderCuisineController
		extends AbstractController<HealthcareproviderCuisine> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderCuisineController.class);

	@Autowired
	public HealthcareproviderCuisineService healthcareprovidercuisineService;

	@Autowired
	public CuisineService cuisineService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderCuisineController(
			HealthcareproviderCuisineService healthcareproviderCuisineService) {
		super.setGenericService(healthcareproviderCuisineService);
	}

	/**
	 * 
	 * handle healthcareprovider-cuisine edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderCuisine healthcareproviderCuisine, Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderCuisine",
					healthcareprovidercuisineService.get(id));
		}
		model.addAttribute("cuisineList", cuisineService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		return "healthcareprovider-cuisine/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-cuisine edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderCuisine healthcareproviderCuisine,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareprovider-cuisine",
					bindingResult.getErrorCount());
			model.addAttribute("cuisineList", cuisineService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareprovider-cuisine/edit";
		}
		healthcareprovidercuisineService.edit(healthcareproviderCuisine);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-cuisine/index";
	}

}