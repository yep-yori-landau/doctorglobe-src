
package com.dg.data.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.City;
import com.dg.data.service.CityService;

/**
 * @author DoctorGlobe Handles all interactions with the City table.
 */
@Controller
@RequestMapping(value = "/rest/city")
public class CityRestController extends AbstractRestController<City> {
	@Autowired
	public CityRestController(CityService cityService) {
		super.setGenericService(cityService);
	}

	@Autowired
	public CityService cityService;

	// Provides interface to get City by Country
	@RequestMapping(value = "/get/country/{country}", method = RequestMethod.GET)
	public @ResponseBody List<City> getByCountry(
			@PathVariable("country") int country) {
		return cityService.findByCountry(country);
	}

	// Provides interface to get City by State
	@RequestMapping(value = "/get/state/{state}", method = RequestMethod.GET)
	public @ResponseBody List<City> getByState(
			@PathVariable("state") int state) {
		return cityService.findByState(state);
	}
}