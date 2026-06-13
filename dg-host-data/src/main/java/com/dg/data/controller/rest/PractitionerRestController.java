
package com.dg.data.controller.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.Practitioner;
import com.dg.data.model.domain.HealthcareproviderPractitionerCountryModel;
import com.dg.data.model.domain.HealthcareproviderPractitionerModel;
import com.dg.data.service.PractitionerService;

/**
 * @author doctorGlobe Handles all interactions with the Practitioner table.
 */
@Controller
@RequestMapping(value = "/rest/practitioner")
public class PractitionerRestController
		extends AbstractRestController<Practitioner> {
	@Autowired
	public PractitionerRestController(PractitionerService practitionerService) {
		super.setGenericService(practitionerService);
	}

	@Autowired
	public PractitionerService practitionerService;

	// Provides interface to get Practitioner by email,active
	@RequestMapping(value = "/get/email/{email}/active/{active}", method = RequestMethod.GET)
	public @ResponseBody Practitioner getByEmail(
			@PathVariable("email") String email,
			@PathVariable("active") Integer active) {
		return practitionerService.findByEmail(email, active);
	}

	// Provides interface to reset Practitioner password by id and
	// old_password,new_password
	@RequestMapping(value = "/reset/id/{id}/old_password/{old_password}/new_password/{new_password}", method = RequestMethod.GET)
	public @ResponseBody Integer get(@PathVariable("id") int id,
			@PathVariable("old_password") String old_password,
			@PathVariable("new_password") String new_password) {
		return practitionerService.resetPassword(id, old_password,
				new_password);
	}

	// Provides interface to get Practitioner by healthcareprovider
	@RequestMapping(value = "/get/healthcareprovider/{healthcareprovider}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderPractitionerModel> getByHealthcareprovider(
			@PathVariable("healthcareprovider") BigInteger healthcareprovider) {
		return practitionerService.findByHealthcareprovider(healthcareprovider);
	}

	// Provides interface to get Practitioner Country by hstmp
	@RequestMapping(value = "/get/country/hstmp/{hstmp}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderPractitionerCountryModel> getCountryByHstmp(
			@PathVariable("hstmp") BigInteger hstmp) {
		return practitionerService.findCountryByHstmp(hstmp);
	}

	// Provides interface to get Practitioner by name
	@RequestMapping(value = "/get-name/{name}", method = RequestMethod.GET)
	public @ResponseBody Practitioner getByName(
			@PathVariable("name") String name) {
		return practitionerService.findByName(name);
	}
}