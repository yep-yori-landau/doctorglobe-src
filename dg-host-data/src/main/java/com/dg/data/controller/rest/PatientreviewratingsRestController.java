
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Patientreviewratings;
import com.dg.data.service.PatientreviewratingsService;

/**
 * @author doctorGlobe Handles all interactions with the Patientreviewratings
 * table.
 */
@Controller
@RequestMapping(value = "/rest/patientreviewratings")
public class PatientreviewratingsRestController
		extends AbstractRestController<Patientreviewratings> {
	@Autowired
	public PatientreviewratingsRestController(
			PatientreviewratingsService patientreviewratingsService) {
		super.setGenericService(patientreviewratingsService);
	}
}