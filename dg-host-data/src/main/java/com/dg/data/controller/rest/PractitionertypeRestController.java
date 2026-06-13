
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dg.data.model.db.Practitionertype;
import com.dg.data.service.PractitionertypeService;

/**
 * @author doctorGlobe Handles all interactions with the Practitionertype table.
 */
@Controller
@RequestMapping(value = "/rest/practitionertype")
public class PractitionertypeRestController
		extends AbstractRestController<Practitionertype> {
	@Autowired
	public PractitionertypeRestController(
			PractitionertypeService practitionertypeService) {
		super.setGenericService(practitionertypeService);
	}
}