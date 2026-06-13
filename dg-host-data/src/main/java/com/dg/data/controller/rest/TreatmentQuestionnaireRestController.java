
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.TreatmentQuestionnaire;
import com.dg.data.model.domain.TreatmentQuestionnaireModel;
import com.dg.data.service.TreatmentQuestionnaireService;

/**
 * @author doctorGlobe Handles all interactions with the TreatmentQuestionnaire
 * table.
 */
@Controller
@RequestMapping(value = "/rest/treatment-questionnaire")
public class TreatmentQuestionnaireRestController
		extends AbstractRestController<TreatmentQuestionnaire> {
	@Autowired
	public TreatmentQuestionnaireRestController(
			TreatmentQuestionnaireService treatmentQuestionnaireService) {
		super.setGenericService(treatmentQuestionnaireService);
	}

	@Autowired
	public TreatmentQuestionnaireService treatmentQuestionnaireService;

	// Provides interface to get TreatmentQuestionnaire by treatment
	@RequestMapping(value = "/get/treatment/{treatment}", method = RequestMethod.GET)
	public @ResponseBody List<TreatmentQuestionnaireModel> getByTreatment(
			@PathVariable("treatment") BigInteger treatment) {
		return treatmentQuestionnaireService.findByTreatment(treatment);
	}
}