
package com.dg.data.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.HealthcareproviderUser;
import com.dg.data.model.domain.HealthcareproviderUserDetailModel;
import com.dg.data.service.HealthcareproviderUserService;

/**
 * @author doctorGlobe Handles all interactions with the HealthcareproviderUser
 * table.
 */
@Controller
@RequestMapping(value = "/rest/healthcareprovider-user")
public class HealthcareproviderUserRestController
		extends AbstractRestController<HealthcareproviderUser> {
	@Autowired
	public HealthcareproviderUserRestController(
			HealthcareproviderUserService healthcareproviderUserService) {
		super.setGenericService(healthcareproviderUserService);
	}

	@Autowired
	public HealthcareproviderUserService healthcareprovideruserService;

	// Provides interface to get HealthcareproviderUser by email and active
	@RequestMapping(value = "/get/email/{email}/active/{active}", method = RequestMethod.GET)
	public @ResponseBody List<HealthcareproviderUserDetailModel> get(
			@PathVariable("email") String email,
			@PathVariable("active") Integer active) {
		return healthcareprovideruserService.authenticate(email, active);
	}
}