package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Ratingcompanies;
import com.dg.data.service.RatingcompaniesService;

/**
 * Handles all crud operations for Ratingcompanies table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/ratingcompanies")
public class RatingcompaniesController
		extends AbstractController<Ratingcompanies> {
	@Autowired
	public RatingcompaniesController(
			RatingcompaniesService ratingcompaniesService) {
		super.setGenericService(ratingcompaniesService);
	}
}