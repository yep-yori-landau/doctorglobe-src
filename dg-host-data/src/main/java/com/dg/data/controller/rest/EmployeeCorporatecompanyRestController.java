
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.EmployeeCorporatecompany;
import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;
import com.dg.data.service.EmployeeCorporatecompanyService;

/**
 * @author DoctorGlobe Handles all interactions with the
 * EmployeeCorporatecompany table.
 */
@Controller
@RequestMapping(value = "/rest/employee-corporatecompany")
public class EmployeeCorporatecompanyRestController
		extends AbstractRestController<EmployeeCorporatecompany> {
	@Autowired
	public EmployeeCorporatecompanyRestController(
			EmployeeCorporatecompanyService employeeCorporatecompanyService) {
		super.setGenericService(employeeCorporatecompanyService);
	}

	@Autowired
	public EmployeeCorporatecompanyService employeeCorporatecompanyService;

	// Provides interface to get EmployeeCorporatecompany by patient
	@RequestMapping(value = "/get/patient/{patient}", method = RequestMethod.GET)
	public @ResponseBody EmployeeCorporatecompanyDetail getByPatient(
			@PathVariable("patient") int patient) {
		return employeeCorporatecompanyService.findByPaytient(patient);
	}
}