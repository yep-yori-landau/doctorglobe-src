/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * TreatmentAlias DB Model
 * @author DoctorGlobe
 *
 */
public class TreatmentAlias {

	/**
	 * The id of TreatmentAlias
	 */
	private BigInteger id;

	/**
	 * The name of TreatmentAlias
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The treatment of TreatmentAlias
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * Get the id of TreatmentAlias
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentAlias
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of TreatmentAlias
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of TreatmentAlias
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the treatment of TreatmentAlias
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of TreatmentAlias
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

}
