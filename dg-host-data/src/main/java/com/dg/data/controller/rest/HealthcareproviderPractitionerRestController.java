
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderPractitioner;
import com.dg.data.service.HealthcareproviderPractitionerService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderPractitioner table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-practitioner")
public class HealthcareproviderPractitionerRestController
		extends AbstractRestController<HealthcareproviderPractitioner> {
	@Autowired
	public HealthcareproviderPractitionerRestController(
			HealthcareproviderPractitionerService healthcareproviderPractitionerService) {
		super.setGenericService(healthcareproviderPractitionerService);
	}

	@Autowired
	public HealthcareproviderPractitionerService healthcareproviderPractitionerService;

	// Provides interface to get HealthcareproviderPractitioner by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderPractitioner> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderPractitionerService
				.findByHealthcareprovider(healthcareprovider);
	}
}