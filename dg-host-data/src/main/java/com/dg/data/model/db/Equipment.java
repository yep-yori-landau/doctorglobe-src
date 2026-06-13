/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Equipment DB Model
 * @author DoctorGlobe
 *
 */
public class Equipment {

	/**
	 * The id of Equipment
	 */
	private BigInteger id;

	/**
	 * The name of Equipment
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The rating of Equipment
	 */
	@NotNull
	private Integer rating;

	/**
	 * The is_display of Equipment
	 */
	@NotNull
	private Integer is_display;

	/**
	 * Get the id of Equipment
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Equipment
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Equipment
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Equipment
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the rating of Equipment
	 * @return Integer
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Set the rating of Equipment
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * Get the is_display of Equipment
	 * @return Integer
	 */
	public Integer getIsDisplay() {
		return is_display;
	}

	/**
	 * Set the is_display of Equipment
	 * @param is_display the is_display to set
	 */
	public void setIsDisplay(Integer is_display) {
		this.is_display = is_display;
	}

}
