package com.dg.data.model.domain;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * TreatmentQuestionnaireModel Domain Model
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
	 * Get the id of TreatmentQuestionnaireModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentQuestionnaireModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment of TreatmentQuestionnaireModel
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of TreatmentQuestionnaireModel
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the questionnaire of TreatmentQuestionnaireModel
	 * @return BigInteger
	 */
	public BigInteger getQuestionnaire() {
		return questionnaire;
	}

	/**
	 * Set the questionnaire of TreatmentQuestionnaireModel
	 * @param questionnaire the questionnaire to set
	 */
	public void setQuestionnaire(BigInteger questionnaire) {
		this.questionnaire = questionnaire;
	}

	/**
	 * Get the name of TreatmentQuestionnaireModel
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of TreatmentQuestionnaireModel
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the type of TreatmentQuestionnaireModel
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of TreatmentQuestionnaireModel
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the value of TreatmentQuestionnaireModel
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the value of TreatmentQuestionnaireModel
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}