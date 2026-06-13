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

import com.dg.data.model.db.HealthcareproviderSpecialty;
import com.dg.data.service.HealthcareproviderSpecialtyService;
import com.dg.data.service.HealthcareproviderService;
import com.dg.data.service.SpecialtyService;

/**
 * Handles requests for the HealthcareproviderSpecialty page.
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-specialty")
public class HealthcareproviderSpecialtyController
		extends AbstractController<HealthcareproviderSpecialty> {

	private static final Logger logger = LoggerFactory
			.getLogger(HealthcareproviderSpecialtyController.class);

	@Autowired
	public HealthcareproviderSpecialtyService healthcareproviderspecialtyService;

	@Autowired
	public HealthcareproviderService healthcareproviderService;

	@Autowired
	public SpecialtyService specialtyService;

	@Autowired
	public HealthcareproviderSpecialtyController(
			HealthcareproviderSpecialtyService healthcareproviderspecialtyService) {
		super.setGenericService(healthcareproviderspecialtyService);
	}

	/**
	 * 
	 * handle healthcareprovider-specialty edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderSpecialty healthcareproviderSpecialty,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderSpecialty",
					healthcareproviderspecialtyService.get(id));
		}
		model.addAttribute("healthcareproviderList",
				healthcareproviderService.getAll());
		model.addAttribute("specialtyList", specialtyService.getAll());
		return "healthcareprovider-specialty/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-specialty edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderSpecialty healthcareproviderSpecialty,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-specialty",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderList",
					healthcareproviderService.getAll());
			model.addAttribute("specialtyList", specialtyService.getAll());
			return "healthcareprovider-specialty/edit";
		}
		healthcareproviderspecialtyService.edit(healthcareproviderSpecialty);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-specialty/index";
	}
}