
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.User;
import com.dg.data.service.UserService;

/**
 * @author doctorGlobe Handles all interactions with the User table.
 */
@Controller
@RequestMapping(value = "/rest/user")
public class UserRestController extends AbstractRestController<User> {
	@Autowired
	public UserRestController(UserService UserService) {
		super.setGenericService(UserService);
	}

}