/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientreviewratings DB Model
 * @author DoctorGlobe
 *
 */
public class Patientreviewratings {

	/**
	 * The id of Patientreviewratings
	 */
	private BigInteger id;

	/**
	 * The rating_type of Patientreviewratings
	 */
	@NotNull
	@Size(min = 1, max = 26)
	private String rating_type;

	/**
	 * The rating of Patientreviewratings
	 */
	@NotNull
	private Integer rating;

	/**
	 * The patient_review of Patientreviewratings
	 */
	@NotNull
	private BigInteger patient_review;

	/**
	 * Get the id of Patientreviewratings
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientreviewratings
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the rating_type of Patientreviewratings
	 * @return String
	 */
	public String getRatingType() {
		return rating_type;
	}

	/**
	 * Set the rating_type of Patientreviewratings
	 * @param rating_type the rating_type to set
	 */
	public void setRatingType(String rating_type) {
		this.rating_type = rating_type;
	}

	/**
	 * Get the rating of Patientreviewratings
	 * @return Integer
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Set the rating of Patientreviewratings
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * Get the patient_review of Patientreviewratings
	 * @return BigInteger
	 */
	public BigInteger getPatientReview() {
		return patient_review;
	}

	/**
	 * Set the patient_review of Patientreviewratings
	 * @param patient_review the patient_review to set
	 */
	public void setPatientReview(BigInteger patient_review) {
		this.patient_review = patient_review;
	}

}
