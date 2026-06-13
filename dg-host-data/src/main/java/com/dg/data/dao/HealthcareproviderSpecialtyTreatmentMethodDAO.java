/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;

/**
 * This is a HealthcareproviderSpecialtyTreatmentMethod DAO interface which
 * includes the most fundamental DAO operations (findByHealthcareprovider, etc)
 * for any HealthcareproviderSpecialtyTreatmentMethod object It also extends the
 * generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderSpecialtyTreatmentMethodDAO
		extends GenericDAO<HealthcareproviderSpecialtyTreatmentMethod> {

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethod object based
	 * on healthcareproviderSpecialty id
	 * @param healthcareproviderSpecialty the unique id of
	 * healthcareproviderSpecialty
	 * @return the list of HealthcareproviderSpecialtyTreatmentMethod object or
	 * null if it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialty(
			BigInteger healthcareproviderSpecialty);

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethod object based
	 * on healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderSpecialtyTreatmentMethod object or
	 * null if it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethod object based
	 * on below params
	 * @param healthcareprovider_specialty the unique id of
	 * healthcareproviderSpecialty
	 * @param treatment the unique id of treatment
	 * @return the list of HealthcareproviderSpecialtyTreatmentMethod object or
	 * null if it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialtyTreatment(
			BigInteger healthcareprovider_specialty, BigInteger treatment);

	/**
	 * Find the HealthcareproviderSpecialtyTreatmentMethod object based on below
	 * params
	 * @param healthcareprovider_specialty the unique id of
	 * healthcareproviderSpecialty
	 * @param treatment the unique id of treatment
	 * @param method the unique id of method
	 * @return HealthcareproviderSpecialtyTreatmentMethod object
	 */
	public HealthcareproviderSpecialtyTreatmentMethod findByHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty, BigInteger treatment,
			BigInteger method);

	/**
	 * Find the list of HealthcareproviderSpecialtyTreatmentMethod object based
	 * on specialty id
	 * @param specialty the unique id of specialty
	 * @return the list of HealthcareproviderSpecialtyTreatmentMethod object or
	 * null if it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findBySpecialty(
			BigInteger specialty);
}
