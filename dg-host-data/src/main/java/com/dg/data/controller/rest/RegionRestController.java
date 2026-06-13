
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Region;
import com.dg.data.service.RegionService;

/**
 * @author doctorGlobe Handles all interactions with the Region table.
 */
@Controller
@RequestMapping(value = "/rest/region")
public class RegionRestController extends AbstractRestController<Region> {
	@Autowired
	public RegionRestController(RegionService regionService) {
		super.setGenericService(regionService);
	}

}