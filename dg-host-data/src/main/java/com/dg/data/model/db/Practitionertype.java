/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Practitionertype DB Model
 * @author DoctorGlobe
 *
 */
public class Practitionertype {

	/**
	 * The id of Practitionertype
	 */
	private BigInteger id;

	/**
	 * The name of Practitionertype
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Practitionertype
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Practitionertype
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Practitionertype
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Practitionertype
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
