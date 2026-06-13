package com.dg.data.model.domain;

import java.math.BigInteger;

/**
 * HospitalPractitionerModel Domain Model
 * @author DoctorGlobe
 *
 */
public class HospitalPractitionerModel {

	/**
	 * The id of HospitalPractitionerModel
	 */
	private BigInteger id;

	/**
	 * The practitioner of HospitalPractitionerModel
	 */
	private BigInteger practitioner;

	/**
	 * The practitioner_name of HospitalPractitionerModel
	 */
	private String practitioner_name;

	/**
	 * Get the id of HospitalPractitionerModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HospitalPractitionerModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the practitioner of HospitalPractitionerModel
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of HospitalPractitionerModel
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * Get the practitioner_name of HospitalPractitionerModel
	 * @return String
	 */
	public String getPractitionerName() {
		return practitioner_name;
	}

	/**
	 * Set the practitioner_name of HospitalPractitionerModel
	 * @param practitioner_name the practitioner_name to set
	 */
	public void setPractitionerName(String practitioner_name) {
		this.practitioner_name = practitioner_name;
	}
}