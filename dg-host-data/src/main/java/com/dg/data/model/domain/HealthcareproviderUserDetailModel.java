package com.dg.data.model.domain;

import java.math.BigInteger;

/**
 * HealthcareproviderUserDetailModel Domain Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderUserDetailModel {

	/**
	 * The id of HealthcareproviderUserDetailModel
	 */
	private BigInteger id;

	/**
	 * The first_name of HealthcareproviderUserDetailModel
	 */
	private String first_name;

	/**
	 * The last_name of HealthcareproviderUserDetailModel
	 */
	private String last_name;

	/**
	 * The email of HealthcareproviderUserDetailModel
	 */
	private String email;

	/**
	 * The password of HealthcareproviderUserDetailModel
	 */
	private String password;

	/**
	 * The healthcareprovider of HealthcareproviderUserDetailModel
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderUserDetailModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderUserDetailModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the first_name of HealthcareproviderUserDetailModel
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of HealthcareproviderUserDetailModel
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of HealthcareproviderUserDetailModel
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of HealthcareproviderUserDetailModel
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the email of HealthcareproviderUserDetailModel
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of HealthcareproviderUserDetailModel
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the password of HealthcareproviderUserDetailModel
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of HealthcareproviderUserDetailModel
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderUserDetailModel
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderUserDetailModel
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}