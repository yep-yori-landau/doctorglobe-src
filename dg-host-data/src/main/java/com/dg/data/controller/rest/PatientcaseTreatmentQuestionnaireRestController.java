
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;
import com.dg.data.model.domain.PatientcaseTreatmentQuestionnaireDetailModel;
import com.dg.data.service.PatientcaseTreatmentQuestionnaireService;

/**
 * @author doctorGlobe Handles all interactions with the
 * PatientcaseTreatmentQuestionnaire table.
 */
@Controller
@RequestMapping(value = "/rest/patientcase-treatment-questionnaire")
public class PatientcaseTreatmentQuestionnaireRestController
		extends AbstractRestController<PatientcaseTreatmentQuestionnaire> {
	@Autowired
	public PatientcaseTreatmentQuestionnaireRestController(
			PatientcaseTreatmentQuestionnaireService patientcaseTreatmentQuestionnaireService) {
		super.setGenericService(patientcaseTreatmentQuestionnaireService);
	}

	@Autowired
	public PatientcaseTreatmentQuestionnaireService patientcaseTreatmentQuestionnaireService;

	// Provides interface to get PatientcaseTreatmentQuestionnaire by
	// patientcase
	@RequestMapping(value = "/get/PatientcaseTreatmentQuestionnaire/{patientcase}", method = RequestMethod.GET)
	public @ResponseBody List<PatientcaseTreatmentQuestionnaire> getByPatientcaseTreatment(
			@PathVariable("patientcase") BigInteger patientcase) {
		return patientcaseTreatmentQuestionnaireService
				.findByPatientcase(patientcase);
	}

	// Provides interface to get PatientcaseTreatmentQuestionnaire by Pc
	@RequestMapping(value = "/get/pc/{pc}", method = RequestMethod.GET)
	public @ResponseBody List<PatientcaseTreatmentQuestionnaireDetailModel> getByPatientcase(
			@PathVariable("pc") BigInteger patientcase) {
		return patientcaseTreatmentQuestionnaireService.findByPc(patientcase);
	}
}