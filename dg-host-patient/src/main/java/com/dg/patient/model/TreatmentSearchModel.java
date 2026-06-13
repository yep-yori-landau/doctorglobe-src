package com.dg.patient.model;

import java.math.BigInteger;
/**
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
	 * @return the alias_name
	 */
	public String getAliasName() {
		return alias_name;
	}

	/**
	 * @param alias_name the alias_name to set
	 */
	public void setAliasName(String alias_name) {
		this.alias_name = alias_name;
	}
}