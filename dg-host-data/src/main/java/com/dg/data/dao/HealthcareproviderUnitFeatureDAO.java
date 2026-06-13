/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderUnitFeature;

/**
 * This is a HealthcareproviderUnitFeatureDAO DAO interface which includes the
 * most fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderUnitFeatureDAO object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderUnitFeatureDAO
		extends GenericDAO<HealthcareproviderUnitFeature> {

	/**
	 * Find the list of HealthcareproviderUnitFeature object based on
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderUnitFeature object or null if it
	 * cannot be found
	 */
	public List<HealthcareproviderUnitFeature> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
