/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderAccreditation;

/**
 * This is a HealthcareproviderAccreditation DAO interface which includes the
 * most fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderAccreditation object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderAccreditationDAO
		extends GenericDAO<HealthcareproviderAccreditation> {

	/**
	 * Find the list of HealthcareproviderAccreditation object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderAccreditation object or null if it
	 * cannot be found
	 */
	public List<HealthcareproviderAccreditation> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
