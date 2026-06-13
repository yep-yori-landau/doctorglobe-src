
package com.dg.data.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.AclRoles;
import com.dg.data.service.AclRolesService;

/**
 * @author DoctorGlobe Handles all interactions with the AclRoles table.
 */
@Controller
@RequestMapping(value = "/rest/acl-roles")
public class AclRolesRestController extends AbstractRestController<AclRoles> {
	@Autowired
	public AclRolesRestController(AclRolesService aclRolesService) {
		super.setGenericService(aclRolesService);
	}
}