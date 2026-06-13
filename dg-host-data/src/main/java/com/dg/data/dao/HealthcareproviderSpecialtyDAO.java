/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderSpecialty;

/**
 * This is a HealthcareproviderSpecialty DAO interface which includes the most
 * fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderSpecialty object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderSpecialtyDAO
		extends GenericDAO<HealthcareproviderSpecialty> {

	/**
	 * Find the list of HealthcareproviderSpecialty object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderSpecialty object or null if it
	 * cannot be found
	 */
	public List<HealthcareproviderSpecialty> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
