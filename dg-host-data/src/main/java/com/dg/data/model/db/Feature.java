/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Feature DB Model
 * @author DoctorGlobe
 *
 */
public class Feature {

	/**
	 * The id of Feature
	 */
	private BigInteger id;

	/**
	 * The name of Feature
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Feature
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Feature
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Feature
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Feature
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
