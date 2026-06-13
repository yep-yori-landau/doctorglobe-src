/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderCuisine;

/**
 * This is a HealthcareproviderCuisineService service interface which includes
 * the most fundamental service operations for HealthcareproviderCuisineService
 * object It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderCuisineService
		extends GenericService<HealthcareproviderCuisine> {

	/**
	 * get list of health care provider Cuisine by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderCuisine> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
