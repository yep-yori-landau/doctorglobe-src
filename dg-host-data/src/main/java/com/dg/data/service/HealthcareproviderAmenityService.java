/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.HealthcareproviderAmenity;

/**
 * This is a HealthcareproviderAmenityService service interface which includes
 * the most fundamental service operations for HealthcareproviderAmenityService
 * object It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderAmenityService
		extends GenericService<HealthcareproviderAmenity> {
	/**
	 * get list of health care provider Amenity by healthcareprovider ID
	 * @param healthcareprovider
	 * @return
	 */
	public List<HealthcareproviderAmenity> findByHealthcareprovider(
			BigInteger healthcareprovider);

}
