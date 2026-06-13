/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderLanguage DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderLanguage {

	/**
	 * The id of HealthcareproviderLanguage
	 */
	private BigInteger id;

	/**
	 * The language of HealthcareproviderLanguage
	 */
	@NotNull
	@Size(min = 2, max = 2)
	private String language;

	/**
	 * The healthcareprovider of HealthcareproviderLanguage
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderLanguage
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderLanguage
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the language of HealthcareproviderLanguage
	 * @return String
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Set the language of HealthcareproviderLanguage
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderLanguage
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderLanguage
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
