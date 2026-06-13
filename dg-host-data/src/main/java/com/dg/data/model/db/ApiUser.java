/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * ApiUser DB Model
 * @author DoctorGlobe
 *
 */
public class ApiUser {

	/**
	 * The id of ApiUser
	 */
	private BigInteger id;

	/**
	 * The first_name of ApiUser
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of ApiUser
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The email of ApiUser
	 */	
	@Size(min = 1, max = 255)
	@Email
	private String email;
	
	/**
	 * The email of ApiUser
	 */
	@NotNull
	@Size(min = 1, max = 255)	
	private String user_name;

	/**
	 * The password of ApiUser
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The active of ApiUser
	 */
	@NotNull
	private Boolean active;

	/**
	 * Get the id of ApiUser
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of ApiUser
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the first_name of ApiUser
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of ApiUser
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of ApiUser
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of ApiUser
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	/**
	 * Get the email of ApiUser
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of ApiUser
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Get the user_name of ApiUser
	 * @return String
	 */
	public String getUserName() {
		return user_name;
	}

	/**
	 * Set the user_name of ApiUser
	 * @param user_name the first_name to set
	 */
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * Get the password of ApiUser
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of ApiUser
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the active of ApiUser
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of ApiUser
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}
