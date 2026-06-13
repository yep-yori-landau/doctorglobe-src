/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * TreatmentQuestionnaire DB Model
 * @author DoctorGlobe
 *
 */
public class TreatmentQuestionnaire {

	/**
	 * The id of TreatmentQuestionnaire
	 */
	private BigInteger id;

	/**
	 * The treatment of TreatmentQuestionnaire
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The questionnaire of TreatmentQuestionnaire
	 */
	@NotNull
	private BigInteger questionnaire;

	/**
	 * Get the id of TreatmentQuestionnaire
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentQuestionnaire
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment of TreatmentQuestionnaire
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of TreatmentQuestionnaire
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the questionnaire of TreatmentQuestionnaire
	 * @return BigInteger
	 */
	public BigInteger getQuestionnaire() {
		return questionnaire;
	}

	/**
	 * Set the questionnaire of TreatmentQuestionnaire
	 * @param questionnaire the questionnaire to set
	 */
	public void setQuestionnaire(BigInteger questionnaire) {
		this.questionnaire = questionnaire;
	}

}
