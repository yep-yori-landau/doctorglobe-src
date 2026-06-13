/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author DoctorGlobe
 * 
 */
public class AssociateModel {

	/**
	 * The id of AssociateModel
	 */
	private BigInteger id;

	/**
	 * The title of AssociateModel
	 */
	@NotNull
	private String title;

	/**
	 * The first_name of AssociateModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of AssociateModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The email of AssociateModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The password of AssociateModel
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The active of AssociateModel
	 */
	@NotNull
	private Boolean active;

	/**
	 * The association of AssociateModel
	 */
	@NotNull
	private BigInteger association;

	/**
	 * The phone_1 of AssociateModel
	 */
	private String phone_1;

	/**
	 * The mobilephone_1 of AssociateModel
	 */
	private String mobilephone_1;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the first_name
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the association
	 */
	public BigInteger getAssociation() {
		return association;
	}

	/**
	 * @param association the association to set
	 */
	public void setAssociation(BigInteger association) {
		this.association = association;
	}

	/**
	 * @return the phone_1
	 */
	public String getPhone_1() {
		return phone_1;
	}

	/**
	 * @param phone_1 the phone_1 to set
	 */
	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	/**
	 * @return the mobilephone_1
	 */
	public String getMobilephone_1() {
		return mobilephone_1;
	}

	/**
	 * @param mobilephone_1 the mobilephone_1 to set
	 */
	public void setMobilephone_1(String mobilephone_1) {
		this.mobilephone_1 = mobilephone_1;
	}
}
