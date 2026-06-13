
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Cuisine;
import com.dg.data.service.CuisineService;

/**
 * @author DoctorGlobe Handles all interactions with the Cuisine table.
 */
@Controller
@RequestMapping(value = "/rest/cuisine")
public class CuisineRestController extends AbstractRestController<Cuisine> {

	@Autowired
	public CuisineRestController(CuisineService cuisineService) {
		super.setGenericService(cuisineService);
	}

}