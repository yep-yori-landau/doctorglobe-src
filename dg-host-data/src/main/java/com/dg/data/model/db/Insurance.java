/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Insurance DB Model
 * @author DoctorGlobe
 *
 */
public class Insurance {

	/**
	 * The id of Insurance
	 */
	private BigInteger id;

	/**
	 * The name of Insurance
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Insurance
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Insurance
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Insurance
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Insurance
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
