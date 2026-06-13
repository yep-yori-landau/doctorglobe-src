
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientreviewratingsDAO;
import com.dg.data.model.db.Patientreviewratings;
import com.dg.data.service.PatientreviewratingsService;

/**
 * @author DoctorGlobe PatientreviewratingsService CountryService
 */

@Service("patientreviewratingsService")
public class PatientreviewratingsServiceImpl
		extends GenericServiceImpl<Patientreviewratings>
		implements PatientreviewratingsService {

	@Autowired
	public PatientreviewratingsServiceImpl(PatientreviewratingsDAO genericDAO) {
		super(genericDAO);
	}

}