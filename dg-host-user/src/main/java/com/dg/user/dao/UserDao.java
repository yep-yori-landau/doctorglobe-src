/**
 * UserDao
 */
package com.dg.user.dao;

import com.dg.user.model.UserModel;

/**
 * @author kkowlgi
 * 
 */
public interface UserDao {

  /**
   * Validate user
   * 
   * @param user
   * 
   * @return
   */
  public boolean login(UserModel user);

  /**
   * Enable user
   * 
   * @param userName
   * 
   * @return
   */
  public void enableUser(String userName);

  /**
   * Disable user
   * 
   * @param userName
   * 
   * @return
   */
  public void disableUser(String userName);

  /**
   * Change user password
   * 
   * @param userName
   * 
   * @param password
   * 
   * @return
   */
  public void changePassword(String userName, String password);

  /**
   * Create user
   * 
   * @param user
   * 
   * @return
   */
  public void createUser(UserModel user);

}
