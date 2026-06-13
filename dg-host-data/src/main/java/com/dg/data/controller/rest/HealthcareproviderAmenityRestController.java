
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderAmenity;
import com.dg.data.service.HealthcareproviderAmenityService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderAmenity table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-amenity")
public class HealthcareproviderAmenityRestController
		extends AbstractRestController<HealthcareproviderAmenity> {
	@Autowired
	public HealthcareproviderAmenityRestController(
			HealthcareproviderAmenityService healthcareproviderAmenityService) {
		super.setGenericService(healthcareproviderAmenityService);
	}

	@Autowired
	public HealthcareproviderAmenityService healthcareprovideramenityService;

	// Provides interface to get healthcareprovideramenity by healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderAmenity> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareprovideramenityService
				.findByHealthcareprovider(healthcareprovider);
	}
}