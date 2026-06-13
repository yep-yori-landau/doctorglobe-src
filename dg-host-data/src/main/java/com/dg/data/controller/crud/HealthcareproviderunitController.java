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
import com.dg.data.model.db.Healthcareproviderunit;
import com.dg.data.service.HealthcareproviderunitService;

/**
 * Handles all crud operations for Healthcareproviderunit table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareproviderunit")
public class HealthcareproviderunitController
		extends AbstractController<Healthcareproviderunit> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderunitController.class);

	@Autowired
	public HealthcareproviderunitService healthcareproviderunitService;

	@Autowired
	public HealthcareproviderunitController(
			HealthcareproviderunitService healthcareproviderunitService) {
		super.setGenericService(healthcareproviderunitService);
	}

	/**
	 * 
	 * handle healthcareproviderunit edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Healthcareproviderunit healthcareproviderunit, Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderunit",
					healthcareproviderunitService.get(id));
		}
		return "healthcareproviderunit/edit";
	}

	/**
	 * 
	 * handle healthcareproviderunit edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Healthcareproviderunit healthcareproviderunit,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save healthcareproviderunit",
					bindingResult.getErrorCount());
			return "healthcareproviderunit/edit";
		}
		healthcareproviderunitService.edit(healthcareproviderunit);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareproviderunit/index";
	}

}