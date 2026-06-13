package com.dg.data.model.domain;

import java.math.BigInteger;

/**
 * PatientcaseDetailModel Domain Model
 * @author DoctorGlobe
 *
 */
public class PatientcaseDetailModel {

	/**
	 * The id of PatientcaseDetailModel.java
	 */
	private BigInteger id;

	/**
	 * The description of PatientcaseDetailModel.java
	 */
	private String description;

	/**
	 * The status of PatientcaseDetailModel.java
	 */
	private String status;

	/**
	 * The treatment of PatientcaseDetailModel.java
	 */
	private BigInteger treatment;

	/**
	 * The treatment_name of PatientcaseDetailModel.java
	 */
	private String treatment_name;

	/**
	 * The patient of PatientcaseDetailModel.java
	 */
	private BigInteger patient;

	/**
	 * Get the id of PatientcaseDetailModel.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientcaseDetailModel.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the description of PatientcaseDetailModel.java
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of PatientcaseDetailModel.java
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the status of PatientcaseDetailModel.java
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of PatientcaseDetailModel.java
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the treatment of PatientcaseDetailModel.java
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of PatientcaseDetailModel.java
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the treatment_name of PatientcaseDetailModel.java
	 * @return String
	 */
	public String getTreatmentName() {
		return treatment_name;
	}

	/**
	 * Set the treatment_name of PatientcaseDetailModel.java
	 * @param treatment_name the treatment_name to set
	 */
	public void setTreatmentName(String treatment_name) {
		this.treatment_name = treatment_name;
	}

	/**
	 * Get the patient of PatientcaseDetailModel.java
	 * @return BigInteger
	 */
	public BigInteger getPatient() {
		return patient;
	}

	/**
	 * Set the patient of PatientcaseDetailModel.java
	 * @param patient the patient to set
	 */
	public void setPatient(BigInteger patient) {
		this.patient = patient;
	}

}