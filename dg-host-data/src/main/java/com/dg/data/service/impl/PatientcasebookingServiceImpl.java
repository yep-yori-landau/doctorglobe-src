
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcasebookingDAO;
import com.dg.data.model.db.Patientcasebooking;
import com.dg.data.service.PatientcasebookingService;

/**
 * @author DoctorGlobe PatientcasebookingService CountryService
 */

@Service("patientcasebookingService")
public class PatientcasebookingServiceImpl
		extends GenericServiceImpl<Patientcasebooking>
		implements PatientcasebookingService {

	private PatientcasebookingDAO patientcasebookingDAO;

	@Autowired
	public PatientcasebookingServiceImpl(PatientcasebookingDAO genericDAO) {
		super(genericDAO);
		this.patientcasebookingDAO = (PatientcasebookingDAO) genericDAO;
	}

	/**
	 * edit Status
	 * @param pc
	 * @param hcpstmp
	 * @param status
	 * @return
	 */
	@Override
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp,
			String status) {
		return this.patientcasebookingDAO.editStatus(pc, hcpstmp, status);
	}

	/**
	 * find By Patient Case And Hcpstmp
	 * @param patientcase
	 * @param hcpstmp
	 * @return
	 */
	@Override
	public List<Patientcasebooking> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp) {
		return this.patientcasebookingDAO
				.findByPatientCaseAndHcpstmp(patientcase, hcpstmp);
	}

	/**
	 * find By Patient And Treatment
	 * @param patient
	 * @param treatment
	 * @return
	 */
	@Override
	public List<Patientcasebooking> findByPatientAndTreatment(int patient,
			int treatment) {
		return this.patientcasebookingDAO.findByPatientAndTreatment(patient,
				treatment);
	}

	/**
	 * find By Patient Case
	 * @param patientcase
	 * @return
	 */
	@Override
	public List<Patientcasebooking> findByPatientCase(int patientcase) {
		return this.findByPatientCase(patientcase);
	}

}
