/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Amenity DB Model
 * @author DoctorGlobe
 *
 */
public class Amenity {

	/**
	 * The id of Amenity
	 */
	private BigInteger id;

	/**
	 * The name of Amenity
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The is_display of Amenity
	 */
	@NotNull
	private Integer is_display;

	/**
	 * Get the id of Amenity
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Amenity
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Amenity
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Amenity
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the is_display of Amenity
	 * @return Integer
	 */
	public Integer getIsDisplay() {
		return is_display;
	}

	/**
	 * Set the is_display of Amenity
	 * @param is_display the is_display to set
	 */
	public void setIsDisplay(Integer is_display) {
		this.is_display = is_display;
	}

}
