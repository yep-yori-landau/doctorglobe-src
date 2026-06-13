/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderUnitFeature DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderUnitFeature {

	/**
	 * The id of HealthcareproviderUnitFeature
	 */
	private BigInteger id;

	/**
	 * The description of HealthcareproviderUnitFeature
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String description;

	/**
	 * The feature of HealthcareproviderUnitFeature
	 */
	@NotNull
	private BigInteger feature;

	/**
	 * The healthcareproviderunit of HealthcareproviderUnitFeature
	 */
	@NotNull
	private BigInteger healthcareproviderunit;

	/**
	 * The healthcareprovider of HealthcareproviderUnitFeature
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderUnitFeature
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderUnitFeature
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the description of HealthcareproviderUnitFeature
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of HealthcareproviderUnitFeature
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the feature of HealthcareproviderUnitFeature
	 * @return BigInteger
	 */
	public BigInteger getFeature() {
		return feature;
	}

	/**
	 * Set the feature of HealthcareproviderUnitFeature
	 * @param feature the feature to set
	 */
	public void setFeature(BigInteger feature) {
		this.feature = feature;
	}

	/**
	 * Get the healthcareproviderunit of HealthcareproviderUnitFeature
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderunit() {
		return healthcareproviderunit;
	}

	/**
	 * Set the healthcareproviderunit of HealthcareproviderUnitFeature
	 * @param healthcareproviderunit the healthcareproviderunit to set
	 */
	public void setHealthcareproviderunit(BigInteger healthcareproviderunit) {
		this.healthcareproviderunit = healthcareproviderunit;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderUnitFeature
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderUnitFeature
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
