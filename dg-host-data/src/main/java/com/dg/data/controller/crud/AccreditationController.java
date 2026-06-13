package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Accreditation;
import com.dg.data.service.AccreditationService;

/**
 * Handles all crud operations for accreditation table.
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/accreditation")
public class AccreditationController extends AbstractController<Accreditation> {
	@Autowired
	public AccreditationController(AccreditationService accreditationService) {
		super.setGenericService(accreditationService);
	}
}