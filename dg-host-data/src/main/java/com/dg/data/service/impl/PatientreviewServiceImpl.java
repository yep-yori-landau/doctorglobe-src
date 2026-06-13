
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientreviewDAO;
import com.dg.data.model.db.Patientreview;
import com.dg.data.service.PatientreviewService;

/**
 * @author DoctorGlobe PatientreviewService CountryService
 */

@Service("patientreviewService")
public class PatientreviewServiceImpl extends GenericServiceImpl<Patientreview>
		implements PatientreviewService {

	@Autowired
	public PatientreviewServiceImpl(PatientreviewDAO genericDAO) {
		super(genericDAO);
	}

}
