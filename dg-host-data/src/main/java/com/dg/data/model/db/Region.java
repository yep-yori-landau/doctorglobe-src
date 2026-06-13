/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Region DB Model
 * @author DoctorGlobe
 *
 */
public class Region {

	/**
	 * The id of Region
	 */
	private BigInteger id;

	/**
	 * The name of Region
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Region
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Region
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Region
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Region
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
