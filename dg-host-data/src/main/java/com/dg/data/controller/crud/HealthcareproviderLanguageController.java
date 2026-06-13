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

import com.dg.data.model.db.HealthcareproviderLanguage;
import com.dg.data.service.HealthcareproviderLanguageService;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for HealthcareproviderLanguage table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-language")
public class HealthcareproviderLanguageController
		extends AbstractController<HealthcareproviderLanguage> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderLanguageController.class);

	@Autowired
	public HealthcareproviderLanguageService healthcareproviderlanguageService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderLanguageController(
			HealthcareproviderLanguageService healthcareproviderLanguageService) {
		super.setGenericService(healthcareproviderLanguageService);
	}

	/**
	 * 
	 * handle healthcareprovider-language edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderLanguage healthcareproviderLanguage,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderLanguage",
					healthcareproviderlanguageService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		return "healthcareprovider-language/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-language edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderLanguage healthcareproviderLanguage,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-language",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareprovider-language/edit";
		}
		healthcareproviderlanguageService.edit(healthcareproviderLanguage);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-language/index";
	}
}