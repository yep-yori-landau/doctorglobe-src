/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;

/**
 * This is a HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService
 * service interface which includes the most fundamental service operations for
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService object It
 * also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderSpecialtyTreatmentMethodPractitionerStatService
		extends
		GenericService<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> {
	/**
	 * find By Hstmp
	 * @param hstmp
	 * @return list
	 */
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> findByHstmp(
			BigInteger hstmp);
}
