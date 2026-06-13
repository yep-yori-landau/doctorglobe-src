
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Country;
import com.dg.data.service.CountryService;

/**
 * @author DoctorGlobe Handles all interactions with the Country table.
 */
@Controller
@RequestMapping(value = "/rest/country")
public class CountryRestController extends AbstractRestController<Country> {
	@Autowired
	public CountryRestController(CountryService countryService) {
		super.setGenericService(countryService);
	}

}