
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.Associate;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.model.domain.CorporatecompanyPatientModel;
import com.dg.data.service.AssociateService;

/**
 * @author DoctorGlobe Handles all interactions with the Associate table.
 */

@Controller
@RequestMapping(value = "/rest/associate")
public class AssociateRestController extends AbstractRestController<Associate> {
	@Autowired
	private AssociateService associateService;

	@Autowired
	public AssociateRestController(AssociateService associateService) {
		super.setGenericService(associateService);
	}

	// Provides interface to get a specific Associate by email
	@RequestMapping(value = "/get/email/{email}/active/{active}", method = RequestMethod.GET)
	public @ResponseBody Associate getByEmail(
			@PathVariable("email") String email,
			@PathVariable("active") Integer active) {
		return associateService.findByEmail(email, active);
	}

	// Provides interface to get a specific CorporateCompanyPatient by Id
	@RequestMapping(value = "/get/patient/{id}", method = RequestMethod.GET)
	public @ResponseBody List<CorporatecompanyPatientModel> getCorporateCompanyPatientById(
			@PathVariable("id") BigInteger id) {
		return associateService.findCorporateCompanyPatientById(id);
	}

	// Provides interface to get a specific Corporatecompany by Id
	@RequestMapping(value = "/get/corporate-company/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Corporatecompany> getCorporatecompanyById(
			@PathVariable("id") BigInteger id) {
		return associateService.findCorporetecompanyById(id);
	}

	// Provides interface to get a specific Corporatecompany by Id
	@RequestMapping(value = "/get/corporate-company/{id}/{search}/{cc}", method = RequestMethod.GET)
	public @ResponseBody List<CorporatecompanyPatientModel> getCorporatecompanyById(
			@PathVariable("id") BigInteger id,
			@PathVariable("search") String search,
			@PathVariable("cc") BigInteger cc) {
		return associateService.findCorporateCompanyPatientById(id, search, cc);
	}

	// Provides interface to reset password
	@RequestMapping(value = "/reset/{id}/{old_password}/{new_password}", method = RequestMethod.GET)
	public @ResponseBody Integer get(@PathVariable("id") int id,
			@PathVariable("old_password") String old_password,
			@PathVariable("new_password") String new_password) {
		return associateService.resetPassword(id, old_password, new_password);
	}
}