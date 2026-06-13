package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Practitionertype;
import com.dg.data.service.PractitionertypeService;

/**
 * Handles all crud operations for Practitionertype table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/practitionertype")
public class PractitionertypeController
		extends AbstractController<Practitionertype> {
	@Autowired
	public PractitionertypeController(
			PractitionertypeService practitionertypeService) {
		super.setGenericService(practitionertypeService);
	}
}