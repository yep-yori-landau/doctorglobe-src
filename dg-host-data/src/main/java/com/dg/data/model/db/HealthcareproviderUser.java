/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderUser DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderUser {

	/**
	 * The id of HealthcareproviderUser
	 */
	private BigInteger id;

	/**
	 * The user of HealthcareproviderUser
	 */
	@NotNull
	private BigInteger user;

	/**
	 * The healthcareprovider of HealthcareproviderUser
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderUser
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderUser
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the user of HealthcareproviderUser
	 * @return BigInteger
	 */
	public BigInteger getUser() {
		return user;
	}

	/**
	 * Set the user of HealthcareproviderUser
	 * @param user the user to set
	 */
	public void setUser(BigInteger user) {
		this.user = user;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderUser
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderUser
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
