package com.dg.patient.model;

import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotNull;
/**
 * @author DoctorGlobe
 * 
 */
public class PatientcaseTreatmentQuestionnaireFormModel {

	/**
	 * The id of PatientcaseTreatmentQuestionnaireFormModel
	 */
	private BigInteger id;

	/**
	 * The treatment_questionnaire of PatientcaseTreatmentQuestionnaireFormModel
	 */
	@NotNull
	private BigInteger treatment_questionnaire;

	/**
	 * The patientcase of PatientcaseTreatmentQuestionnaireFormModel
	 */
	@NotNull
	private BigInteger patientcase;

	/**
	 * The answer of PatientcaseTreatmentQuestionnaireFormModel
	 */
	@NotNull
	private String answer;

	/**
	 * The name of PatientcaseTreatmentQuestionnaireFormModel
	 */
	@NotNull
	private String name;

	/**
	 * The type of PatientcaseTreatmentQuestionnaireFormModel
	 */
	@NotNull
	private String type;

	/**
	 * The valueList of PatientcaseTreatmentQuestionnaireFormModel
	 */
	private List<String> valueList;

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
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public List<String> getValueList() {
		return valueList;
	}

	/**
	 * @param value the value to set
	 */
	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
	}

}