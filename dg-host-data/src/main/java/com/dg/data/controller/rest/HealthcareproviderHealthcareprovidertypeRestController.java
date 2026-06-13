
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;
import com.dg.data.service.HealthcareproviderHealthcareprovidertypeService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderHealthcareprovidertype table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-healthcareprovidertype")
public class HealthcareproviderHealthcareprovidertypeRestController extends
		AbstractRestController<HealthcareproviderHealthcareprovidertype> {
	@Autowired
	public HealthcareproviderHealthcareprovidertypeRestController(
			HealthcareproviderHealthcareprovidertypeService healthcareproviderHealthcareprovidertypeService) {
		super.setGenericService(
				healthcareproviderHealthcareprovidertypeService);
	}

	@Autowired
	public HealthcareproviderHealthcareprovidertypeService healthcareproviderhealthcareprovidertypeService;

	// Provides interface to get healthcareproviderhealthcareprovidertype by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderHealthcareprovidertype> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderhealthcareprovidertypeService
				.findByHealthcareprovider(healthcareprovider);
	}
}