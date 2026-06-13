/**
 * Authentication Service
 */
package com.dg.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.user.dao.UserDaoImpl;
import com.dg.user.model.UserModel;

/**
 * @author kkowlgi
 * 
 */
@Service
public class Authenticate {


  private static final Logger logger = LoggerFactory.getLogger(Authenticate.class);

  @Autowired
  private UserDaoImpl userDao;

  /**
   * Authenticate user against ldap
   * 
   * @param userName
   * @param password
   * 
   * @return
   */
  public boolean login(String userName, String password) {

    UserModel user = new UserModel(userName, password);
    logger.info("Authenticating user {}", user.toString());
    boolean authenticated = false;
    try {
      authenticated = userDao.login(user);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    return authenticated;
  }

  /**
   * @return the userDao
   */
  public UserDaoImpl getUserDao() {
    return userDao;
  }

  /**
   * @param userDao the userDao to set
   */
  public void setUserDao(UserDaoImpl userDao) {
    this.userDao = userDao;
  }

}
