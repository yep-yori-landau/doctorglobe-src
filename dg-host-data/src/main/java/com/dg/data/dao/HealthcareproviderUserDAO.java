/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.HealthcareproviderUser;
import com.dg.data.model.domain.HealthcareproviderUserDetailModel;

/**
 * This is a HealthcareproviderUserDAO DAO interface which includes the most
 * fundamental DAO operations (authenticate, etc) for any
 * HealthcareproviderUserDAO object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface HealthcareproviderUserDAO
		extends GenericDAO<HealthcareproviderUser> {

	/**
	 * Find the list of HealthcareproviderUserDetailModel object based on email
	 * address and active status
	 * @param email the unique email address of hospital user
	 * @param active 1
	 * @return the list of HealthcareproviderUserDetailModel object or null if
	 * it cannot be found
	 */
	public List<HealthcareproviderUserDetailModel> authenticate(String email,
			Integer active);
}
