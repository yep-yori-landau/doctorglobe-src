
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.PatientcasePrice;
import com.dg.data.service.PatientcasePriceService;

/**
 * @author doctorGlobe Handles all interactions with the PatientcasePrice table.
 */
@Controller
@RequestMapping(value = "/rest/patientcase-price")
public class PatientcasePriceRestController
		extends AbstractRestController<PatientcasePrice> {
	@Autowired
	public PatientcasePriceRestController(
			PatientcasePriceService patientcasePriceService) {
		super.setGenericService(patientcasePriceService);
	}

	@Autowired
	public PatientcasePriceService patientcasePriceService;

	// Provides interface to get PatientcasePrice by patientcase,hcpstmp
	@RequestMapping(value = "/get/patientcase/{patientcase}/hcpstmp/{hcpstmp}", method = RequestMethod.GET)
	public @ResponseBody PatientcasePrice getPatientcasePriceByPatientCaseAndHcpstmp(
			@PathVariable("patientcase") Integer patientcase,
			@PathVariable("hcpstmp") Integer hcpstmp) {
		return patientcasePriceService.findByPatientcaseAndHcpstmp(patientcase,
				hcpstmp);
	}

}