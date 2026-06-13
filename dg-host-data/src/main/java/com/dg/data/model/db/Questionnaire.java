/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Ratingcompanies DB Model
 * @author DoctorGlobe
 *
 */
public class Questionnaire {

	/**
	 * The id of Questionnaire
	 */
	private BigInteger id;

	/**
	 * The name of Questionnaire
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The type of Questionnaire
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String type;

	/**
	 * The value of Questionnaire
	 */
	private String value;

	/**
	 * Get the id of Questionnaire
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Questionnaire
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Questionnaire
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Questionnaire
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the type of Questionnaire
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of Questionnaire
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the value of Questionnaire
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the value of Questionnaire
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
