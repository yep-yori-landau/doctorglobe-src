package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author DoctorGlobe
 * 
 */
public class TreatmentModel {
	/**
	 * The id of TreatmentModel
	 */
	private BigInteger id;

	/**
	 * The name of TreatmentModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The drg_definition of TreatmentModel
	 */
	@Size(min = 0, max = 255)
	private String drg_definition;

	/**
	 * The drg_code of TreatmentModel
	 */
	@Size(min = 0, max = 5)
	private String drg_code;

	/**
	 * The usnews_name of TreatmentModel
	 */
	private String usnews_name;

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
	 * @return the drg_definition
	 */
	public String getDrgDefinition() {
		return drg_definition;
	}

	/**
	 * @param drg_definition the drg_definition to set
	 */
	public void setDrgDefinition(String drg_definition) {
		this.drg_definition = drg_definition;
	}

	/**
	 * @return the drg_code
	 */
	public String getDrgCode() {
		return drg_code;
	}

	/**
	 * @param drg_code the drg_code to set
	 */
	public void setDrgCode(String drg_code) {
		this.drg_code = drg_code;
	}

	/**
	 * @return the usnews_name
	 */
	public String getUsnewsName() {
		return usnews_name;
	}

	/**
	 * @param usnews_name the usnews_name to set
	 */
	public void setUsnewsName(String usnews_name) {
		this.usnews_name = usnews_name;
	}

}