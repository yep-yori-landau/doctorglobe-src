/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderCuisine;

/**
 * This is a HealthcareproviderCuisine DAO interface which includes the most
 * fundamental DAO operations (findByHealthacareprovider, etc) for any
 * HealthcareproviderCuisine object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderCuisineDAO
		extends GenericDAO<HealthcareproviderCuisine> {

	/**
	 * Find the list of HealthcareproviderCuisine object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderCuisine object or null if it cannot
	 * be found
	 */
	public List<HealthcareproviderCuisine> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
