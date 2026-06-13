
package com.dg.data.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Patientcase;
import com.dg.data.model.domain.PatientcaseDetailModel;
import com.dg.data.service.PatientcaseService;

/**
 * @author doctorGlobe Handles all interactions with the Patientcase table.
 */
@Controller
@RequestMapping(value = "/rest/patientcase")
public class PatientcaseRestController
		extends AbstractRestController<Patientcase> {
	@Autowired
	public PatientcaseRestController(PatientcaseService patientcaseService) {
		super.setGenericService(patientcaseService);
	}

	@Autowired
	public PatientcaseService patientcaseService;

	// Provides interface to get Patientcase by ppatientid
	@RequestMapping(value = "/get/patient/{patient}", method = RequestMethod.GET)
	public @ResponseBody List<PatientcaseDetailModel> getByPatientId(
			@PathVariable("patient") int patient) {
		return patientcaseService.findByPatientId(patient);
	}

	// Provides interface to edit Patientcase status by id,status
	@RequestMapping(value = "/edit/id/{id}/status/{status}", method = RequestMethod.GET)
	public @ResponseBody Integer get(@PathVariable("id") int id,
			@PathVariable("status") String status) {
		return patientcaseService.editStatus(id, status);
	}
}