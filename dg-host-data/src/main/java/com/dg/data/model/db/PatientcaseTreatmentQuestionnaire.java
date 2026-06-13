package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * PatientcaseTreatmentQuestionnaire DB Model
 * @author DoctorGlobe
 *
 */
public class PatientcaseTreatmentQuestionnaire {

	/**
	 * The id of PatientcaseTreatmentQuestionnaire
	 */
	private BigInteger id;

	/**
	 * The treatment_questionnaire of PatientcaseTreatmentQuestionnaire
	 */
	@NotNull
	private BigInteger treatment_questionnaire;

	/**
	 * The patientcase of PatientcaseTreatmentQuestionnaire
	 */
	@NotNull
	private BigInteger patientcase;

	/**
	 * The value of PatientcaseTreatmentQuestionnaire
	 */
	@NotNull
	private String value;

	/**
	 * Get the id of PatientcaseTreatmentQuestionnaire
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientcaseTreatmentQuestionnaire
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment_questionnaire of PatientcaseTreatmentQuestionnaire
	 * @return BigInteger
	 */
	public BigInteger getTreatmentQuestionnaire() {
		return treatment_questionnaire;
	}

	/**
	 * Set the treatment_questionnaire of PatientcaseTreatmentQuestionnaire
	 * @param treatment_questionnaire the treatment_questionnaire to set
	 */
	public void setTreatmentQuestionnaire(BigInteger treatment_questionnaire) {
		this.treatment_questionnaire = treatment_questionnaire;
	}

	/**
	 * Get the patientcase of PatientcaseTreatmentQuestionnaire
	 * @return BigInteger
	 */
	public BigInteger getPatientcase() {
		return patientcase;
	}

	/**
	 * Set the patientcase of PatientcaseTreatmentQuestionnaire
	 * @param patientcase the patientcase to set
	 */
	public void setPatientcase(BigInteger patientcase) {
		this.patientcase = patientcase;
	}

	/**
	 * Get the value of PatientcaseTreatmentQuestionnaire
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the value of PatientcaseTreatmentQuestionnaire
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
