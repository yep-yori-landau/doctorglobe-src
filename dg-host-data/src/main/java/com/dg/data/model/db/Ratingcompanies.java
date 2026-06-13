/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Ratingcompanies DB Model
 * @author DoctorGlobe
 *
 */
public class Ratingcompanies {

	/**
	 * The id of Ratingcompanies
	 */
	private BigInteger id;

	/**
	 * The name of Ratingcompanies
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The max_score of Ratingcompanies
	 */
	@NotNull
	private Integer max_score;

	/**
	 * Get the id of Ratingcompanies
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Ratingcompanies
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Ratingcompanies
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Ratingcompanies
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the max_score of Ratingcompanies
	 * @return Integer
	 */
	public Integer getMaxScore() {
		return max_score;
	}

	/**
	 * Set the max_score of Ratingcompanies
	 * @param max_score the max_score to set
	 */
	public void setMaxScore(Integer max_score) {
		this.max_score = max_score;
	}

}
