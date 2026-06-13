
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.AclResources;
import com.dg.data.service.AclResourcesService;

/**
 * @author DoctorGlobe
 * 
 * Handles all interactions with the AclResources table.
 */
@Controller
@RequestMapping(value = "/rest/acl-resources")
public class AclResourcesRestController
		extends AbstractRestController<AclResources> {
	@Autowired
	public AclResourcesRestController(AclResourcesService aclResourcesService) {
		super.setGenericService(aclResourcesService);
	}
}