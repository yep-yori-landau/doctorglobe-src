/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderInsurance;

/**
 * This is a HealthcareproviderInsurance DAO interface which includes the most
 * fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderInsurance object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderInsuranceDAO
		extends GenericDAO<HealthcareproviderInsurance> {

	/**
	 * Find the list of HealthcareproviderInsurance object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderInsurance object or null if it
	 * cannot be found
	 */
	public List<HealthcareproviderInsurance> findByHealthcareprovider(
			BigInteger healthcareprovider);

	/**
	 * Delete the HealthcareproviderInsurance object records based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return boolean true or false if it cannot be deleted
	 */
	public Boolean deleteByHealthcareprovider(BigInteger healthcareprovider);
}
