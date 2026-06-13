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

import com.dg.data.model.db.Patientconference;
import com.dg.data.service.PatientconferenceService;
import com.dg.data.service.PatientcaseService;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;

/**
 * Handles all crud operations for Patientconference table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientconference")
public class PatientconferenceController
		extends AbstractCrudController<Patientconference> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientconferenceController.class);

	@Autowired
	public PatientconferenceService patientconferenceService;

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService;

	@Autowired
	public PatientconferenceController(
			PatientconferenceService patientconferenceService) {
		super.setGenericService(patientconferenceService);
	}

	/**
	 * 
	 * handle patientconference edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientconference patientconference, Model model) {
		if (id != null) {
			model.addAttribute("patientconference",
					patientconferenceService.get(id));
		}
		model.addAttribute("patientcaseList", patientcaseService.getAll());
		model.addAttribute(
				"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
				healthcareproviderSpecialtyTreatmentMethodPractitionerService
						.getAll());

		return "patientconference/edit";
	}

	/**
	 * 
	 * handle patientconference edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientconference patientconference,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientconference",
					bindingResult.getErrorCount());
			model.addAttribute("patientcaseList", patientcaseService.getAll());
			model.addAttribute(
					"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
					healthcareproviderSpecialtyTreatmentMethodPractitionerService
							.getAll());
			return "patientconference/edit";
		}
		patientconferenceService.edit(patientconference);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientconference/index";
	}
}