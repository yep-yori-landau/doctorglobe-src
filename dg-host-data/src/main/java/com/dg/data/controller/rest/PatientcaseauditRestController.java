
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Patientcaseaudit;
import com.dg.data.service.PatientcaseauditService;

/**
 * @author doctorGlobe Handles all interactions with the Patientcaseaudit table.
 */
@Controller
@RequestMapping(value = "/rest/patientcaseaudit")
public class PatientcaseauditRestController
		extends AbstractRestController<Patientcaseaudit> {
	@Autowired
	public PatientcaseauditRestController(
			PatientcaseauditService patientcaseauditService) {
		super.setGenericService(patientcaseauditService);
	}
}