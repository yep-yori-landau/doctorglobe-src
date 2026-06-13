
package com.dg.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.GenericDAO;
import com.dg.data.dao.HealthcareproviderUserDAO;
import com.dg.data.model.db.HealthcareproviderUser;
import com.dg.data.model.domain.HealthcareproviderUserDetailModel;
import com.dg.data.service.HealthcareproviderUserService;

/**
 * @author DoctorGlobe HealthcareproviderUserService CountryService
 */

@Service("healthcareproviderUserService")
public class HealthcareproviderUserServiceImpl
		extends GenericServiceImpl<HealthcareproviderUser>
		implements HealthcareproviderUserService {

	private HealthcareproviderUserDAO healthcareproviderUserDAO;

	@Autowired
	public HealthcareproviderUserServiceImpl(
			HealthcareproviderUserDAO genericDAO) {
		super(genericDAO);
		this.healthcareproviderUserDAO = (HealthcareproviderUserDAO) genericDAO;

	}

	/**
	 * authenticate
	 * @param email
	 * @param active
	 * @return
	 */
	@Override
	public List<HealthcareproviderUserDetailModel> authenticate(String email,
			Integer active) {
		return this.healthcareproviderUserDAO.authenticate(email, active);
	}
}
