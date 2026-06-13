
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Patientreview;
import com.dg.data.service.PatientreviewService;

/**
 * @author doctorGlobe Handles all interactions with the Patientreview table.
 */
@Controller
@RequestMapping(value = "/rest/patientreview")
public class PatientreviewRestController
		extends AbstractRestController<Patientreview> {
	@Autowired
	public PatientreviewRestController(
			PatientreviewService PatientreviewService) {
		super.setGenericService(PatientreviewService);
	}
}