
package com.dg.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcaseDAO;
import com.dg.data.model.db.Patientcase;
import com.dg.data.model.domain.PatientcaseDetailModel;
import com.dg.data.service.PatientcaseService;

/**
 * @author DoctorGlobe PatientcaseService CountryService
 */

@Service("patientcaseService")
public class PatientcaseServiceImpl extends GenericServiceImpl<Patientcase>
		implements PatientcaseService {

	private PatientcaseDAO patientcaseDAO;

	@Autowired
	public PatientcaseServiceImpl(PatientcaseDAO genericDAO) {
		super(genericDAO);
		this.patientcaseDAO = (PatientcaseDAO) genericDAO;
	}

	/**
	 * find By Patient Id
	 * @param patient
	 * @return
	 */
	@Override
	public List<PatientcaseDetailModel> findByPatientId(Integer patient) {
		return this.patientcaseDAO.findByPatientId(patient);
	}

	/*
	 * edit Status
	 * 
	 * @param id
	 * 
	 * @param status
	 * 
	 * @return integer
	 */
	@Override
	public Integer editStatus(int id, String status) {
		return this.patientcaseDAO.editStatus(id, status);
	}

}