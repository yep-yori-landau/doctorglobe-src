
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Amenity;
import com.dg.data.service.AmenityService;

/**
 * @author DoctorGlobe Handles all interactions with the Amenity table.
 */
@Controller
@RequestMapping(value = "/rest/amenity")
public class AmenityRestController extends AbstractRestController<Amenity> {
	@Autowired
	public AmenityRestController(AmenityService amenityService) {
		super.setGenericService(amenityService);
	}
}