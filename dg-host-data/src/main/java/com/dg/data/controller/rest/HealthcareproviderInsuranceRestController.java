
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderInsurance;
import com.dg.data.service.HealthcareproviderInsuranceService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderInsurance table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-insurance")
public class HealthcareproviderInsuranceRestController
		extends AbstractRestController<HealthcareproviderInsurance> {
	@Autowired
	public HealthcareproviderInsuranceRestController(
			HealthcareproviderInsuranceService healthcareproviderInsuranceService) {
		super.setGenericService(healthcareproviderInsuranceService);
	}

	@Autowired
	public HealthcareproviderInsuranceService healthcareproviderinsuranceService;

	// Provides interface to get HealthcareproviderInsurance by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderInsurance> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderinsuranceService
				.findByHealthcareprovider(healthcareprovider);
	}

}