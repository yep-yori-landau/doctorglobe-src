package com.dg.data.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dg.data.model.db.AclRoles;
import com.dg.data.service.AclRolesService;

/**
 * Handles all crud operations for AclRoles table.
 * @author DoctorGlobe
 */
@Controller
@RequestMapping(value = "/aclroles")
public class AclRolesController extends AbstractController<AclRoles> {
	@Autowired
	public AclRolesController(AclRolesService aclrolesService) {
		super.setGenericService(aclrolesService);
		super.setView("aclroles");
	}

}