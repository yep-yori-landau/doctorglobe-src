package com.dg.data.service;

public class PractitionerRatingWeightageService {

	protected Double price;

	protected Double number_performed_last_year;

	protected Double corrections_last_year;

	protected Double us_trained;

	protected Double us_certified;

	protected Double english_speaking;

	protected Double insurance_cap;

	/**
	 * 
	 * @return price weightage
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price weightage
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return number_performed_last_year weightage
	 */
	public Double getNumberPerformedLastYear() {
		return number_performed_last_year;
	}

	/**
	 * 
	 * @param number_performed_last_year weightage
	 */
	public void setNumberPerformedLastYear(Double number_performed_last_year) {
		this.number_performed_last_year = number_performed_last_year;
	}

	/**
	 * 
	 * @return corrections_last_year weightage
	 */
	public Double getCorrectionsLastYear() {
		return corrections_last_year;
	}

	/**
	 * 
	 * @param corrections_last_year weightage
	 */
	public void setCorrectionsLastYear(Double corrections_last_year) {
		this.corrections_last_year = corrections_last_year;
	}

	/**
	 * 
	 * @return us_trained weightage
	 */
	public Double getUsTrained() {
		return us_trained;
	}

	/**
	 * 
	 * @param us_trained weightage
	 */
	public void setUsTrained(Double us_trained) {
		this.us_trained = us_trained;
	}

	/**
	 * 
	 * @return us_certified weightage
	 */
	public Double getUsCertified() {
		return us_certified;
	}

	/**
	 * 
	 * @param us_certified weightage
	 */
	public void setUsCertified(Double us_certified) {
		this.us_certified = us_certified;
	}

	/**
	 * 
	 * @return english_speaking weightage
	 */
	public Double getEnglishSpeaking() {
		return english_speaking;
	}

	/**
	 * 
	 * @param english_speaking weightage
	 */
	public void setEnglishSpeaking(Double english_speaking) {
		this.english_speaking = english_speaking;
	}

	/**
	 * 
	 * @return insurance_cap weightage
	 */
	public Double getInsuranceCap() {
		return insurance_cap;
	}

	/**
	 * 
	 * @param insurance_cap weightage
	 */
	public void setInsuranceCap(Double insurance_cap) {
		this.insurance_cap = insurance_cap;
	}

}