/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Treatment DB Model
 * @author DoctorGlobe
 *
 */
public class Treatment {

	/**
	 * The id of Treatment
	 */
	private BigInteger id;

	/**
	 * The name of Treatment
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The drg_definition of Treatment
	 */
	@Size(min = 0, max = 255)
	private String drg_definition;

	/**
	 * The drg_code of Treatment
	 */
	@Size(min = 0, max = 5)
	private String drg_code;

	/**
	 * The usnews_name of Treatment
	 */
	private String usnews_name;

	/**
	 * Get the id of Treatment
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Treatment
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Treatment
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Treatment
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the drg_definition of Treatment
	 * @return String
	 */
	public String getDrgDefinition() {
		return drg_definition;
	}

	/**
	 * Set the drg_definition of Treatment
	 * @param drg_definition the drg_definition to set
	 */
	public void setDrgDefinition(String drg_definition) {
		this.drg_definition = drg_definition;
	}

	/**
	 * Get the drg_code of Treatment
	 * @return String
	 */
	public String getDrgCode() {
		return drg_code;
	}

	/**
	 * Set the drg_code of Treatment
	 * @param drg_code the drg_code to set
	 */
	public void setDrgCode(String drg_code) {
		this.drg_code = drg_code;
	}

	/**
	 * Get the usnews_name of Treatment
	 * @return String
	 */
	public String getUsnewsName() {
		return usnews_name;
	}

	/**
	 * Set the usnews_name of Treatment
	 * @param usnews_name the usnews_name to set
	 */
	public void setUsnewsName(String usnews_name) {
		this.usnews_name = usnews_name;
	}

}
