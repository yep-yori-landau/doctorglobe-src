package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Stats;
import com.dg.data.service.StatsService;

/**
 * Handles all crud operations for Stats table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/stats")
public class StatsController extends AbstractController<Stats> {
	@Autowired
	public StatsController(StatsService statsService) {
		super.setGenericService(statsService);
	}
}