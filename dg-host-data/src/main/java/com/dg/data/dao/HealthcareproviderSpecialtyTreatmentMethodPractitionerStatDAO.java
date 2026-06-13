/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;

/**
 * This is a HealthcareproviderSpecialtyTreatmentMethodPractitionerStat DAO
 * interface which includes the most fundamental DAO operations (findByHstmp,
 * etc) for any HealthcareproviderSpecialtyTreatmentMethodPractitionerStat
 * object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO
		extends
		GenericDAO<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> {

	/**
	 * Find the list of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat object based
	 * on healthcareprovider_specialty_treatment_method_practitioner id
	 * @param hstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @return the list of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat object or null
	 * if it cannot be found
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> findByHstmp(
			BigInteger hstmp);
}
