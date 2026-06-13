package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Region;
import com.dg.data.service.RegionService;

/**
 * Handles all crud operations for Region table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController extends AbstractController<Region> {

	@Autowired
	public RegionController(RegionService regionService) {
		super.setGenericService(regionService);
	}
}