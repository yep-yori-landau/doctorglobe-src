
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Healthcareprovidertype;
import com.dg.data.service.HealthcareprovidertypeService;

/**
 * @author doctorGlobe Handles all interactions with the Healthcareprovidertype
 * table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovidertype")
public class HealthcareprovidertypeRestController
		extends AbstractRestController<Healthcareprovidertype> {
	@Autowired
	public HealthcareprovidertypeRestController(
			HealthcareprovidertypeService healthcareprovidertypeService) {
		super.setGenericService(healthcareprovidertypeService);
	}
}