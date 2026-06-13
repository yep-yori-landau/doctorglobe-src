/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * State DB Model
 * @author DoctorGlobe
 *
 */
public class State {

	/**
	 * The id of State
	 */
	private BigInteger id;

	/**
	 * The code of State
	 */
	@NotNull
	@Size(min = 2, max = 3)
	private String code;

	/**
	 * The name of State
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The country of State
	 */
	@NotNull
	private BigInteger country;

	/**
	 * Get the id of State
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of State
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the code of State
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set the code of State
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the name of State
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of State
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the country of State
	 * @return BigInteger
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * Set the country of State
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

}
