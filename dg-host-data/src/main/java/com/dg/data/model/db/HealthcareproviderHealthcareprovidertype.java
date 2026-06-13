/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderHealthcareprovidertype DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderHealthcareprovidertype {

	/**
	 * The id of HealthcareproviderHealthcareprovidertype.java
	 */
	private BigInteger id;

	/**
	 * The healthcareprovidertype of
	 * HealthcareproviderHealthcareprovidertype.java
	 */
	@NotNull
	private BigInteger healthcareprovidertype;

	/**
	 * The healthcareprovider of HealthcareproviderHealthcareprovidertype.java
	 */
	@NotNull
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderHealthcareprovidertype.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderHealthcareprovidertype.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the healthcareprovidertype of
	 * HealthcareproviderHealthcareprovidertype.java
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovidertype() {
		return healthcareprovidertype;
	}

	/**
	 * Set the healthcareprovidertype of
	 * HealthcareproviderHealthcareprovidertype.java
	 * @param healthcareprovidertype the healthcareprovidertype to set
	 */
	public void setHealthcareprovidertype(BigInteger healthcareprovidertype) {
		this.healthcareprovidertype = healthcareprovidertype;
	}

	/**
	 * Get the healthcareprovider of
	 * HealthcareproviderHealthcareprovidertype.java
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of
	 * HealthcareproviderHealthcareprovidertype.java
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
