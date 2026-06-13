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

import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;
import com.dg.data.service.PatientcaseService;
import com.dg.data.service.PatientcaseTreatmentQuestionnaireService;
import com.dg.data.service.TreatmentQuestionnaireService;

/**
 * Handles all crud operations for PatientcaseTreatmentQuestionnaire table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/patientcase-treatment-questionnaire")
public class PatientcaseTreatmentQuestionnaireController
		extends AbstractCrudController<PatientcaseTreatmentQuestionnaire> {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcaseTreatmentQuestionnaireController.class);

	@Autowired
	public PatientcaseTreatmentQuestionnaireService patientcaseTreatmentQuestionnaireService;

	@Autowired
	public TreatmentQuestionnaireService treatmentQuestionnaireService;

	@Autowired
	public PatientcaseService patientcaseService;

	@Autowired
	public PatientcaseTreatmentQuestionnaireController(
			PatientcaseTreatmentQuestionnaireService patientcaseTreatmentQuestionnaireService) {
		super.setGenericService(patientcaseTreatmentQuestionnaireService);
	}

	/**
	 * 
	 * handle patientcase-treatment-questionnaire edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			PatientcaseTreatmentQuestionnaire patientcaseTreatmentQuestionnaire,
			Model model) {
		if (id != null) {
			model.addAttribute("patientcaseTreatmentQuestionnaire",
					patientcaseTreatmentQuestionnaireService.get(id));
		}
		model.addAttribute("treatmentQuestionnaireList",
				treatmentQuestionnaireService.getAll());
		model.addAttribute("patientcaseList", patientcaseService.getAll());

		return "patientcase-treatment-questionnaire/edit";
	}

	/**
	 * 
	 * handle patientcase-treatment-questionnaire edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			@Valid PatientcaseTreatmentQuestionnaire patientcaseTreatmentQuestionnaire,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error(
					"Got {} errors during save patientcase-treatment-questionnaire",
					bindingResult.getErrorCount());
			model.addAttribute("treatmentQuestionnaireList",
					treatmentQuestionnaireService.getAll());
			model.addAttribute("patientcaseList", patientcaseService.getAll());
			return "treatment-questionnaire/edit";
		}
		patientcaseTreatmentQuestionnaireService
				.edit(patientcaseTreatmentQuestionnaire);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/patientcase-treatment-questionnaire/index";
	}

}