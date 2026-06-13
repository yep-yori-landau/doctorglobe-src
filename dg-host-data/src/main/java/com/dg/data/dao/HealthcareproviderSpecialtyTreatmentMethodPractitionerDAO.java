/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;
import com.dg.data.model.domain.HospitalPractitionerModel;

/**
 * This is a HealthcareproviderSpecialtyTreatmentMethodPractitioner DAO
 * interface which includes the most fundamental DAO operations
 * (findByHealthcareprovider, etc) for any
 * HealthcareproviderSpecialtyTreatmentMethodPractitioner object It also extends
 * the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO
		extends
		GenericDAO<HealthcareproviderSpecialtyTreatmentMethodPractitioner> {

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * object based on healthcareprovider_specialty_treatment_method id
	 * @param hstm the unique id of
	 * healthcareprovider_specialty_treatment_method
	 * @return the list of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner object or null if
	 * it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHstm(
			BigInteger hstm);

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * object based on healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner object or null if
	 * it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * object based on below params
	 * @param hstm the unique id of
	 * healthcareprovider_specialty_treatment_method
	 * @param practitioner the unique id of practitioner
	 * @return the HealthcareproviderSpecialtyTreatmentMethodPractitioner object
	 */
	public HealthcareproviderSpecialtyTreatmentMethodPractitioner findByHstmPractitioner(
			BigInteger hstm, BigInteger practitioner);

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * object based on specialty id
	 * @param specialty the unique id of specialty
	 * @return the list of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner object or null if
	 * it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findBySpecialty(
			BigInteger specialty);

	/**
	 * Find the list of HospitalPractitionerModel object based on
	 * healthcareprovider_specialty_treatment_method id
	 * @param hstm the unique id of
	 * healthcareprovider_specialty_treatment_method
	 * @return the list of HospitalPractitionerModel object or null if it cannot
	 * be found
	 */
	public List<HospitalPractitionerModel> findByHstmId(BigInteger hstm);
}
