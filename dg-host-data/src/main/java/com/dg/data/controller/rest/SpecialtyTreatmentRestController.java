
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.SpecialtyTreatment;
import com.dg.data.service.SpecialtyTreatmentService;

/**
 * @author doctorGlobe Handles all interactions with the SpecialtyTreatment
 */
@Controller
@RequestMapping(value = "/rest/specialty-treatment")
public class SpecialtyTreatmentRestController
		extends AbstractRestController<SpecialtyTreatment> {
	@Autowired
	public SpecialtyTreatmentRestController(
			SpecialtyTreatmentService specialtyTreatmentService) {
		super.setGenericService(specialtyTreatmentService);
	}

	@Autowired
	public SpecialtyTreatmentService specialtytreatmentService;

	// Provides interface to get SpecialtyTreatment by specialty
	@RequestMapping(value = "/get/specialty/{specialty}", method = RequestMethod.GET)
	public @ResponseBody List<SpecialtyTreatment> getBySpecialty(
			@PathVariable("specialty") BigInteger specialty) {
		return specialtytreatmentService.findBySpecialty(specialty);
	}
}