package com.dg.patient.model;

import java.math.BigInteger;

/**
 * @author DoctorGlobe
 * 
 */
public class HospitalPractitionerFormModel {

	/**
	 * The hstmp of HospitalPractitionerFormModel
	 */
	private BigInteger hstmp;

	/**
	 * The practitionerName of HospitalPractitionerFormModel
	 */
	private String practitionerName;

	/**
	 * Get the hstmp of HospitalPractitionerFormModel
	 * @return BigInteger
	 */
	public BigInteger getHstmp() {
		return hstmp;
	}

	/**
	 * Set the hstmp of HospitalPractitionerFormModel
	 * @param hstmp the hstmp to set
	 */
	public void setHstmp(BigInteger hstmp) {
		this.hstmp = hstmp;
	}

	/**
	 * Get the practitionerName of HospitalPractitionerFormModel
	 * @return String
	 */
	public String getPractitionerName() {
		return practitionerName;
	}

	/**
	 * Set the practitionerName of HospitalPractitionerFormModel
	 * @param practitionerName the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}

}