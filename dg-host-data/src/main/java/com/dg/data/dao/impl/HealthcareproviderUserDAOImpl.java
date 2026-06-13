/**
 * 
 */
package com.dg.data.dao.impl;

import java.util.List;
import com.dg.data.dao.HealthcareproviderUserDAO;
import com.dg.data.model.db.HealthcareproviderUser;
import com.dg.data.model.domain.HealthcareproviderUserDetailModel;
import com.dg.data.model.domain.mapper.HealthcareproviderUserDetailMapper;

/**
 * This class represent Implementation of HealthcareproviderUserDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderUserDAOImpl
		extends GenericDAOImpl<HealthcareproviderUser>
		implements HealthcareproviderUserDAO {

	@Override
	public List<HealthcareproviderUserDetailModel> authenticate(String email,
			Integer active) {
		List<HealthcareproviderUserDetailModel> healthcareproviderUserDetailModelList = null;

		if (email != null) {
			try {
				String query = "SELECT user.id as id,user.first_name as first_name,user.email as email ,user.password,user.last_name as last_name,healthcareprovider_user.healthcareprovider as healthcareprovider FROM user user "
						+ "join healthcareprovider_user on healthcareprovider_user.user = user.id  WHERE user.email = ? and user.active = ?";
				healthcareproviderUserDetailModelList = this.getJdbcTemplate()
						.query(query, new Object[] { email, active },
								new HealthcareproviderUserDetailMapper());
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return healthcareproviderUserDetailModelList;
	}
}
