
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AclPermissionsDAO;
import com.dg.data.model.db.AclPermissions;
import com.dg.data.service.AclPermissionsService;

/**
 * @author DoctorGlobe AclPermissionsService Implementation
 */
@Service("aclPermissionsService")
public class AclPermissionsServiceImpl extends
		GenericServiceImpl<AclPermissions>implements AclPermissionsService {

	/**
	 * Constructor.
	 * @param genericDAO (required) DAO object of the AclPermissionsDAO set a
	 * AclPermissionsDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AclPermissionsServiceImpl(AclPermissionsDAO genericDAO) {
		super(genericDAO);
	}

}
