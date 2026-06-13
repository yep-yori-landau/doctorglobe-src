
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dg.data.model.db.ApiUser;
import com.dg.data.service.ApiUserService;

/**
 * @author doctorGlobe Handles all interactions with the ApiUser table.
 */
@Controller
@RequestMapping(value = "/rest/api-user")
public class ApiUserRestController extends AbstractRestController<ApiUser> {
	
	@Autowired
	public ApiUserRestController(ApiUserService ApiUserService) {
		super.setGenericService(ApiUserService);
	}
	
	@Autowired
	ApiUserService apiUserService;
	
	// Provides interface to get ApiUser by userName,active
	@RequestMapping(value = "/get/{userName}/{active}", method = RequestMethod.GET)
	public @ResponseBody ApiUser getByUserName(@PathVariable("userName") String userName,
			@PathVariable("active") Integer active){
		return apiUserService.findByUserName(userName, active);
	}

}