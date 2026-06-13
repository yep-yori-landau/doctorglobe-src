
package com.dg.data.service.impl;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.data.dao.UserDAO;
import com.dg.data.model.db.User;
import com.dg.data.service.UserService;

/**
 * @author DoctorGlobe UserService CountryService
 */

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User>
		implements UserService {

	@Autowired
	public UserServiceImpl(UserDAO genericDAO) {
		super(genericDAO);
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
}
