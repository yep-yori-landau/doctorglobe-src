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

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodService;
import com.dg.data.service.HealthcareproviderSpecialtyService;
import com.dg.data.service.TreatmentService;
import com.dg.data.service.MethodService;

/**
 * Handles all crud operations for HealthcareproviderSpecialtyTreatmentMethod
 * table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-specialty-treatment-method")
public class HealthcareproviderSpecialtyTreatmentMethodController
		extends AbstractController<HealthcareproviderSpecialtyTreatmentMethod> {

	private static final Logger logger = LoggerFactory.getLogger(
			HealthcareproviderSpecialtyTreatmentMethodController.class);

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodService healthcareproviderSpecialtyTreatmentMethodService;

	@Autowired
	public HealthcareproviderSpecialtyService healthcareproviderSpecialtyService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public MethodService methodService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodController(
			HealthcareproviderSpecialtyTreatmentMethodService healthcareproviderSpecialtyTreatmentMethodService) {
		super.setGenericService(
				healthcareproviderSpecialtyTreatmentMethodService);
	}

	/**
	 * 
	 * handle healthcareprovider-specialty-treatment-method edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderSpecialtyTreatmentMethod healthcareproviderSpecialtyTreatmentMethod,
			Model model) {
		if (id != null) {
			model.addAttribute("healthcareproviderSpecialtyTreatmentMethod",
					healthcareproviderSpecialtyTreatmentMethodService.get(id));
		}
		model.addAttribute("healthcareproviderSpecialtyList",
				healthcareproviderSpecialtyService.getAll());
		model.addAttribute("treatmentList", treatmentService.getAll());
		model.addAttribute("methodList", methodService.getAll());
		return "healthcareprovider-specialty-treatment-method/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-specialty-treatment-method edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderSpecialtyTreatmentMethod healthcareproviderSpecialtyTreatmentMethod,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-specialty-treatment-method",
					bindingResult.getErrorCount());
			model.addAttribute("healthcareproviderSpecialtyList",
					healthcareproviderSpecialtyService.getAll());
			model.addAttribute("treatmentList", treatmentService.getAll());
			model.addAttribute("methodList", methodService.getAll());
			return "healthcareprovider-specialty-treatment-method/edit";
		}
		healthcareproviderSpecialtyTreatmentMethodService
				.edit(healthcareproviderSpecialtyTreatmentMethod);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-specialty-treatment-method/index";
	}
}