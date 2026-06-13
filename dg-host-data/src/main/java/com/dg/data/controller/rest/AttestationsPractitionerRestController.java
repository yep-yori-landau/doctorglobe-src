
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.AttestationsPractitioner;
import com.dg.data.service.AttestationsPractitionerService;

/**
 * @author DoctorGlobe Handles all interactions with the
 * AttestationsPractitioner table.
 */
@Controller
@RequestMapping(value = "/rest/attestations-practitioner")
public class AttestationsPractitionerRestController
		extends AbstractRestController<AttestationsPractitioner> {
	@Autowired
	public AttestationsPractitionerRestController(
			AttestationsPractitionerService attestationsPractitionerService) {
		super.setGenericService(attestationsPractitionerService);
	}

	@Autowired
	public AttestationsPractitionerService attestationspractitionerService;

	// Provides interface to find AttestationsPractitioner by practitioner
	@RequestMapping(value = "/get/practitioner/{practitioner}", method = RequestMethod.GET)
	public @ResponseBody List<AttestationsPractitioner> getByPractitioner(
			@PathVariable("practitioner") BigInteger practitioner) {
		return attestationspractitionerService.findByPractitioner(practitioner);
	}
}