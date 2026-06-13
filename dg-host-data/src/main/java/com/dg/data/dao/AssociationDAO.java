/**
 * 
 */
package com.dg.data.dao;

import com.dg.data.model.db.Association;

/**
 * This is a Association DAO interface which includes the most fundamental DAO
 * operations (findByWhitelableUrl, etc) for any Association object It also
 * extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface AssociationDAO extends GenericDAO<Association> {

	/**
	 * Gets the association detail based on whitelable url
	 * @param url
	 * @return Association Model
	 */
	public Association findByWhitelableUrl(String url);
}
