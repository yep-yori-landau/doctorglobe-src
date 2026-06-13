
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderUnitFeature;
import com.dg.data.service.HealthcareproviderUnitFeatureService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderUnitFeature table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-unit-feature")
public class HealthcareproviderUnitFeatureRestController
		extends AbstractRestController<HealthcareproviderUnitFeature> {
	@Autowired
	public HealthcareproviderUnitFeatureRestController(
			HealthcareproviderUnitFeatureService healthcareproviderUnitFeatureService) {
		super.setGenericService(healthcareproviderUnitFeatureService);
	}

	@Autowired
	public HealthcareproviderUnitFeatureService healthcareproviderunitfeatureService;

	// Provides interface to get HealthcareproviderUnitFeature by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderUnitFeature> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderunitfeatureService
				.findByHealthcareprovider(healthcareprovider);
	}
}