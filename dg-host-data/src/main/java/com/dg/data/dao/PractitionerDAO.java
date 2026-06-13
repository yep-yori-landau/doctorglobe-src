/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.Practitioner;
import com.dg.data.model.domain.HealthcareproviderPractitionerCountryModel;
import com.dg.data.model.domain.HealthcareproviderPractitionerModel;
import com.dg.data.model.domain.PractitionerDetail;

/**
 * This is a Practitioner DAO interface which includes the most fundamental DAO
 * operations (findByEmail, etc) for Practitioner object It also extends the
 * generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PractitionerDAO extends GenericDAO<Practitioner> {

	/**
	 * Find the list of PractitionerDetail object based on healthcareprovider id
	 * and treatment id
	 * @param id the unique id of healthcareprovider
	 * @param treatment the unique id of treatment
	 * @return the list of PractitionerDetail object or null if it cannot be
	 * found
	 */
	public List<PractitionerDetail> findByHealthcareproviderId(Integer id,
			Integer treatment);

	/**
	 * Find Practitioner object based on patient email and active status
	 * @param email the unique email address of patient
	 * @param active 1
	 * @return the Practitioner object
	 */
	public Practitioner findByEmail(String email, Integer active);

	/**
	 * update the practitioner old password to new password
	 * @param id the unique id of patient
	 * @param old_password
	 * @param new_password
	 * @return Integer 1 or 0 if password not updated
	 */
	public Integer resetPassword(Integer id, String old_password,
			String new_password);

	/**
	 * Find the list of HealthcareproviderPractitionerModel object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderPractitionerModel object or null if
	 * it cannot be found
	 */
	public List<HealthcareproviderPractitionerModel> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * Find the list of HealthcareproviderPractitionerCountryModel object based
	 * on hcpstmp id
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @return the list of HealthcareproviderPractitionerCountryModel object or
	 * null if it cannot be found
	 */
	public List<HealthcareproviderPractitionerCountryModel> findByHstmp(
			BigInteger hstmp);

	/**
	 * Find the list of PractitionerDetail object based on below params
	 * @param id the unique id of practitioner
	 * @param treatment the unique id of treatment
	 * @param ccinsurance the unique id of corporate compnay insurance
	 * @return the list of PatientDetailModel object or null if it cannot be
	 * found
	 */
	public List<PractitionerDetail> findCorporatecompanyInsurancePractitioner(
			Integer id, Integer treatment, BigInteger ccinsurance);

	/**
	 * Find the list of Practitioner object based on given name
	 * @param name the name of practitioner
	 * @return Practitioner object or null if it cannot be found
	 */
	public Practitioner findByName(String name);
}
