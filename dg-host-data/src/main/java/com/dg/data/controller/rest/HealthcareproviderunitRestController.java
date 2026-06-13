
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Healthcareproviderunit;
import com.dg.data.service.HealthcareproviderunitService;

/**
 * @author doctorGlobe Handles all interactions with the Healthcareproviderunit
 * table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareproviderunit")
public class HealthcareproviderunitRestController
		extends AbstractRestController<Healthcareproviderunit> {
	@Autowired
	public HealthcareproviderunitRestController(
			HealthcareproviderunitService healthcareproviderunitService) {
		super.setGenericService(healthcareproviderunitService);
	}
}