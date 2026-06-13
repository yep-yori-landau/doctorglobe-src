/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderAmenity DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderCuisine {

	/**
	 * The id of HealthcareproviderCuisine
	 */
	private BigInteger id;

	/**
	 * The cuisine of HealthcareproviderCuisine
	 */
	@NotNull
	private BigInteger cuisine;

	/**
	 * The healthcareprovider of HealthcareproviderCuisine
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderCuisine
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderCuisine
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the cuisine of HealthcareproviderCuisine
	 * @return BigInteger
	 */
	public BigInteger getCuisine() {
		return cuisine;
	}

	/**
	 * Set the cuisine of HealthcareproviderCuisine
	 * @param cuisine the cuisine to set
	 */
	public void setCuisine(BigInteger cuisine) {
		this.cuisine = cuisine;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderCuisine
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderCuisine
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
