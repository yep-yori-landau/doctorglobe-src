/**
 * UserDao Implementation
 */
package com.dg.user.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.*;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import javax.naming.directory.*;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

import com.dg.user.model.UserModel;
import com.dg.user.service.Authenticate;

/**
 * @author kkowlgi
 * 
 */
public class UserDaoImpl implements UserDao {

  // Attribute names
  private static final String USER_ACCOUNT_CONTROL_ATTR_NAME = "userAccountControl";
  private static final String PASSWORD_ATTR_NAME = "unicodepwd";

  // User control params
  private static final int FLAG_TO_DISABLE_USER = 0x2;

  private LdapTemplate ldapTemplate;

  private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


  /**
   * Validate user
   * 
   * @param user
   * 
   * @return
   */
  public boolean login(UserModel user) {
    AndFilter filter = new AndFilter();
    ldapTemplate.setIgnorePartialResultException(true);
    filter.and(new EqualsFilter("objectclass", "person")).and(
        new EqualsFilter("cn", user.getUserName()));
    return ldapTemplate
        .authenticate("", filter.toString(), encryptLdapPassword(user.getPassword()));
  }

  /**
   * Enable user
   * 
   * @param userName
   * 
   * @return
   */
  public void enableUser(String userName) {
    DirContextOperations userContextOperations = ldapTemplate.lookupContext(getDnFrom(userName));
    String userAccountControlStr =
        userContextOperations.getStringAttribute(USER_ACCOUNT_CONTROL_ATTR_NAME);
    int newUserAccountControl = Integer.parseInt(userAccountControlStr) & ~FLAG_TO_DISABLE_USER;
    userContextOperations.setAttributeValue(USER_ACCOUNT_CONTROL_ATTR_NAME, ""
        + newUserAccountControl);
    ldapTemplate.modifyAttributes(userContextOperations);
  }

  /**
   * Disable user
   * 
   * @param userName
   * 
   * @return
   */
  public void disableUser(String userName) {
    DirContextOperations userContextOperations = ldapTemplate.lookupContext(getDnFrom(userName));
    String userAccountControlStr =
        userContextOperations.getStringAttribute(USER_ACCOUNT_CONTROL_ATTR_NAME);
    int newUserAccountControl = Integer.parseInt(userAccountControlStr) | FLAG_TO_DISABLE_USER;
    userContextOperations.setAttributeValue(USER_ACCOUNT_CONTROL_ATTR_NAME, ""
        + newUserAccountControl);
    ldapTemplate.modifyAttributes(userContextOperations);
  }

  /**
   * Change user password
   * 
   * @param userName
   * 
   * @param password
   * 
   * @return
   */
  public void changePassword(String userName, String password) {
    try {
      ModificationItem item =
          new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute(PASSWORD_ATTR_NAME,
              encryptLdapPassword(password)));
      ldapTemplate.modifyAttributes(getDnFrom(userName), new ModificationItem[] {item});
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  /**
   * Create user
   * 
   * @param user
   * 
   * @return
   */
  public void createUser(UserModel user) {
    try {
      Attributes userAttributes = new BasicAttributes();
      userAttributes.put("objectclass", "people");
      userAttributes.put("userPrincipalName", user.getEmailAddress());
      userAttributes.put("sAMAccountName", user.getUserName());
      userAttributes.put("givenName", user.getFirstName());
      userAttributes.put("sn", user.getLastName());
      userAttributes.put("displayName", user.getLastName());
      int userAccounControl = 1;//getUserAccountControl(user);
      userAttributes.put("userAccountControl", "" + userAccounControl);
      userAttributes.put("unicodepwd", encryptLdapPassword(user.getPassword()));
      ldapTemplate.bind(getDnFrom(user.getUserName()), null, userAttributes);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  /**
   * Encrypt password
   * 
   * @param password
   * 
   * @return
   */
  private String encryptLdapPassword(String password) {
    String sEncrypted = password;
    if ((password != null) && (password.length() > 0)) {
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes("UTF-8"));
        sEncrypted = "{MD5}" + new String(Base64.encodeBase64(md.digest()));
      } catch (Exception e) {
        sEncrypted = null;
        logger.error(e.getMessage());
      }

    }
    return sEncrypted;
  }

  /**
   * Get distinguished name
   * 
   * @param userName
   * 
   * @return
   */
  @SuppressWarnings("deprecation")
  private DistinguishedName getDnFrom(String userName) {
    return new DistinguishedName("CN=" + userName);
  }

  public LdapTemplate getLdapTemplate() {
    return ldapTemplate;
  }

  public void setLdapTemplate(LdapTemplate ldapTemplate) {
    this.ldapTemplate = ldapTemplate;
  }

}
