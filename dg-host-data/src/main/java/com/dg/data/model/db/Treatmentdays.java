/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * Treatmentdays DB Model
 * @author DoctorGlobe
 *
 */
public class Treatmentdays {

	/**
	 * The id of Treatmentdays
	 */
	private BigInteger id;

	/**
	 * The treatment of Treatmentdays
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The before_days of Treatmentdays
	 */
	@NotNull
	private Integer before_days;

	/**
	 * The after_days of Treatmentdays
	 */
	@NotNull
	private Integer after_days;

	/**
	 * The treatment_days of Treatmentdays
	 */
	@NotNull
	private Integer treatment_days;

	/**
	 * The country of Treatmentdays
	 */
	@NotNull
	private BigInteger country;

	/**
	 * Get the id of Treatmentdays
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Treatmentdays
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment of Treatmentdays
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of Treatmentdays
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the before_days of Treatmentdays
	 * @return Integer
	 */
	public Integer getBeforeDays() {
		return before_days;
	}

	/**
	 * Set the before_days of Treatmentdays
	 * @param before_days the before_days to set
	 */
	public void setBeforeDays(Integer before_days) {
		this.before_days = before_days;
	}

	/**
	 * Get the after_days of Treatmentdays
	 * @return Integer
	 */
	public Integer getAfterDays() {
		return after_days;
	}

	/**
	 * Set the after_days of Treatmentdays
	 * @param after_days the after_days to set
	 */
	public void setAfterDays(Integer after_days) {
		this.after_days = after_days;
	}

	/**
	 * Get the treatment_days of Treatmentdays
	 * @return Integer
	 */
	public Integer getTreatmentDays() {
		return treatment_days;
	}

	/**
	 * Set the treatment_days of Treatmentdays
	 * @param treatment_days the treatment_days to set
	 */
	public void setTreatmentDays(Integer treatment_days) {
		this.treatment_days = treatment_days;
	}

	/**
	 * Get the country of Treatmentdays
	 * @return BigInteger
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * Set the country of Treatmentdays
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

}
