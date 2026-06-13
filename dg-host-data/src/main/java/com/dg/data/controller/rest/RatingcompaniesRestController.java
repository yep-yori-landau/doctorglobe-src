
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Ratingcompanies;
import com.dg.data.service.RatingcompaniesService;

/**
 * @author doctorGlobe Handles all interactions with the Ratingcompanies table.
 */
@Controller
@RequestMapping(value = "/rest/ratingcompanies")
public class RatingcompaniesRestController
		extends AbstractRestController<Ratingcompanies> {
	@Autowired
	public RatingcompaniesRestController(
			RatingcompaniesService ratingcompaniesService) {
		super.setGenericService(ratingcompaniesService);
	}
}