package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.AccreditationDAO;
import com.dg.data.model.db.Accreditation;
import com.dg.data.service.AccreditationService;

/**
 * @author DoctorGlobe AccreditationService Implementation
 */
@Service("accreditationService")
public class AccreditationServiceImpl extends GenericServiceImpl<Accreditation>
		implements AccreditationService {

	/**
	 * Constructor.
	 * @param genericDAO (required) DAO object of the AccreditationDAO set a
	 * AccreditationDAO object in GenericServiceImpl class
	 */
	@Autowired
	public AccreditationServiceImpl(AccreditationDAO genericDAO) {
		super(genericDAO);
	}

}