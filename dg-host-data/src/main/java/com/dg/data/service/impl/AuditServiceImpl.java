
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AuditDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Audit;
import com.dg.data.service.AuditService;

/**
 * @author DoctorGlobe AuditService Implementation
 */

@Service("auditService")
public class AuditServiceImpl extends GenericServiceImpl<Audit>
		implements AuditService {

	@Autowired
	public AuditServiceImpl(AuditDAO genericDAO) {
		super(genericDAO);
	}
}
