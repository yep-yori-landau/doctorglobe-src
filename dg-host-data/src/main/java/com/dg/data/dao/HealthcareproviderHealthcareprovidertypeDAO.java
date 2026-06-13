/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;

/**
 * This is a HealthcareproviderHealthcareprovidertype DAO interface which
 * includes the most fundamental DAO operations (findByHealthcareprovider, etc)
 * for any HealthcareproviderHealthcareprovidertype object It also extends the
 * generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderHealthcareprovidertypeDAO
		extends GenericDAO<HealthcareproviderHealthcareprovidertype> {

	/**
	 * Find the list of HealthcareproviderHealthcareprovidertype object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderHealthcareprovidertype object or
	 * null if it cannot be found
	 */
	public List<HealthcareproviderHealthcareprovidertype> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
