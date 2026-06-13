/**
 * 
 */
package com.dg.data.service;

import com.dg.data.model.db.ApiUser;

/**
 * This is a ApiUserService service interface which includes the most fundamental
 * service operations for ApiUserService object It also extends the generic service
 * CRUD methods
 *
 * @author DoctorGlobe
 */
public interface ApiUserService extends GenericService<ApiUser> {
	/**
	 * return encrypted password
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	public String getSHA1(String passwordString) throws Exception;
	
	/**
	 * find By UserName
	 * @param userName
	 * @return ApiUser Model
	 */
	public ApiUser findByUserName(String userName, Integer active);
	
	/**
	 * find By userName
	 * @param userName
	 * @return ApiUser Model
	 */
	public ApiUser findByUserName(String userName);

}
