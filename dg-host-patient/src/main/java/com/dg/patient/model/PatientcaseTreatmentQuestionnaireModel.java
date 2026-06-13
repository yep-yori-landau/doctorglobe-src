/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * @author DoctorGlobe
 * 
 */
public class PatientcaseTreatmentQuestionnaireModel {

	/**
	 * The id of PatientcaseTreatmentQuestionnaireModel
	 */
	private BigInteger id;

	/**
	 * The treatment_questionnaire of PatientcaseTreatmentQuestionnaireModel
	 */
	@NotNull
	private BigInteger treatment_questionnaire;

	/**
	 * The patientcase of PatientcaseTreatmentQuestionnaireModel
	 */
	@NotNull
	private BigInteger patientcase;

	/**
	 * The value of PatientcaseTreatmentQuestionnaireModel
	 */
	@NotNull
	private String value;

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
	 * @return the treatment_questionnaire
	 */
	public BigInteger getTreatmentQuestionnaire() {
		return treatment_questionnaire;
	}

	/**
	 * @param treatment_questionnaire the treatment_questionnaire to set
	 */
	public void setTreatmentQuestionnaire(BigInteger treatment_questionnaire) {
		this.treatment_questionnaire = treatment_questionnaire;
	}

	/**
	 * @return the patientcase
	 */
	public BigInteger getPatientcase() {
		return patientcase;
	}

	/**
	 * @param patientcase the patientcase to set
	 */
	public void setPatientcase(BigInteger patientcase) {
		this.patientcase = patientcase;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
