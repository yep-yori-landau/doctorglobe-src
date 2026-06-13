/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Specialty DB Model
 * @author DoctorGlobe
 *
 */
public class Specialty {

	/**
	 * The id of Specialty
	 */
	private BigInteger id;

	/**
	 * The name of Specialty
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Specialty
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Specialty
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Specialty
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Specialty
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
