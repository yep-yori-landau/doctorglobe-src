
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Attestations;
import com.dg.data.service.AttestationsService;

/**
 * @author DoctorGlobe Handles all interactions with the Attestations table.
 */
@Controller
@RequestMapping(value = "/rest/attestations")
public class AttestationsRestController
		extends AbstractRestController<Attestations> {
	@Autowired
	public AttestationsRestController(AttestationsService attestationsService) {
		super.setGenericService(attestationsService);
	}
}