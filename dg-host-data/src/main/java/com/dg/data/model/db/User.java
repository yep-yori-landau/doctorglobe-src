/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * User DB Model
 * @author DoctorGlobe
 *
 */
public class User {

	/**
	 * The id of User
	 */
	private BigInteger id;

	/**
	 * The first_name of User
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of User
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The mobile of User
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String mobile;

	/**
	 * The email of User
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The password of User
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The active of User
	 */
	@NotNull
	private Boolean active;

	/**
	 * The role of User
	 */
	@NotNull
	private BigInteger role;

	/**
	 * Get the id of User
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of User
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the first_name of User
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of User
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of User
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of User
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the mobile of User
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Set the mobile of User
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Get the email of User
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of User
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the password of User
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of User
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the active of User
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of User
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Get the role of User
	 * @return BigInteger
	 */
	public BigInteger getRole() {
		return role;
	}

	/**
	 * Set the role of User
	 * @param role the role to set
	 */
	public void setRole(BigInteger role) {
		this.role = role;
	}

}
