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

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;
import com.dg.data.service.CorporatecompanyInsuranceService;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;
import com.dg.data.service.PractitionerService;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodService;

/**
 * Handles all crud operations for
 * HealthcareproviderSpecialtyTreatmentMethodPractitioner table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/healthcareprovider-specialty-treatment-method-practitioner")
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerController
		extends
		AbstractController<HealthcareproviderSpecialtyTreatmentMethodPractitioner> {

	private static final Logger logger = LoggerFactory.getLogger(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerController.class);

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService;

	@Autowired
	public PractitionerService practitionerService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodService healthcareproviderSpecialtyTreatmentMethodService;

	@Autowired
	public CorporatecompanyInsuranceService corporatecompanyInsuranceService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerController(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService) {
		super.setGenericService(
				healthcareproviderSpecialtyTreatmentMethodPractitionerService);
	}

	/**
	 * 
	 * handle healthcareprovider-specialty-treatment-method-practitioner edit
	 * get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			HealthcareproviderSpecialtyTreatmentMethodPractitioner healthcareproviderSpecialtyTreatmentMethodPractitioner,
			Model model) {
		if (id != null) {
			model.addAttribute(
					"healthcareproviderSpecialtyTreatmentMethodPractitioner",
					healthcareproviderSpecialtyTreatmentMethodPractitionerService
							.get(id));
		}
		model.addAttribute("practitionerList", practitionerService.getAll());
		model.addAttribute("healthcareproviderSpecialtyTreatmentMethodList",
				healthcareproviderSpecialtyTreatmentMethodService.getAll());
		model.addAttribute("corporatecompanyInsuranceList",
				corporatecompanyInsuranceService.getAll());
		return "healthcareprovider-specialty-treatment-method-practitioner/edit";
	}

	/**
	 * 
	 * handle healthcareprovider-specialty-treatment-method-practitioner edit
	 * post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid HealthcareproviderSpecialtyTreatmentMethodPractitioner healthcareproviderSpecialtyTreatmentMethodPractitioner,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save healthcareprovider-specialty-treatment-method-practitioner",
					bindingResult.getErrorCount());
			model.addAttribute("practitionerList",
					practitionerService.getAll());
			model.addAttribute("healthcareproviderSpecialtyTreatmentMethodList",
					healthcareproviderSpecialtyTreatmentMethodService.getAll());
			return "healthcareprovider-specialty-treatment-method-practitioner/edit";
		}
		healthcareproviderSpecialtyTreatmentMethodPractitionerService
				.edit(healthcareproviderSpecialtyTreatmentMethodPractitioner);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/healthcareprovider-specialty-treatment-method-practitioner/index";
	}

}