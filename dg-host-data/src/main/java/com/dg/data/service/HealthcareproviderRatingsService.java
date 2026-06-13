/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderRatings;

/**
 * This is a HealthcareproviderRatingsService service interface which includes
 * the most fundamental service operations for HealthcareproviderRatingsService
 * object It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderRatingsService
		extends GenericService<HealthcareproviderRatings> {
	/**
	 * get list of health care provider ratings by health care provider id
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderRatings> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
