/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderInsurance DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderInsurance {

	/**
	 * The id of HealthcareproviderInsurance.java
	 */
	private BigInteger id;

	/**
	 * The insurance of HealthcareproviderInsurance.java
	 */
	@NotNull
	private BigInteger insurance;

	/**
	 * The healthcareprovider of HealthcareproviderInsurance.java
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderInsurance.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderInsurance.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the insurance of HealthcareproviderInsurance.java
	 * @return BigInteger
	 */
	public BigInteger getInsurance() {
		return insurance;
	}

	/**
	 * Set the insurance of HealthcareproviderInsurance.java
	 * @param insurance the insurance to set
	 */
	public void setInsurance(BigInteger insurance) {
		this.insurance = insurance;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderInsurance.java
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderInsurance.java
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
