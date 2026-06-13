package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Accreditation DB Model
 * @author DoctorGlobe
 *
 */

public class Accreditation {

	/**
	 * The id of Accreditation
	 */
	private BigInteger id;

	/**
	 * The name of Accreditation
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * Get the id of Accreditation
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Accreditation
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Accreditation
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Accreditation
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
