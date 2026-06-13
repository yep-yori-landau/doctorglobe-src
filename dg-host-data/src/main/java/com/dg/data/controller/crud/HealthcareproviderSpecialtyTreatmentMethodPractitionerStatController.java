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

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService;

import com.dg.data.service.StatsService;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;

/**
 * Handles all crud operations for
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-specialty-treatment-method-practitioner-stat")
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerStatController
		extends
		AbstractController<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> {

	private static final Logger logger = LoggerFactory.getLogger(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerStatController.class);

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService healthcareproviderSpecialtyTreatmentMethodPractitionerStatService;

	@Autowired
	public StatsService statsService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerStatController(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService healthcareproviderSpecialtyTreatmentMethodPractitionerStatService) {
		super.setGenericService(
				healthcareproviderSpecialtyTreatmentMethodPractitionerStatService);
	}

	/**
	 * 
	 * handle healthcareprovider-specialty-treatment-method-practitioner-stat
	 * edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderSpecialtyTreatmentMethodPractitionerStat healthcareproviderSpecialtyTreatmentMethodPractitionerStat,
			Model model) {
		if (id != null) {
			model.addAttribute(
					"healthcareproviderSpecialtyTreatmentMethodPractitionerStat",
					healthcareproviderSpecialtyTreatmentMethodPractitionerStatService
							.get(id));
		}
		model.addAttribute("statsList", statsService.getAll());
		model.addAttribute(
				"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
				healthcareproviderSpecialtyTreatmentMethodPractitionerService
						.getAll());

		return "healthcareprovider-specialty-treatment-method-practitioner-stat/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-specialty-treatment-method-practitioner-stat
	 * edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderSpecialtyTreatmentMethodPractitionerStat healthcareproviderSpecialtyTreatmentMethodPractitionerStat,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-specialty-treatment-method-practitioner-stat",
					bindingResult.getErrorCount());
			model.addAttribute("statsList", statsService.getAll());
			model.addAttribute(
					"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
					healthcareproviderSpecialtyTreatmentMethodPractitionerService
							.getAll());
			return "healthcareprovider-specialty-treatment-method-practitioner-stat/edit";
		}
		healthcareproviderSpecialtyTreatmentMethodPractitionerStatService.edit(
				healthcareproviderSpecialtyTreatmentMethodPractitionerStat);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-specialty-treatment-method-practitioner-stat/index";
	}
}