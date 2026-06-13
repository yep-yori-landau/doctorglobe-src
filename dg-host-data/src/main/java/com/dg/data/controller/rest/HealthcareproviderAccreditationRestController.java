
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.HealthcareproviderAccreditation;
import com.dg.data.service.HealthcareproviderAccreditationService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderAccreditation table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-accreditation")
public class HealthcareproviderAccreditationRestController
		extends AbstractRestController<HealthcareproviderAccreditation> {
	@Autowired
	public HealthcareproviderAccreditationRestController(
			HealthcareproviderAccreditationService healthcareproviderAccreditationService) {
		super.setGenericService(healthcareproviderAccreditationService);
	}

	@Autowired
	public HealthcareproviderAccreditationService healthcareprovideraccreditationService;

	// Provides interface to get HealthcareproviderAccreditation by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderAccreditation> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareprovideraccreditationService
				.findByHealthcareprovider(healthcareprovider);
	}
}