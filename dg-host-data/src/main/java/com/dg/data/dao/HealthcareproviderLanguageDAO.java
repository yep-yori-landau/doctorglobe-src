/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderLanguage;

/**
 * This is a HealthcareproviderLanguage DAO interface which includes the most
 * fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderLanguage object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderLanguageDAO
		extends GenericDAO<HealthcareproviderLanguage> {

	/**
	 * Find the list of HealthcareproviderLanguage object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderLanguage object or null if it
	 * cannot be found
	 */
	public List<HealthcareproviderLanguage> findByHealthcareprovider(
			BigInteger healthcareprovider);
}
