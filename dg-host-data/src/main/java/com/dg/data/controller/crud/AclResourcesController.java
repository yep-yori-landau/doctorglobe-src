package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.AclResources;
import com.dg.data.service.AclResourcesService;

/**
 * Handles all crud operations for AclResources table.
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/aclresources")
public class AclResourcesController extends AbstractController<AclResources> {
	@Autowired
	public AclResourcesController(AclResourcesService aclresourcesService) {
		super.setGenericService(aclresourcesService);
		super.setView("aclresources");
	}
}