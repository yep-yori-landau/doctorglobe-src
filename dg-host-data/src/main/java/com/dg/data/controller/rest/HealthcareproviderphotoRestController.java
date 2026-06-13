
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Healthcareproviderphoto;
import com.dg.data.service.HealthcareproviderphotoService;

/**
 * @author doctorGlobe Handles all interactions with the Healthcareproviderphoto
 * table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareproviderphoto")
public class HealthcareproviderphotoRestController
		extends AbstractRestController<Healthcareproviderphoto> {
	@Autowired
	public HealthcareproviderphotoRestController(
			HealthcareproviderphotoService healthcareproviderphotoService) {
		super.setGenericService(healthcareproviderphotoService);
	}

	@Autowired
	public HealthcareproviderphotoService healthcareproviderphotoService;

	// Provides interface to get Healthcareproviderphoto by healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<Healthcareproviderphoto> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderphotoService
				.findByHealthcarerpovider(healthcareprovider);
	}
}