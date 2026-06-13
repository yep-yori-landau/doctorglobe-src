package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;


/**
 * @author DoctorGlobe
 * 
 */
public class PatientCaseModel {

	/**
	 * The id of PatientCaseModel
	 */
	private BigInteger id;

	/**
	 * The description of PatientCaseModel
	 */
	private String description;

	/**
	 * The status of PatientCaseModel
	 */
	@NotNull
	private String status;

	/**
	 * The treatment of PatientCaseModel
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The patient of PatientCaseModel
	 */
	@NotNull
	private BigInteger patient;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the treatment
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * @return the patient
	 */
	public BigInteger getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(BigInteger patient) {
		this.patient = patient;
	}

}