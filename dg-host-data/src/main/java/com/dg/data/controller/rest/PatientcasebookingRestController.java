
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.Patientcasebooking;

import com.dg.data.service.PatientcasebookingService;

/**
 * @author doctorGlobe Handles all interactions with the Patientcasebooking
 * table.
 */
@Controller
@RequestMapping(value = "/rest/patientcasebooking")
public class PatientcasebookingRestController
		extends AbstractRestController<Patientcasebooking> {
	@Autowired
	public PatientcasebookingRestController(
			PatientcasebookingService patientcasebookingService) {
		super.setGenericService(patientcasebookingService);
	}

	@Autowired
	public PatientcasebookingService patientcasebookingService;

	// Provides interface to edit Patientcasebooking by pc id,hcpstmp,status
	@RequestMapping(value = "/editstatus/pc/{pc}/hcpstmp/{hcpstmp}/status/{status}", method = RequestMethod.GET)
	public @ResponseBody Integer get(@PathVariable("pc") BigInteger pc,
			@PathVariable("hcpstmp") BigInteger hcpstmp,
			@PathVariable("status") String status) {
		return patientcasebookingService.editStatus(pc, hcpstmp, status);
	}

	// Provides interface to get Patientcasebooking by patientcase,hcpstmp
	@RequestMapping(value = "/get/patientcase/{patientcase}/hcpstmp/{hcpstmp}", method = RequestMethod.GET)
	public @ResponseBody List<Patientcasebooking> getPatientcasebookingByPatientCaseAndHcpstmp(
			@PathVariable("patientcase") int patientcase,
			@PathVariable("hcpstmp") int hcpstmp) {
		return patientcasebookingService
				.findByPatientCaseAndHcpstmp(patientcase, hcpstmp);
	}

	// Provides interface to get Patientcasebooking by patient,treatment
	@RequestMapping(value = "/get/patient/{patient}/treatment/{treatment}", method = RequestMethod.GET)
	public @ResponseBody List<Patientcasebooking> getPatientcasebookingByPatientAndTreatment(
			@PathVariable("patient") int patient,
			@PathVariable("treatment") int treatment) {
		return patientcasebookingService.findByPatientAndTreatment(patient,
				treatment);
	}

	// Provides interface to get Patientcasebooking by patientcase
	@RequestMapping(value = "/get/patientcase/{patientcase}", method = RequestMethod.GET)
	public @ResponseBody List<Patientcasebooking> getPatientcasebookingByPatientCase(
			@PathVariable("patientcase") int patientcase) {
		return patientcasebookingService.findByPatientCase(patientcase);
	}
}