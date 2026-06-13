
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.AclPermissions;
import com.dg.data.service.AclPermissionsService;

/**
 * @author DoctorGlobe Handles all interactions with the AclPermissions table.
 */
@Controller
@RequestMapping(value = "/rest/acl-permissions")
public class AclPermissionsRestController
		extends AbstractRestController<AclPermissions> {
	@Autowired
	public AclPermissionsRestController(
			AclPermissionsService aclPermissionsService) {
		super.setGenericService(aclPermissionsService);
	}
}