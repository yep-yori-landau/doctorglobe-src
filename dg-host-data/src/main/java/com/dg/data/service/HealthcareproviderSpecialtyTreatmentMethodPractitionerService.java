/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;
import com.dg.data.model.domain.HospitalPractitionerModel;

/**
 * This is a HealthcareproviderSpecialtyTreatmentMethodPractitionerService
 * service interface which includes the most fundamental service operations for
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderSpecialtyTreatmentMethodPractitionerService
		extends
		GenericService<HealthcareproviderSpecialtyTreatmentMethodPractitioner> {
	/**
	 * find By Hstm
	 * @param hstm
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHstm(
			BigInteger hstm);

	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * find By Hstm Practitioner
	 * @param hstm
	 * @param practitioner
	 * @return
	 */
	public HealthcareproviderSpecialtyTreatmentMethodPractitioner findByHstmPractitioner(
			BigInteger hstm, BigInteger practitioner);

	/**
	 * find By Specialty
	 * @param specialty
	 * @return
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findBySpecialty(
			BigInteger specialty);

	/**
	 * find By Hstm Id
	 * @param hstm
	 * @return
	 */
	public List<HospitalPractitionerModel> findByHstmId(BigInteger hstm);
}
