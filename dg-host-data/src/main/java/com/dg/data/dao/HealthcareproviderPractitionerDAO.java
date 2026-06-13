package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.HealthcareproviderPractitioner;

/**
 * This is a HealthcareproviderPractitioner DAO interface which includes the
 * most fundamental DAO operations (findByHealthcareprovider, etc) for any
 * HealthcareproviderPractitioner object It also extends the generic DAO CRUD
 * methods
 * 
 * @author DoctorGlobe
 */
public interface HealthcareproviderPractitionerDAO
		extends GenericDAO<HealthcareproviderPractitioner> {

	/**
	 * Find the list of HealthcareproviderPractitioner object based on
	 * healthcareprovider id
	 * @param healthcareprovider the unique id of healthcareprovider
	 * @return the list of HealthcareproviderPractitioner object or null if it
	 * cannot be found
	 */
	List<HealthcareproviderPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider);

}