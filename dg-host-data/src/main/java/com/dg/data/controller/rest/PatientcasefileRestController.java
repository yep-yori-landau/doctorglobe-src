
package com.dg.data.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.Patientcasefile;
import com.dg.data.service.PatientcasefileService;

/**
 * @author doctorGlobe Handles all interactions with the Patientcasefile table.
 */
@Controller
@RequestMapping(value = "/rest/patientcasefile")
public class PatientcasefileRestController
		extends AbstractRestController<Patientcasefile> {
	@Autowired
	public PatientcasefileRestController(
			PatientcasefileService patientcasefileService) {
		super.setGenericService(patientcasefileService);
	}

	@Autowired
	public PatientcasefileService patientcasefileService;

	// Provides interface to get Patientcasefile by patientcase
	@RequestMapping(value = "/get/patientcase/{patientcase}", method = RequestMethod.GET)
	public @ResponseBody List<Patientcasefile> getByPatientCaseId(
			@PathVariable("patientcase") int patientcase) {
		return patientcasefileService.findByPatientCaseId(patientcase);
	}
}