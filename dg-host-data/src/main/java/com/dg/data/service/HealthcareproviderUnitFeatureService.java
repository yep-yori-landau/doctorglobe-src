/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderUnitFeature;

/**
 * This is a HealthcareproviderUnitFeatureService service interface which
 * includes the most fundamental service operations for
 * HealthcareproviderUnitFeatureService object It also extends the generic
 * service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderUnitFeatureService
		extends GenericService<HealthcareproviderUnitFeature> {
	/**
	 * find By Healthcare provider
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderUnitFeature> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
