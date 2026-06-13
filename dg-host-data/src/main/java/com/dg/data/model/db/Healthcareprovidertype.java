/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Healthcareprovidertype DB Model
 * @author DoctorGlobe
 *
 */
public class Healthcareprovidertype {

	/**
	 * The id of Healthcareprovidertype
	 */
	private BigInteger id;

	/**
	 * The name of Healthcareprovidertype
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Healthcareprovidertype
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Healthcareprovidertype
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Healthcareprovidertype
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Healthcareprovidertype
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
