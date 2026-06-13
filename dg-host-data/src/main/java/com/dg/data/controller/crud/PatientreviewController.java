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

import com.dg.data.model.db.Patientreview;
import com.dg.data.service.PatientreviewService;
import com.dg.data.service.PatientService;
import com.dg.data.service.HealthcareproviderSpecialtyTreatmentMethodPractitionerService;

/**
 * Handles all crud operations for Patientreview table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientreview")
public class PatientreviewController
		extends AbstractCrudController<Patientreview> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientreviewController.class);

	@Autowired
	public PatientreviewService patientreviewService;

	@Autowired
	public PatientService patientService;

	@Autowired
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerService healthcareproviderSpecialtyTreatmentMethodPractitionerService;

	@Autowired
	public PatientreviewController(PatientreviewService patientreviewService) {
		super.setGenericService(patientreviewService);
	}

	/**
	 * 
	 * handle patientreview edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			Patientreview patientreview, Model model) {
		if (id != null) {
			model.addAttribute("patientreview", patientreviewService.get(id));
		}
		model.addAttribute("patientList", patientService.getAll());
		model.addAttribute(
				"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
				healthcareproviderSpecialtyTreatmentMethodPractitionerService
						.getAll());
		return "patientreview/edit";
	}

	/**
	 * 
	 * handle patientreview edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Patientreview patientreview,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save patientreview",
					bindingResult.getErrorCount());
			model.addAttribute("patientList", patientService.getAll());
			model.addAttribute(
					"healthcareproviderSpecialtyTreatmentMethodPractitionerList",
					healthcareproviderSpecialtyTreatmentMethodPractitionerService
							.getAll());
			return "patientreview/edit";
		}
		patientreviewService.edit(patientreview);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientreview/index";
	}
}
