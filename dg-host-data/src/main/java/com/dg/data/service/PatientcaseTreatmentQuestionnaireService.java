/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;
import com.dg.data.model.domain.PatientcaseTreatmentQuestionnaireDetailModel;

/**
 * This is a PatientcaseTreatmentQuestionnaireService service interface which
 * includes the most fundamental service operations for
 * PatientcaseTreatmentQuestionnaireService object It also extends the generic
 * service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientcaseTreatmentQuestionnaireService
		extends GenericService<PatientcaseTreatmentQuestionnaire> {
	/**
	 * find By Patientcase
	 * @param patientcase
	 * @return
	 */
	public List<PatientcaseTreatmentQuestionnaire> findByPatientcase(
			BigInteger patientcase);

	/**
	 * find By Pc
	 * @param patientcase
	 * @return
	 */
	public List<PatientcaseTreatmentQuestionnaireDetailModel> findByPc(
			BigInteger patientcase);

}
