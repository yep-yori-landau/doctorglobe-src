/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Country DB Model
 * @author DoctorGlobe
 *
 */
public class Country {

	/**
	 * The id of Country
	 */
	private BigInteger id;

	/**
	 * The code of Country
	 */
	@NotNull
	@Size(min = 2, max = 2)
	private String code;

	/**
	 * The name of Country
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The region of Country
	 */
	@NotNull
	private BigInteger region;

	/**
	 * Get the id of Country
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Country
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the code of Country
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set the code of Country
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the name of Country
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Country
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the region of Country
	 * @return BigInteger
	 */
	public BigInteger getRegion() {
		return region;
	}

	/**
	 * Set the region of Country
	 * @param region the region to set
	 */
	public void setRegion(BigInteger region) {
		this.region = region;
	}

}
