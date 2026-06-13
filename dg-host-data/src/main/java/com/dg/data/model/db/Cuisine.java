/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Cuisine DB Model
 * @author DoctorGlobe
 *
 */
public class Cuisine {

	/**
	 * The id of Cuisine
	 */
	private BigInteger id;

	/**
	 * The name of Cuisine
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Cuisine
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Cuisine
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Cuisine
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Cuisine
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
