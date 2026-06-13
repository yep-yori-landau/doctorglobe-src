
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Treatment;
import com.dg.data.service.TreatmentService;

/**
 * @author doctorGlobe Handles all interactions with the Treatment table.
 */
@Controller
@RequestMapping(value = "/rest/treatment")
public class TreatmentRestController extends AbstractRestController<Treatment> {
	@Autowired
	public TreatmentRestController(TreatmentService treatmentService) {
		super.setGenericService(treatmentService);
	}
}