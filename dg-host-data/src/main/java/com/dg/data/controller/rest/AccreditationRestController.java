
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Accreditation;
import com.dg.data.service.AccreditationService;

/**
 * @author DoctorGlobe Handles all interactions with the accreditation table.
 */
@Controller
@RequestMapping(value = "/rest/accreditation")
public class AccreditationRestController
		extends AbstractRestController<Accreditation> {
	@Autowired
	public AccreditationRestController(
			AccreditationService accreditationService) {
		super.setGenericService(accreditationService);
	}
}