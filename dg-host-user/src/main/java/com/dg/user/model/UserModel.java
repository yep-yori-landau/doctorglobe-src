/**
 * UserModel
 */
package com.dg.user.model;

/**
 * @author kkowlgi
 * 
 */
public class UserModel {

  private String userName;

  private String password;

  private String firstName;

  private String lastName;

  private String emailAddress;

  /**
   * @param userName
   * @param password
   */
  public UserModel(String userName, String password) {
    super();
    this.userName = userName;
    this.password = password;
  }

  /**
   * @param userName
   * @param password
   * @param firstName
   * @param lastName
   * @param emailAddress
   */
  public UserModel(String userName, String password, String firstName, String lastName,
      String emailAddress) {
    super();
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the emailAddress
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * @param emailAddress the emailAddress to set
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UserModel [userName=" + userName + ", emailAddress=" + emailAddress + "]";
  }

}
