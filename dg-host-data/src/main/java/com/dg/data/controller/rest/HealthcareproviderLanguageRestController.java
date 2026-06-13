
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.HealthcareproviderLanguage;
import com.dg.data.service.HealthcareproviderLanguageService;

/**
 * @author doctorGlobe Handles all interactions with the
 * HealthcareproviderLanguage table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-language")
public class HealthcareproviderLanguageRestController
		extends AbstractRestController<HealthcareproviderLanguage> {
	@Autowired
	public HealthcareproviderLanguageRestController(
			HealthcareproviderLanguageService healthcareproviderLanguageService) {
		super.setGenericService(healthcareproviderLanguageService);
	}

	@Autowired
	public HealthcareproviderLanguageService healthcareproviderlanguageService;

	// Provides interface to get HealthcareproviderLanguage by
	// healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderLanguage> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return healthcareproviderlanguageService
				.findByHealthcareprovider(healthcareprovider);
	}
}