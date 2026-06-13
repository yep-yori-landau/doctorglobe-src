/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderAmenity;

/**
 * This is a HealthcareproviderAmenity DAO interface which includes the most
 * fundamental DAO operations (findByHealthacareprovider, etc) for any
 * HealthcareproviderAmenity object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderAmenityDAO
		extends GenericDAO<HealthcareproviderAmenity> {

	/**
	 * Find the list of HealthcareproviderAmenity object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderAmenity object or null if it cannot
	 * be found
	 */
	public List<HealthcareproviderAmenity> findByHealthacareprovider(
			BigInteger healthcareprovider);
}
