/**
 * 
 */
package com.dg.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.ApiUserDAO;
import com.dg.data.model.db.ApiUser;
import com.dg.data.model.db.mapper.ApiUserMapper;

/**
 * @author DoctorGlobe
 * 
 */

public class ApiUserDAOImpl extends GenericDAOImpl<ApiUser>implements ApiUserDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ApiUserDAOImpl.class);

	@Override
	public ApiUser findByUserName(String userName) {		
		ApiUser model = new ApiUser();
		if (userName != null) {
			try {
				String query = "SELECT *FROM api_user WHERE user_name = ?";
				model = this.getJdbcTemplate().queryForObject(query,new Object[] { userName }, new ApiUserMapper());
			}catch (Exception ex) {
				logger.info("Exception found :" + ex.getMessage());
			}
		}		
		return model;
	}

	@Override
	public ApiUser findByUserName(String userName, Integer active) {
		ApiUser model = new ApiUser();
		if (userName != null && active != null) {
			try {
				String query = "SELECT *FROM api_user WHERE user_name = ? and active = ?";
				model = this.getJdbcTemplate().queryForObject(query,new Object[] { userName, active }, new ApiUserMapper());
			}catch (Exception ex) {
				logger.info("Exception found :" + ex.getMessage());
			}
		}		
		return model;
	}
	
	
}
