
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderSpecialty;
import com.dg.data.service.HealthcareproviderSpecialtyService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderSpecialty table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-specialty")
public class HealthcareproviderSpecialtyRestController
		extends AbstractRestController<HealthcareproviderSpecialty> {
	@Autowired
	public HealthcareproviderSpecialtyRestController(
			HealthcareproviderSpecialtyService healthcareproviderSpecialtyService) {
		super.setGenericService(healthcareproviderSpecialtyService);
	}

	@Autowired
	public HealthcareproviderSpecialtyService healthcareproviderSpecialtyService;

	// Provides interface to get HealthcareproviderSpecialty by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderSpecialty> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderSpecialtyService
				.findByHealthcareprovider(healthcareprovider);
	}
}