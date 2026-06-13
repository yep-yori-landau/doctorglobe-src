package com.dg.patient.model;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * @author DoctorGlobe
 * 
 */
public class PatientcaseDetailModel {

	/**
	 * The id of PatientcaseDetailModel
	 */
	private BigInteger id;

	/**
	 * The description of PatientcaseDetailModel
	 */
	private String description;

	/**
	 * The status of PatientcaseDetailModel
	 */
	@NotNull
	private String status;

	/**
	 * The treatment of PatientcaseDetailModel
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The treatment_name of PatientcaseDetailModel
	 */
	private String treatment_name;

	/**
	 * The patient of PatientcaseDetailModel
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
	 * @return the treatment_name
	 */
	public String getTreatmentName() {
		return treatment_name;
	}

	/**
	 * @param treatment_name the treatment_name to set
	 */
	public void setTreatmentName(String treatment_name) {
		this.treatment_name = treatment_name;
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