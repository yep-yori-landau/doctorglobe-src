/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderSpecialty;

/**
 * This is a HealthcareproviderSpecialtyService service interface which includes
 * the most fundamental service operations for
 * HealthcareproviderSpecialtyService object It also extends the generic service
 * CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderSpecialtyService
		extends GenericService<HealthcareproviderSpecialty> {
	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return list of helathcareprovider specialty
	 */
	public List<HealthcareproviderSpecialty> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
