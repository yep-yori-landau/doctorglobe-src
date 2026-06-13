package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Specialty;
import com.dg.data.service.SpecialtyService;

/**
 * Handles all crud operations for Specialty table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/specialty")
public class SpecialtyController extends AbstractController<Specialty> {
	@Autowired
	public SpecialtyController(SpecialtyService specialtyService) {
		super.setGenericService(specialtyService);
	}
}