
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dg.data.dao.PatientconferenceDAO;
import com.dg.data.model.db.Patientconference;
import com.dg.data.model.domain.PatientConferenceDetailModel;
import com.dg.data.service.PatientconferenceService;

/**
 * @author DoctorGlobe PatientconferenceService CountryService
 */

@Service("patientconferenceService")
public class PatientconferenceServiceImpl
		extends GenericServiceImpl<Patientconference>
		implements PatientconferenceService {

	private PatientconferenceDAO patientconferenceDAO;

	@Autowired
	public PatientconferenceServiceImpl(PatientconferenceDAO genericDAO) {
		super(genericDAO);
		this.patientconferenceDAO = genericDAO;
	}

	/**
	 * find By Patient Case
	 * @param patientcase
	 * @return
	 */
	@Override
	public List<PatientConferenceDetailModel> findByPatientCase(
			Integer patientcase, Integer patient) {
		return this.patientconferenceDAO.findByPatientCase(patientcase,
				patient);
	}

	/**
	 * find By Patient Case And Hcpstmp
	 * @param patientcase
	 * @param hcpstmp
	 * @return
	 */
	@Override
	public List<Patientconference> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp) {
		return this.patientconferenceDAO
				.findByPatientCaseAndHcpstmp(patientcase, hcpstmp);
	}

	/**
	 * find By Patient And Treatment And Hcpstmp
	 * @param patient
	 * @param treatment
	 * @param hcpstmp
	 * @return
	 */
	@Override
	public Boolean findByPatientAndTreatmentAndHcpstmp(int patient,
			int treatment, int hcpstmp) {
		return this.patientconferenceDAO.findByPatientAndTreatmentAndHcpstmp(
				patient, treatment, hcpstmp);
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
		return this.patientconferenceDAO.editStatus(pc, hcpstmp, status);
	}

	/**
	 * find Total Patient Treatment Conference By Patient And Treatment
	 * @param patient
	 * @param treatment
	 * @return
	 */
	@Override
	public Integer findTotalPatientTreatmentConferenceByPatientAndTreatment(
			int patient, int treatment) {
		return this.patientconferenceDAO
				.findTotalPatientTreatmentConferenceByPatientAndTreatment(
						patient, treatment);
	}

}