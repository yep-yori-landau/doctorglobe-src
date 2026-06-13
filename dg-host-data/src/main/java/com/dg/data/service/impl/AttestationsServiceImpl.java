
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AttestationsDAO;
import com.dg.data.dao.GenericDAO;
import com.dg.data.model.db.Attestations;
import com.dg.data.service.AttestationsService;

/**
 * @author DoctorGlobe AttestationsService Implementation
 */

@Service("attestationsService")
public class AttestationsServiceImpl extends GenericServiceImpl<Attestations>
		implements AttestationsService {

	@Autowired
	public AttestationsServiceImpl(AttestationsDAO genericDAO) {
		super(genericDAO);
	}

}
