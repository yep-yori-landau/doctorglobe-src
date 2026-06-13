/**
 * 
 */
package com.dg.data.service;

import com.dg.data.model.db.User;

/**
 * This is a UserService service interface which includes the most fundamental
 * service operations for UserService object It also extends the generic service
 * CRUD methods
 *
 * @author DoctorGlobe
 */
public interface UserService extends GenericService<User> {
	/**
	 * return encrypted password
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	public String getSHA1(String passwordString) throws Exception;

}
