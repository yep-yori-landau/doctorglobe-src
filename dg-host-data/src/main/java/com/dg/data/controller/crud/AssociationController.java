
package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.Association;
import com.dg.data.service.AssociationService;

/**
 * Handles all crud operations for Association table
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/association")
public class AssociationController extends AbstractController<Association> {

	@Autowired
	public AssociationController(AssociationService associationService) {
		super.setGenericService(associationService);
	}
}