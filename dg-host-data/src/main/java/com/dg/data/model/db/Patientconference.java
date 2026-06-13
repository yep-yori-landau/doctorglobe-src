package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientconference DB Model
 * @author DoctorGlobe
 *
 */
public class Patientconference {

	/**
	 * The id of Patientconference
	 */
	private BigInteger id;

	/**
	 * The conference_dt of Patientconference
	 */
	@NotNull
	private String conference_dt;

	/**
	 * The status of Patientconference
	 */
	@NotNull
	@Size(min = 1, max = 54)
	private String status;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientconference
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The patient_case of Patientconference
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * The timezone of Patientconference
	 */
	private String timezone;

	/**
	 * Get the id of Patientconference
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientconference
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the conference_dt of Patientconference
	 * @return String
	 */
	public String getConferenceDt() {
		return conference_dt;
	}

	/**
	 * Set the conference_dt of Patientconference
	 * @param conference_dt the conference_dt to set
	 */
	public void setConferenceDt(String conference_dt) {
		this.conference_dt = conference_dt;
	}

	/**
	 * Get the status of Patientconference
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of Patientconference
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientconference
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientconference
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Get the patient_case of Patientconference
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of Patientconference
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

	/**
	 * Get the timezone of Patientconference
	 * @return String
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * Set the timezone of Patientconference
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

}
