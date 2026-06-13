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

import com.dg.data.model.db.HealthcareproviderAmenity;
import com.dg.data.service.HealthcareproviderAmenityService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.AmenityService;

/**
 * Handles all crud operations for HealthcareproviderAmenity table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-amenity")
public class HealthcareproviderAmenityController
		extends AbstractController<HealthcareproviderAmenity> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderAmenityController.class);

	@Autowired
	public HealthcareproviderAmenityService healthcareprovideramenityService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public AmenityService amenityService;

	@Autowired
	public HealthcareproviderAmenityController(
			HealthcareproviderAmenityService healthcareproviderAmenityService) {
		super.setGenericService(healthcareproviderAmenityService);
	}

	/**
	 * 
	 * handle healthcareprovider-amenity edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderAmenity healthcareproviderAmenity, Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderAmenity",
					healthcareprovideramenityService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("amenityList", amenityService.getAll());

		return "healthcareprovider-amenity/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-amenity edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderAmenity healthcareproviderAmenity,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareprovider-amenity",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("amenityList", amenityService.getAll());
			return "healthcareprovider-amenity/edit";
		}
		healthcareprovideramenityService.edit(healthcareproviderAmenity);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-amenity/index";
	}

}