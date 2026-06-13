/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Healthcareproviderunit DB Model
 * @author DoctorGlobe
 *
 */
public class Healthcareproviderunit {

	/**
	 * The id of Healthcareproviderunit
	 */
	private BigInteger id;

	/**
	 * The name of Healthcareproviderunit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Healthcareproviderunit
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Healthcareproviderunit
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Healthcareproviderunit
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Healthcareproviderunit
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
