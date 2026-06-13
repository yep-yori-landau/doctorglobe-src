
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

import com.dg.data.model.db.HealthcareproviderRatings;
import com.dg.data.service.HealthcareproviderRatingsService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.RatingcompaniesService;

/**
 * Handles all crud operations for HealthcareproviderRatings table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-ratings")
public class HealthcareproviderRatingsController
		extends AbstractController<HealthcareproviderRatings> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderRatingsController.class);

	@Autowired
	public HealthcareproviderRatingsService healthcareproviderratingsService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public RatingcompaniesService ratingcompaniesService;

	@Autowired
	public HealthcareproviderRatingsController(
			HealthcareproviderRatingsService healthcareproviderRatingsService) {
		super.setGenericService(healthcareproviderRatingsService);
	}

	/**
	 * 
	 * handle healthcareprovider-ratings edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderRatings healthcareproviderRatings, Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderRatings",
					healthcareproviderratingsService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("ratingcompaniesList",
				ratingcompaniesService.getAll());
		return "healthcareprovider-ratings/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-ratings edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderRatings healthcareproviderRatings,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareprovider-ratings",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("ratingcompaniesList",
					ratingcompaniesService.getAll());
			return "healthcareprovider-ratings/edit";
		}
		healthcareproviderratingsService.edit(healthcareproviderRatings);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-ratings/index";
	}

}