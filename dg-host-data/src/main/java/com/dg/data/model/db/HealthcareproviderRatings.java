/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderRatings DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderRatings {

	/**
	 * The id of HealthcareproviderRatings
	 */
	private BigInteger id;

	/**
	 * The score of HealthcareproviderRatings
	 */
	@NotNull
	private Integer score;

	/**
	 * The ratingcompany of HealthcareproviderRatings
	 */
	@NotNull
	private BigInteger ratingcompany;

	/**
	 * The healthcareprovider of HealthcareproviderRatings
	 */
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderRatings
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderRatings
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the score of HealthcareproviderRatings
	 * @return Integer
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Set the score of HealthcareproviderRatings
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * Get the ratingcompany of HealthcareproviderRatings
	 * @return BigInteger
	 */
	public BigInteger getRatingcompany() {
		return ratingcompany;
	}

	/**
	 * Set the ratingcompany of HealthcareproviderRatings
	 * @param ratingcompany the ratingcompany to set
	 */
	public void setRatingcompany(BigInteger ratingcompany) {
		this.ratingcompany = ratingcompany;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderRatings
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderRatings
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
