
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AclRolesDAO;
import com.dg.data.model.db.AclRoles;
import com.dg.data.service.AclRolesService;

/**
 * @author DoctorGlobe AclRolesService Implementation
 */
@Service("aclRolesService")
public class AclRolesServiceImpl extends GenericServiceImpl<AclRoles>
		implements AclRolesService {

	/**
	 * Constructor.
	 * @param genericDAO (required) DAO object of the AclRolesDAO set a
	 * AclRolesDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AclRolesServiceImpl(AclRolesDAO genericDAO) {
		super(genericDAO);
	}

}
