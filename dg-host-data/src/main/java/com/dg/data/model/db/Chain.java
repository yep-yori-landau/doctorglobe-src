/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Chain DB Model
 * @author DoctorGlobe
 *
 */
public class Chain {

	/**
	 * The id of Chain
	 */
	private BigInteger id;

	/**
	 * The name of Chain
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Chain
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Chain
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Chain
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Chain
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
