
package com.dg.data.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.PatientcaseTreatmentQuestionnaireDAO;
import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;
import com.dg.data.model.domain.PatientcaseTreatmentQuestionnaireDetailModel;
import com.dg.data.service.PatientcaseTreatmentQuestionnaireService;

/**
 * @author DoctorGlobe PatientcaseTreatmentQuestionnaireService CountryService
 */

@Service("patientcaseTreatmentQuestionnaireService")
public class PatientcaseTreatmentQuestionnaireServiceImpl
		extends GenericServiceImpl<PatientcaseTreatmentQuestionnaire>
		implements PatientcaseTreatmentQuestionnaireService {

	private PatientcaseTreatmentQuestionnaireDAO patientcaseTreatmentQuestionnaireDAO;

	@Autowired
	public PatientcaseTreatmentQuestionnaireServiceImpl(
			PatientcaseTreatmentQuestionnaireDAO genericDAO) {
		super(genericDAO);
		this.patientcaseTreatmentQuestionnaireDAO = (PatientcaseTreatmentQuestionnaireDAO) genericDAO;
	}

	/**
	 * find By Patientcase
	 * @param patientcase
	 * @return
	 */
	@Override
	public List<PatientcaseTreatmentQuestionnaire> findByPatientcase(
			BigInteger patientcase) {
		return this.patientcaseTreatmentQuestionnaireDAO
				.findByPatientcase(patientcase);
	}

	/**
	 * find By Pc
	 * @param patientcase
	 * @return
	 */
	@Override
	public List<PatientcaseTreatmentQuestionnaireDetailModel> findByPc(
			BigInteger patientcase) {
		return this.patientcaseTreatmentQuestionnaireDAO.findByPc(patientcase);
	}

}
