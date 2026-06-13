/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderRatings;

/**
 * This is a HealthcareproviderRatings DAO interface which includes the most
 * fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderRatings object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */
public interface HealthcareproviderRatingsDAO
		extends GenericDAO<HealthcareproviderRatings> {

	/**
	 * Find the list of HealthcareproviderRatings object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderRatings object or null if it cannot
	 * be found
	 */
	public List<HealthcareproviderRatings> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
