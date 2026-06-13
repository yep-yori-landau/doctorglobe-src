
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Stats;
import com.dg.data.service.StatsService;

/**
 * @author doctorGlobe Handles all interactions with the Stats table.
 */
@Controller
@RequestMapping(value = "/rest/stats")
public class StatsRestController extends AbstractRestController<Stats> {
	@Autowired
	public StatsRestController(StatsService statsService) {
		super.setGenericService(statsService);
	}
}