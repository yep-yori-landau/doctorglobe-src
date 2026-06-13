package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * Patientreview DB Model
 * @author DoctorGlobe
 *
 */
public class Patientreview {

	/**
	 * The id of Patientreview
	 */
	private BigInteger id;

	/**
	 * The description of Patientreview
	 */
	private String description;

	/**
	 * The patient of Patientreview
	 */
	@NotNull
	private BigInteger patient;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientreview
	 */
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * Get the id of Patientreview
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientreview
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the description of Patientreview
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Patientreview
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the patient of Patientreview
	 * @return BigInteger
	 */
	public BigInteger getPatient() {
		return patient;
	}

	/**
	 * Set the patient of Patientreview
	 * @param patient the patient to set
	 */
	public void setPatient(BigInteger patient) {
		this.patient = patient;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientreview
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientreview
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

}
