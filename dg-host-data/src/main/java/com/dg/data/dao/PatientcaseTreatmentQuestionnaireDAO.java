package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;
import com.dg.data.model.domain.PatientcaseTreatmentQuestionnaireDetailModel;

/**
 * This is a PatientcaseTreatmentQuestionnaire DAO interface which includes the
 * most fundamental DAO operations (findByPatientcase, etc) for
 * PatientcaseTreatmentQuestionnaire object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */
public interface PatientcaseTreatmentQuestionnaireDAO
		extends GenericDAO<PatientcaseTreatmentQuestionnaire> {

	/**
	 * Find the list of PatientcaseTreatmentQuestionnaire object based on
	 * patientcase id
	 * @param patientcase the unique id of patientcase
	 * @return the list of PatientcaseTreatmentQuestionnaire object or null if
	 * it cannot be found
	 */
	public List<PatientcaseTreatmentQuestionnaire> findByPatientcase(
			BigInteger patientcase);

	/**
	 * Find the list of PatientcaseTreatmentQuestionnaireDetailModel object
	 * based on patientcase id
	 * @param patientcase the unique id of patientcase
	 * @return the list of PatientcaseTreatmentQuestionnaireDetailModel object
	 * or null if it cannot be found
	 */
	public List<PatientcaseTreatmentQuestionnaireDetailModel> findByPc(
			BigInteger patientcase);

}