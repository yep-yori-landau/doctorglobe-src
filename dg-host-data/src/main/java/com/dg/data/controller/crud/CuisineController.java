
package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Cuisine;
import com.dg.data.service.CuisineService;

/**
 * Handles all crud operations for Cuisine table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/cuisine")
public class CuisineController extends AbstractController<Cuisine> {
	@Autowired
	public CuisineController(CuisineService cuisineService) {
		super.setGenericService(cuisineService);
	}

}