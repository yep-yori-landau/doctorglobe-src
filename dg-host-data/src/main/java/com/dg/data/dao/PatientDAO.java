/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.Patient;
import com.dg.data.model.domain.PatientCountryModel;
import com.dg.data.model.domain.PatientDetailModel;
import com.dg.data.model.domain.PatientLatLonModel;

/**
 * This is a Patient DAO interface which includes the most fundamental DAO
 * operations (findByEmail, etc) for Patient object It also extends the generic
 * DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientDAO extends GenericDAO<Patient> {

	/**
	 * Find Patient object based on patient email and active status
	 * @param email the unique email address of patient
	 * @param active 1
	 * @return the Patient object
	 */
	public Patient findByEmail(String email, Integer active);

	/**
	 * Find the list of PatientDetailModel object based on practitioner id
	 * @param practitioner the unique id of practitioner
	 * @return the list of PatientDetailModel object or null if it cannot be
	 * found
	 */
	public List<PatientDetailModel> findByPractitionerId(Integer practitioner);

	/**
	 * Find the list of PatientDetailModel object based on patientcase id and
	 * practitioner id
	 * @param patientcase the unique id of patientcase
	 * @return the list of PatientDetailModel object or null if it cannot be
	 * found
	 */
	public List<PatientDetailModel> findByPatientcase(Integer patientcase,
			Integer practitioner);

	/**
	 * update the patient old password to new password
	 * @param id the unique id of patient
	 * @param old_password
	 * @param new_password
	 * @return Integer 1 or 0 if password not updated
	 */
	public Integer resetPassword(Integer id, String old_password,
			String new_password);

	/**
	 * Find PatientCountryModel object based on patient id
	 * @param id the unique id of patient
	 * @return the PatientCountryModel object
	 */
	public PatientCountryModel findCountryById(Integer id);

	/**
	 * Find PatientLatLonModel object based on patient id
	 * @param id the unique id of patient
	 * @return the PatientLatLonModel object
	 */
	public PatientLatLonModel findLatLonById(Integer id);

	/**
	 * Find Patient object based on patient phone
	 * @param phone the phone no of patient
	 * @return the PatientModel object
	 */
	public Patient findByPhone(String phone, Integer active);
}
