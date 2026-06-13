/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * SpecialtyTreatment DB Model
 * @author DoctorGlobe
 *
 */
public class SpecialtyTreatment {

	/**
	 * The id of SpecialtyTreatment
	 */
	private BigInteger id;

	/**
	 * The treatment of SpecialtyTreatment
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The specialty of SpecialtyTreatment
	 */
	@NotNull
	private BigInteger specialty;

	/**
	 * Get the id of SpecialtyTreatment
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of SpecialtyTreatment
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment of SpecialtyTreatment
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of SpecialtyTreatment
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the specialty of SpecialtyTreatment
	 * @return BigInteger
	 */
	public BigInteger getSpecialty() {
		return specialty;
	}

	/**
	 * Set the specialty of SpecialtyTreatment
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(BigInteger specialty) {
		this.specialty = specialty;
	}

}
