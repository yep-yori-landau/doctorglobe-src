
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.dg.data.model.db.HealthcareproviderCuisine;
import com.dg.data.service.HealthcareproviderCuisineService;

/**
 * @author DoctorGlobe Handles all interactions with the
 * HealthcareproviderCuisine table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-cuisine")
public class HealthcareproviderCuisineRestController
		extends AbstractRestController<HealthcareproviderCuisine> {
	@Autowired
	public HealthcareproviderCuisineRestController(
			HealthcareproviderCuisineService healthcareproviderCuisineService) {
		super.setGenericService(healthcareproviderCuisineService);
	}

	@Autowired
	public HealthcareproviderCuisineService healthcareprovidercuisineService;

	// Provides interface to get healthcareprovidercuisine by healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderCuisine> get(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareprovidercuisineService
				.findByHealthcareprovider(healthcareprovider);
	}
}