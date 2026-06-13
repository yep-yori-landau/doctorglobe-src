
package com.dg.data.controller.rest;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Corporatecompany;
import com.dg.data.service.CorporatecompanyService;

/**
 * @author DoctorGlobe Handles all interactions with the Corporatecompany table.
 */
@Controller
@RequestMapping(value = "/rest/corporate-company")
public class CorporatecompanyRestController
		extends AbstractRestController<Corporatecompany> {
	@Autowired
	public CorporatecompanyRestController(
			CorporatecompanyService corporatecompanyService) {
		super.setGenericService(corporatecompanyService);
	}

	@Autowired
	public CorporatecompanyService corporatecompanyService;

	// Provides interface to get Corporatecompany by PatientId
	@RequestMapping(value = "/get/patient/{id}", method = RequestMethod.GET)
	public @ResponseBody Corporatecompany get(
			@PathVariable("id") BigInteger id) {
		return corporatecompanyService.findByPatientId(id);
	}

	// Provides interface to get Corporatecompany by WhitelabelUrl
	@RequestMapping(value = "/get/{hostProto}/{hostUrl:.+}/", method = RequestMethod.GET)
	public @ResponseBody Corporatecompany get(
			@PathVariable("hostProto") String hostProto,
			@PathVariable("hostUrl") String hostUrl) {
		String url = hostProto + "://" + hostUrl;
		return corporatecompanyService.findByWhitelabelUrl(url);
	}
}