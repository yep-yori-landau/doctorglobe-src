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

import com.dg.data.model.db.Patientcasebooking;
import com.dg.data.service.PatientcasebookingService;
import com.dg.data.service.PatientcaseService;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;

/**
 * Handles all crud operations for Patientcasebooking table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientcasebooking")
public class PatientcasebookingController
		extends AbstractController<Patientcasebooking> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcasebookingController.class);

	@Autowired
	public PatientcasebookingService patientcasebookingService;

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService;

	@Autowired
	public PatientcasebookingController(
			PatientcasebookingService patientcasebookingService) {
		super.setGenericService(patientcasebookingService);
	}

	/**
	 * 
	 * handle patientcasebooking edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientcasebooking patientcasebooking, Model model) {
		if (id != null) {
			model.addAttribute("patientcasebooking",
					patientcasebookingService.get(id));
		}
		model.addAttribute("patientcaseList", patientcaseService.getAll());
		model.addAttribute(
				"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
				healthcareproviderSpecialtyTreatmentMethodPractitionerService
						.getAll());
		return "patientcasebooking/edit";
	}

	/**
	 * 
	 * handle patientcasebooking edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientcasebooking patientcasebooking,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientcasebooking",
					bindingResult.getErrorCount());
			model.addAttribute("patientcaseList", patientcaseService.getAll());
			model.addAttribute(
					"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
					healthcareproviderSpecialtyTreatmentMethodPractitionerService
							.getAll());

			return "patientcasebooking/edit";
		}
		patientcasebookingService.edit(patientcasebooking);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientcasebooking/index";
	}
}