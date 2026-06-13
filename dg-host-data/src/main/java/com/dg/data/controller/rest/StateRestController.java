
package com.dg.data.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dg.data.model.db.State;
import com.dg.data.service.StateService;

/**
 * @author doctorGlobe Handles all interactions with the State table.
 */
@Controller
@RequestMapping(value = "/rest/state")
public class StateRestController extends AbstractRestController<State> {
	@Autowired
	public StateRestController(StateService stateService) {
		super.setGenericService(stateService);
	}

	@Autowired
	public StateService stateService;

	// Provides interface to get State by country
	@RequestMapping(value = "/get/country/{country}", method = RequestMethod.GET)
	public @ResponseBody List<State> getByCountry(
			@PathVariable("country") int country) {
		return stateService.findByCountry(country);
	}
}