
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Healthcareprovider;
//import com.dg.data.model.db.HistoryUser;
import com.dg.data.service.HealthcareproviderService;

/**
 * @author doctorGlobe Handles all interactions with the Healthcareprovider
 * table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider")
public class HealthcareproviderRestController
		extends AbstractRestController<Healthcareprovider> {
	@Autowired
	public HealthcareproviderRestController(
			HealthcareproviderService healthcareproviderService) {
		super.setGenericService(healthcareproviderService);
	}
}