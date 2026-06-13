/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Stats DB Model
 * @author DoctorGlobe
 *
 */
public class Stats {

	/**
	 * The id of Stats
	 */
	private BigInteger id;

	/**
	 * The name of Stats
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The description of Stats
	 */
	private String description;

	/**
	 * Get the id of Stats
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Stats
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Stats
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Stats
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the description of Stats
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Stats
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
