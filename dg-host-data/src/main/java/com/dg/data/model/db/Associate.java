/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Associate DB Model
 * @author DoctorGlobe
 *
 */
public class Associate {

	/**
	 * The id of Associate
	 */
	private BigInteger id;

	/**
	 * The title of Associate
	 */
	@NotNull
	private String title;

	/**
	 * The first_name of Associate
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of Associate
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The email of Associate
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The password of Associate
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The active of Associate
	 */
	@NotNull
	private Boolean active;

	/**
	 * The association of Associate
	 */
	@NotNull
	private BigInteger association;

	/**
	 * The phone_1 of Associate
	 */
	private String phone_1;

	/**
	 * The mobilephone_1 of Associate
	 */
	private String mobilephone_1;

	/**
	 * Get the id of Associate
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Associate
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the title of Associate
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of Associate
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the first_name of Associate
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of Associate
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of Associate
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of Associate
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the email of Associate
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of Associate
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the password of Associate
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of Associate
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the active of Associate
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of Associate
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Get the association of Associate
	 * @return BigInteger
	 */
	public BigInteger getAssociation() {
		return association;
	}

	/**
	 * Set the association of Associate
	 * @param association the association to set
	 */
	public void setAssociation(BigInteger association) {
		this.association = association;
	}

	/**
	 * Get the phone_1 of Associate
	 * @return String
	 */
	public String getPhone_1() {
		return phone_1;
	}

	/**
	 * Set the phone_1 of Associate
	 * @param phone_1 the phone_1 to set
	 */
	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	/**
	 * Get the mobilephone_1 of Associate
	 * @return String
	 */
	public String getMobilephone_1() {
		return mobilephone_1;
	}

	/**
	 * Set the mobilephone_1 of Associate
	 * @param mobilephone_1 the mobilephone_1 to set
	 */
	public void setMobilephone_1(String mobilephone_1) {
		this.mobilephone_1 = mobilephone_1;
	}

}
