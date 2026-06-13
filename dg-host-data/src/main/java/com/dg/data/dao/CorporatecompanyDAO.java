/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;

import com.dg.data.model.db.Corporatecompany;

/**
 * This is a Corporatecompany DAO interface which includes the most fundamental
 * DAO operations (findByPatientId, etc) for any Corporatecompany object It also
 * extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface CorporatecompanyDAO extends GenericDAO<Corporatecompany> {

	/**
	 * Find the Corporatecompany object based on patient id
	 * @param id the unique id of patient
	 * @return Corporatecompany model
	 */
	public Corporatecompany findByPatientId(BigInteger id);

	/**
	 * Find the Corporatecompany based on whitelable url
	 * @param url
	 * @return corporate companny model
	 */
	public Corporatecompany findByWhitelabelUrl(String url);
}
