/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;

/**
 * This is a HealthcareproviderSpecialtyTreatmentMethodService service interface
 * which includes the most fundamental service operations for
 * HealthcareproviderSpecialtyTreatmentMethodService object It also extends the
 * generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderSpecialtyTreatmentMethodService
		extends GenericService<HealthcareproviderSpecialtyTreatmentMethod> {

	/**
	 * find By Healthcareprovider Specialty
	 * @param healthcareproviderSpecialty
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialty(
			BigInteger healthcareproviderSpecialty);

	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * find By Healthcareprovider Specialty Treatment
	 * @param healthcareprovider_specialty
	 * @param treatment
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialtyTreatment(
			BigInteger healthcareprovider_specialty, BigInteger treatment);

	/**
	 * find By Healthcareprovider Specialty Treatment Method
	 * @param healthcareprovider_specialty
	 * @param treatment
	 * @param method
	 * @return
	 */
	public HealthcareproviderSpecialtyTreatmentMethod findByHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty, BigInteger treatment,
			BigInteger method);

	/**
	 * find By Specialty
	 * @param specialty
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethod> findBySpecialty(
			BigInteger specialty);
}
