package com.dg.data.model.domain;

import java.math.BigInteger;

/**
 * TreatmentSearchModel Domain Model
 * @author DoctorGlobe
 *
 */
public class TreatmentSearchModel {

	/**
	 * The id of TreatmentSearchModel
	 */
	private BigInteger id;

	/**
	 * The name of TreatmentSearchModel
	 */
	private String name;

	/**
	 * The alias_name of TreatmentSearchModel
	 */
	private String alias_name;

	/**
	 * Get the id of TreatmentSearchModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentSearchModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of TreatmentSearchModel
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of TreatmentSearchModel
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the alias_name of TreatmentSearchModel
	 * @return String
	 */
	public String getAliasName() {
		return alias_name;
	}

	/**
	 * Set the alias_name of TreatmentSearchModel
	 * @param alias_name the alias_name to set
	 */
	public void setAliasName(String alias_name) {
		this.alias_name = alias_name;
	}
}