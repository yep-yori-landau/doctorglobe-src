package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
/**
 * @author DoctorGlobe
 * 
 */
public class TreatmentQuestionnaireModel {

	/**
	 * The id of TreatmentQuestionnaireModel
	 */
	private BigInteger id;

	/**
	 * The treatment of TreatmentQuestionnaireModel
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The questionnaire of TreatmentQuestionnaireModel
	 */
	@NotNull
	private BigInteger questionnaire;

	/**
	 * The name of TreatmentQuestionnaireModel
	 */
	private String name;

	/**
	 * The type of TreatmentQuestionnaireModel
	 */
	private String type;

	/**
	 * The value of TreatmentQuestionnaireModel
	 */
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
	 * @return the questionnaire
	 */
	public BigInteger getQuestionnaire() {
		return questionnaire;
	}

	/**
	 * @param questionnaire the questionnaire to set
	 */
	public void setQuestionnaire(BigInteger questionnaire) {
		this.questionnaire = questionnaire;
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