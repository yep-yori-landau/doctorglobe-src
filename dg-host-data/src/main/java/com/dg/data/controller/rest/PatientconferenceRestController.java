
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Patientconference;
import com.dg.data.model.domain.PatientConferenceDetailModel;
import com.dg.data.service.PatientconferenceService;

/**
 * @author doctorGlobe Handles all interactions with the Patientconference
 * table.
 */
@Controller
@RequestMapping(value = "/rest/patientconference")
public class PatientconferenceRestController
		extends AbstractRestController<Patientconference> {
	@Autowired
	public PatientconferenceRestController(
			PatientconferenceService patientconferenceService) {
		super.setGenericService(patientconferenceService);
	}

	@Autowired
	public PatientconferenceService patientconferenceService;

	// Provides interface to get Patientconference by patientcase,patient
	@RequestMapping(value = "/get/patientcase/{patientcase}/patient/{patient}", method = RequestMethod.GET)
	public @ResponseBody List<PatientConferenceDetailModel> getPatientConferenceByPatientCase(
			@PathVariable("patientcase") int patientcase,
			@PathVariable("patient") int patient) {
		return patientconferenceService.findByPatientCase(patientcase, patient);
	}

	// Provides interface to get Patientconference by patientcase,hcpstmp
	@RequestMapping(value = "/get/patientcase/{patientcase}/hcpstmp/{hcpstmp}", method = RequestMethod.GET)
	public @ResponseBody List<Patientconference> getPatientConferenceByPatientCaseAndHcpstmp(
			@PathVariable("patientcase") int patientcase,
			@PathVariable("hcpstmp") int hcpstmp) {
		return patientconferenceService.findByPatientCaseAndHcpstmp(patientcase,
				hcpstmp);
	}

	// Provides interface to get Patientconference by patient,treatment,hcpstmp
	@RequestMapping(value = "/get/patient/{patient}/treatment/{treatment}/hcpstmp/{hcpstmp}", method = RequestMethod.GET)
	public @ResponseBody Boolean getPatientConferenceByPatientAndTreatmentAndHcpstmp(
			@PathVariable("patient") int patient,
			@PathVariable("treatment") int treatment,
			@PathVariable("hcpstmp") int hcpstmp) {
		return patientconferenceService.findByPatientAndTreatmentAndHcpstmp(
				patient, treatment, hcpstmp);
	}

	// Provides interface to edit Patientconference status by pc,hcpstmp,status
	@RequestMapping(value = "/editstatus/pc/{pc}/hcpstmp/{hcpstmp}/status/{status}", method = RequestMethod.GET)
	public @ResponseBody Integer get(@PathVariable("pc") BigInteger pc,
			@PathVariable("hcpstmp") BigInteger hcpstmp,
			@PathVariable("status") String status) {
		return patientconferenceService.editStatus(pc, hcpstmp, status);
	}

	// Provides interface to get
	// TotalPatientTreatmentConferenceByPatientAndTreatment by patient,treatment
	@RequestMapping(value = "/get/patient/{patient}/treatment/{treatment}", method = RequestMethod.GET)
	public @ResponseBody Integer getTotalPatientTreatmentConferenceByPatientAndTreatment(
			@PathVariable("patient") int patient,
			@PathVariable("treatment") int treatment) {
		return patientconferenceService
				.findTotalPatientTreatmentConferenceByPatientAndTreatment(
						patient, treatment);
	}
}