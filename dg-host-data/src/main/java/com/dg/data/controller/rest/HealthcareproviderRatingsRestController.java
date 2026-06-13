
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

import com.dg.data.model.db.HealthcareproviderRatings;
import com.dg.data.service.HealthcareproviderRatingsService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderRatings table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-ratings")
public class HealthcareproviderRatingsRestController
		extends AbstractRestController<HealthcareproviderRatings> {
	@Autowired
	public HealthcareproviderRatingsRestController(
			HealthcareproviderRatingsService healthcareproviderRatingsService) {
		super.setGenericService(healthcareproviderRatingsService);
	}

	@Autowired
	public HealthcareproviderRatingsService healthcareproviderratingsService;

	// Provides interface to get HealthcareproviderRatings by user and type
	@RequestMapping(value = "/create/user/{user}/type/{type}", method = RequestMethod.POST)
	public @ResponseBody Integer create(@PathVariable("user") BigInteger user,
			@PathVariable("type") String type,
			@RequestBody HealthcareproviderRatings healthcareproviderratings) {
		return healthcareproviderratingsService.edit(healthcareproviderratings,
				user, type);
	}

	// Provides interface to get HealthcareproviderRatings by healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderRatings> get(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderratingsService
				.findByHealthcareprovider(healthcareprovider);
	}
}