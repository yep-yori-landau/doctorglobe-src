/**
 * @author kkowlgi
 * 
 */
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

import com.dg.data.model.db.HealthcareproviderUnitFeature;
import com.dg.data.service.HealthcareproviderUnitFeatureService;
import com.dg.data.service.FeatureService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.HealthcareproviderunitService;

/**
 * Handles all crud operations for HealthcareproviderUnitFeature table
 */
@Controller
@RequestMapping(value = "/healthcareprovider-unit-feature")
public class HealthcareproviderUnitFeatureController
		extends AbstractController<HealthcareproviderUnitFeature> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderUnitFeatureController.class);

	@Autowired
	public HealthcareproviderUnitFeatureService healthcareproviderunitfeatureService;

	@Autowired
	public FeatureService featureService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderunitService healthcareproviderunitService;

	@Autowired
	public HealthcareproviderUnitFeatureController(
			HealthcareproviderUnitFeatureService healthcareproviderUnitFeatureService) {
		super.setGenericService(healthcareproviderUnitFeatureService);
	}

	/**
	 * 
	 * handle healthcareprovider-unit-feature edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderUnitFeature healthcareproviderUnitFeature,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderUnitFeature",
					healthcareproviderunitfeatureService.get(id));
		}
		model.addAttribute("featureList", featureService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("healthcareproviderunitList",
				healthcareproviderunitService.getAll());

		return "healthcareprovider-unit-feature/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-unit-feature edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderUnitFeature healthcareproviderUnitFeature,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-unit-feature",
					bindingResult.getErrorCount());
			model.addAttribute("featureList", featureService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("healthcareproviderunitList",
					healthcareproviderunitService.getAll());
			return "healthcareprovider-unit-feature/edit";
		}
		healthcareproviderunitfeatureService
				.edit(healthcareproviderUnitFeature);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-unit-feature/index";
	}

}