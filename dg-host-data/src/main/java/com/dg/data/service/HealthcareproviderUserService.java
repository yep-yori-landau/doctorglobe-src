/**
 * 
 */
package com.dg.data.service;

import java.util.List;
import com.dg.data.model.db.HealthcareproviderUser;
import com.dg.data.model.domain.HealthcareproviderUserDetailModel;

/**
 * This is a HealthcareproviderUserService service interface which includes the
 * most fundamental service operations for HealthcareproviderUserService object
 * It also extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface HealthcareproviderUserService
		extends GenericService<HealthcareproviderUser> {
	/**
	 * authenticate
	 * @param email
	 * @param active
	 * @return
	 */
	public List<HealthcareproviderUserDetailModel> authenticate(String email,
			Integer active);
}
