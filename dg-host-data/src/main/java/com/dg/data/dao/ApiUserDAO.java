/**
 * 
 */
package com.dg.data.dao;

import com.dg.data.model.db.ApiUser;

/**
 * This is a ApiUser DAO interface which includes the most fundamental DAO
 * operations for ApiUser object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */
public interface ApiUserDAO extends GenericDAO<ApiUser> {

	ApiUser findByUserName(String userName);

	ApiUser findByUserName(String userName, Integer active);
}