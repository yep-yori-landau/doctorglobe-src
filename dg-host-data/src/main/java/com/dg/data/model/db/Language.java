/**
 * 
 */
package com.dg.data.model.db;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Language DB Model
 * @author DoctorGlobe
 *
 */
public class Language {

	/**
	 * The id of Language
	 */
	private Integer id;

	/**
	 * The code of Language
	 */
	@NotNull
	@Size(min = 2, max = 2)
	private String code;

	/**
	 * The name of Language
	 */
	@NotNull
	@Size(min = 3, max = 255)
	private String name;

	/**
	 * Get the id of Language
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id of Language
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the code of Language
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set the code of Language
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get the name of Language
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Language
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
