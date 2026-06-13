
package com.dg.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcasefileDAO;
import com.dg.data.model.db.Patientcasefile;
import com.dg.data.service.PatientcasefileService;

/**
 * @author DoctorGlobe PatientcasefileService CountryService
 */

@Service("patientcasefileService")
public class PatientcasefileServiceImpl extends
		GenericServiceImpl<Patientcasefile>implements PatientcasefileService {

	private PatientcasefileDAO patientcasefileDAO;

	@Autowired
	public PatientcasefileServiceImpl(PatientcasefileDAO genericDAO) {
		super(genericDAO);
		this.patientcasefileDAO = (PatientcasefileDAO) genericDAO;
	}

	/**
	 * find By Patient Case Id
	 * @param patientcase
	 * @return
	 */
	@Override
	public List<Patientcasefile> findByPatientCaseId(Integer patientcase) {
		return this.patientcasefileDAO.findByPatientCaseId(patientcase);
	}

}
