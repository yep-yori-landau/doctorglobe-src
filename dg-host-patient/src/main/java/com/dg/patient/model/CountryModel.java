/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author DoctorGlobe
 * 
 */
public class CountryModel {

	/**
	 * The id of CountryModel
	 */
	private BigInteger id;

	/**
	 * The code of CountryModel
	 */
	@NotNull
	@Size(min = 2, max = 2)
	private String code;

	/**
	 * The name of CountryModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The region of CountryModel
	 */
	@NotNull
	private BigInteger region;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the region
	 */
	public BigInteger getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(BigInteger region) {
		this.region = region;
	}

}
