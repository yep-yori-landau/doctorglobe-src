
package com.dg.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcaseauditDAO;
import com.dg.data.model.db.Patientcaseaudit;
import com.dg.data.service.PatientcaseauditService;

/**
 * @author DoctorGlobe PatientcaseauditService CountryService
 */

@Service("patientcaseauditService")
public class PatientcaseauditServiceImpl extends
		GenericServiceImpl<Patientcaseaudit>implements PatientcaseauditService {

	@Autowired
	public PatientcaseauditServiceImpl(PatientcaseauditDAO genericDAO) {
		super(genericDAO);
	}
}
