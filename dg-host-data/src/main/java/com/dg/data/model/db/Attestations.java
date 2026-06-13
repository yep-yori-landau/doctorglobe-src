/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * Attestations DB Model
 * @author DoctorGlobe
 *
 */
public class Attestations {

	/**
	 * The id of Attestations
	 */
	private BigInteger id;

	/**
	 * The name of Attestations
	 */
	@NotNull
	private String name;

	/**
	 * Get the id of Attestations
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Attestations
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Attestations
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Attestations
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
