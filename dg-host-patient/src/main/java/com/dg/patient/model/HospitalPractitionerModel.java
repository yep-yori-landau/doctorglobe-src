package com.dg.patient.model;

import java.math.BigInteger;
/**
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
	 * @return the practitioner
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	public String getPractitionerName() {
		return practitioner_name;
	}

	/**
	 * @param practitioner_name the practitioner_name to set
	 */
	public void setPractitionerName(String practitioner_name) {
		this.practitioner_name = practitioner_name;
	}
}