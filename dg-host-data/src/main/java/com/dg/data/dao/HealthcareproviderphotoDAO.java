/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.Healthcareproviderphoto;

/**
 * This is a Healthcareproviderphoto DAO interface which includes the most
 * fundamental DAO operations (findByHealthcareprovider, etc) for any
 * Healthcareproviderphoto object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderphotoDAO
		extends GenericDAO<Healthcareproviderphoto> {

	/**
	 * Find the list of Healthcareproviderphoto object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of Healthcareproviderphoto object or null if it cannot
	 * be found
	 */
	public List<Healthcareproviderphoto> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
