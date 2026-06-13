
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Specialty;
import com.dg.data.service.SpecialtyService;

/**
 * @author doctorGlobe Handles all interactions with the Specialty.
 */
@Controller
@RequestMapping(value = "/rest/specialty")
public class SpecialtyRestController extends AbstractRestController<Specialty> {
	@Autowired
	public SpecialtyRestController(SpecialtyService specialtyService) {
		super.setGenericService(specialtyService);
	}
}