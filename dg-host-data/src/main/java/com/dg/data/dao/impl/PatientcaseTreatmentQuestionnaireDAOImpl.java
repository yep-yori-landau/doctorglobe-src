package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.PatientcaseTreatmentQuestionnaireDAO;
import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;
import com.dg.data.model.db.mapper.PatientcaseTreatmentQuestionnaireMapper;
import com.dg.data.model.domain.PatientcaseTreatmentQuestionnaireDetailModel;
import com.dg.data.model.domain.mapper.PatientcaseTreatmentQuestionnaireDetailMapper;

/**
 * This class represent Implementation of PatientcaseTreatmentQuestionnaireDAO
 * which can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */
public class PatientcaseTreatmentQuestionnaireDAOImpl
		extends GenericDAOImpl<PatientcaseTreatmentQuestionnaire>
		implements PatientcaseTreatmentQuestionnaireDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientcaseTreatmentQuestionnaireDAOImpl.class);

	@Override
	public List<PatientcaseTreatmentQuestionnaire> findByPatientcase(
			BigInteger patientcase) {
		List<PatientcaseTreatmentQuestionnaire> patientcaseTreatmentQuestionnaire = null;
		String query = "Select *from patientcase_treatment_questionnaire where patientcase = ?";
		patientcaseTreatmentQuestionnaire = this.getJdbcTemplate().query(query,
				new Object[] { patientcase },
				new PatientcaseTreatmentQuestionnaireMapper());
		return patientcaseTreatmentQuestionnaire;
	}

	@Override
	public List<PatientcaseTreatmentQuestionnaireDetailModel> findByPc(
			BigInteger patientcase) {
		List<PatientcaseTreatmentQuestionnaireDetailModel> model = null;
		String query = "Select ptq.value as value,q.name as name from patientcase_treatment_questionnaire ptq left join treatment_questionnaire tq on tq.id = ptq.treatment_questionnaire"
				+ " left join questionnaire q on q.id = tq.questionnaire"
				+ " where ptq.patientcase = ?";
		model = this.getJdbcTemplate().query(query,
				new Object[] { patientcase },
				new PatientcaseTreatmentQuestionnaireDetailMapper());
		return model;
	}
}