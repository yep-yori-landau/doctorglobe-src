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

import com.dg.data.model.db.HealthcareproviderAccreditation;
import com.dg.data.service.HealthcareproviderAccreditationService;
import com.dg.data.service.AccreditationService;
import com.dg.data.service.HealthcareproviderService;

/**
 * Handles all crud operations for HealthcareproviderAccreditation table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-accreditation")
public class HealthcareproviderAccreditationController
		extends AbstractController<HealthcareproviderAccreditation> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderAccreditationController.class);

	@Autowired
	public HealthcareproviderAccreditationService healthcareprovideraccreditationService;

	@Autowired
	public AccreditationService accreditationService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public HealthcareproviderAccreditationController(
			HealthcareproviderAccreditationService healthcareproviderAccreditationService) {
		super.setGenericService(healthcareproviderAccreditationService);
	}

	/**
	 * 
	 * handle healthcareprovider-accreditation edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderAccreditation healthcareproviderAccreditation,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderAccreditation",
					healthcareprovideraccreditationService.get(id));
		}
		model.addAttribute("accreditationList", accreditationService.getAll());
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		return "healthcareprovider-accreditation/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-accreditation edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderAccreditation healthcareproviderAccreditation,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-accreditation",
					bindingResult.getErrorCount());
			model.addAttribute("accreditationList",
					accreditationService.getAll());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			return "healthcareprovider-accreditation/edit";
		}
		healthcareprovideraccreditationService
				.edit(healthcareproviderAccreditation);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-accreditation/index";
	}

}