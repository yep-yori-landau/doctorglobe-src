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

import com.dg.data.model.db.TreatmentQuestionnaire;
import com.dg.data.service.TreatmentQuestionnaireService;
import com.dg.data.service.TreatmentService;
import com.dg.data.service.QuestionnaireService;

/**
 * Handles all crud operations for TreatmentQuestionnaire table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/treatment-questionnaire")
public class TreatmentQuestionnaireController
		extends AbstractCrudController<TreatmentQuestionnaire> {

	private static final Logger logger = LoggerFactory
			.getLogger(TreatmentQuestionnaireController.class);

	@Autowired
	public TreatmentQuestionnaireService treatmentQuestionnaireService;

	@Autowired
	public TreatmentService treatmentService;

	@Autowired
	public QuestionnaireService questionnaireService;

	@Autowired
	public TreatmentQuestionnaireController(
			TreatmentQuestionnaireService treatmentQuestionnaireService) {
		super.setGenericService(treatmentQuestionnaireService);
	}

	/**
	 * 
	 * handle TreatmentQuestionnaire edit get action
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			TreatmentQuestionnaire treatmentQuestionnaire, Model model) {
		if (id != null) {
			model.addAttribute("treatmentQuestionnaire",
					treatmentQuestionnaireService.get(id));
		}
		model.addAttribute("treatmentList", treatmentService.getAll());
		model.addAttribute("questionnaireList", questionnaireService.getAll());
		return "treatment-questionnaire/edit";
	}

	/**
	 * 
	 * handle TreatmentQuestionnaire edit post action
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid TreatmentQuestionnaire treatmentQuestionnaire,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		if (bindingResult.hasErrors()) {
			logger.error("Got {} errors during save treatment-questionnaire",
					bindingResult.getErrorCount());
			model.addAttribute("treatmentList", treatmentService.getAll());
			model.addAttribute("questionnaireList",
					questionnaireService.getAll());
			return "treatment-questionnaire/edit";
		}
		treatmentQuestionnaireService.edit(treatmentQuestionnaire);
		redirectAttributes.addFlashAttribute("message",
				"Successfully Created/Edited");
		return "redirect:/treatment-questionnaire/index";
	}
}