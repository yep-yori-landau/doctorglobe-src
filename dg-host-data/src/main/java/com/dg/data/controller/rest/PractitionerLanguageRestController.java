
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.PractitionerLanguage;
import com.dg.data.service.PractitionerLanguageService;

/**
 * @author doctorGlobe Handles all interactions with the PractitionerLanguage
 * table.
 */
@Controller
@RequestMapping(value = "/rest/practitioner-language")
public class PractitionerLanguageRestController
		extends AbstractRestController<PractitionerLanguage> {
	@Autowired
	public PractitionerLanguageRestController(
			PractitionerLanguageService practitionerLanguageService) {
		super.setGenericService(practitionerLanguageService);
	}

	@Autowired
	public PractitionerLanguageService practitionerlanguageService;

	// Provides interface to get PractitionerLanguage by practitioner
	@RequestMapping(value = "/get/practitioner/{practitioner}", method = RequestMethod.GET)
	public @ResponseBody List<PractitionerLanguage> getByPractitioner(
			@PathVariable("practitioner") BigInteger practitioner) {
		return practitionerlanguageService.findByPractitioner(practitioner);
	}
}