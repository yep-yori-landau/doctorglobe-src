
package com.dg.data.service.impl;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.ApiUserDAO;
import com.dg.data.model.db.ApiUser;
import com.dg.data.service.ApiUserService;

/**
 * @author DoctorGlobe ApiUserService CountryService
 */

@Service("apiUserService")
public class ApiUserServiceImpl extends GenericServiceImpl<ApiUser>
		implements ApiUserService {
	
	private ApiUserDAO apiUserDao;

	@Autowired
	public ApiUserServiceImpl(ApiUserDAO genericDAO) {
		super(genericDAO);
		this.apiUserDao = (ApiUserDAO) genericDAO;
	}

	/**
	 * return encrypted password
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	@Override
	public String getSHA1(String passwordString) throws Exception {
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		sha1.reset();
		sha1.update(passwordString.getBytes());
		byte[] digest = sha1.digest();
		StringBuffer password = new StringBuffer();
		for (byte b : digest) {
			password.append(String.format("%02x", b));
		}
		return password.toString();
	}
	
	/**
	 * find By UserName
	 * @param userName
	 * @return
	 */
	@Override
	public ApiUser findByUserName(String userName){
		return this.apiUserDao.findByUserName(userName);
	}
	
	/**
	 * find By UserName
	 * @param userName
	 * @return
	 */
	@Override
	public ApiUser findByUserName(String userName,Integer active){
		return this.apiUserDao.findByUserName(userName,active);
	}
}
