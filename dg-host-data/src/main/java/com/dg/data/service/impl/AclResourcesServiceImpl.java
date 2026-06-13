
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AclResourcesDAO;
import com.dg.data.model.db.AclResources;
import com.dg.data.service.AclResourcesService;

/**
 * @author DoctorGlobe AclResourcesService Implementation
 */
@Service("aclResourcesService")
public class AclResourcesServiceImpl extends GenericServiceImpl<AclResources>
		implements AclResourcesService {

	/**
	 * Constructor.
	 * @param genericDAO (required) DAO object of the AclResourcesDAO set a
	 * AclResourcesDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AclResourcesServiceImpl(AclResourcesDAO genericDAO) {
		super(genericDAO);
	}
}
