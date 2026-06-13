/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Method DB Model
 * @author DoctorGlobe
 *
 */
public class Method {

	/**
	 * The id of Method
	 */
	private BigInteger id;

	/**
	 * The name of Method
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Method
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Method
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Method
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Method
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
