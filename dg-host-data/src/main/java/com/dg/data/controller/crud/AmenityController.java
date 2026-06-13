package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Amenity;
import com.dg.data.service.AmenityService;

/**
 * Handles all crud operations for Amenity table.
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/amenity")
public class AmenityController extends AbstractController<Amenity> {
	@Autowired
	public AmenityController(AmenityService amenityService) {
		super.setGenericService(amenityService);
	}

}