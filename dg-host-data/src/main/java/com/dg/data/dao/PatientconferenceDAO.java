/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.Patientconference;
import com.dg.data.model.domain.PatientConferenceDetailModel;

/**
 * This is a Patientconference DAO interface which includes the most fundamental
 * DAO operations (findByPatientcase, etc) for Patientconference object It also
 * extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientconferenceDAO extends GenericDAO<Patientconference> {

	/**
	 * Find the list of PatientConferenceDetailModel object based on patientcase
	 * id and patient id
	 * @param patientcase the unique id of patientcase
	 * @return the list of PatientConferenceDetailModel object or null if it
	 * cannot be found
	 */
	public List<PatientConferenceDetailModel> findByPatientCase(
			Integer patientcase, Integer patient);

	/**
	 * Find the list of Patientconference object based on patientcase id and
	 * healthcareprovider_specialty_treatment_method_practitioner id
	 * @param patientcase the unique id of patientcase
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @return the list of PatientcaseTreatmentQuestionnaire object or null if
	 * it cannot be found
	 */
	public List<Patientconference> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp);

	/**
	 * Check patient conference exist or not for below params
	 * @param patient the unique id of patient
	 * @param treatment the unique id of treatment
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @return boolean true or false if patient conference not exist
	 */
	public Boolean findByPatientAndTreatmentAndHcpstmp(Integer patient,
			Integer treatment, Integer hcpstmp);

	/**
	 * Change the status of patientconference object
	 * @param pc the unique id of patientcase
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @param status the status of patientconference
	 * @return Integer 1 or 0 if it cannot updated
	 */
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp, String status);

	/**
	 * Find the count of total patient conference based on below params
	 * @param patient the unique id of patient
	 * @param treatment the unique id of treatment
	 * @return Integer the count of total patient conference
	 */
	public Integer findTotalPatientTreatmentConferenceByPatientAndTreatment(
			Integer patient, Integer treatment);
}
