package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * PatientcasePrice DB Model
 * @author DoctorGlobe
 *
 */
public class PatientcasePrice {

	/**
	 * The id of PatientcasePrice
	 */
	private BigInteger id;

	/**
	 * The list_price of PatientcasePrice
	 */
	@NotNull
	private Double list_price;

	/**
	 * The youpay_list_price of PatientcasePrice
	 */
	@NotNull
	private Double youpay_list_price;

	/**
	 * The bonus_list_price of PatientcasePrice
	 */
	@NotNull
	private Double bonus_list_price;

	/**
	 * The quote_price of PatientcasePrice
	 */
	private Double quote_price;

	/**
	 * The youpay_quote_price of PatientcasePrice
	 */
	private Double youpay_quote_price;

	/**
	 * The bonus_quote_price of PatientcasePrice
	 */
	private Double bonus_quote_price;

	/**
	 * The billed_price of PatientcasePrice
	 */
	private Double billed_price;

	/**
	 * The youpay_billed_price of PatientcasePrice
	 */
	private Double youpay_billed_price;

	/**
	 * The bonus_billed_price of PatientcasePrice
	 */
	private Double bonus_billed_price;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientcasePrice
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The patient_case of PatientcasePrice
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * Get the id of PatientcasePrice
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientcasePrice
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the list_price of PatientcasePrice
	 * @return Double
	 */
	public Double getListPrice() {
		return list_price;
	}

	/**
	 * Set the list_price of PatientcasePrice
	 * @param list_price the list_price to set
	 */
	public void setListPrice(Double list_price) {
		this.list_price = list_price;
	}

	/**
	 * Get the youpay_list_price of PatientcasePrice
	 * @return Double
	 */
	public Double getYoupayListPrice() {
		return youpay_list_price;
	}

	/**
	 * Set the youpay_list_price of PatientcasePrice
	 * @param youpay_list_price the youpay_list_price to set
	 */
	public void setYoupayListPrice(Double youpay_list_price) {
		this.youpay_list_price = youpay_list_price;
	}

	/**
	 * Get the bonus_list_price of PatientcasePrice
	 * @return Double
	 */
	public Double getBonusListPrice() {
		return bonus_list_price;
	}

	/**
	 * Set the bonus_list_price of PatientcasePrice
	 * @param bonus_list_price the bonus_list_price to set
	 */
	public void setBonusListPrice(Double bonus_list_price) {
		this.bonus_list_price = bonus_list_price;
	}

	/**
	 * Get the quote_price of PatientcasePrice
	 * @return Double
	 */
	public Double getQuotePrice() {
		return quote_price;
	}

	/**
	 * Set the quote_price of PatientcasePrice
	 * @param quote_price the quote_price to set
	 */
	public void setQuotePrice(Double quote_price) {
		this.quote_price = quote_price;
	}

	/**
	 * Get the youpay_quote_price of PatientcasePrice
	 * @return Double
	 */
	public Double getYoupayQuotePrice() {
		return youpay_quote_price;
	}

	/**
	 * Set the youpay_quote_price of PatientcasePrice
	 * @param youpay_quote_price the youpay_quote_price to set
	 */
	public void setYoupayQuotePrice(Double youpay_quote_price) {
		this.youpay_quote_price = youpay_quote_price;
	}

	/**
	 * Get the bonus_quote_price of PatientcasePrice
	 * @return Double
	 */
	public Double getBonusQuotePrice() {
		return bonus_quote_price;
	}

	/**
	 * Set the bonus_quote_price of PatientcasePrice
	 * @param bonus_quote_price the bonus_quote_price to set
	 */
	public void setBonusQuotePrice(Double bonus_quote_price) {
		this.bonus_quote_price = bonus_quote_price;
	}

	/**
	 * Get the billed_price of PatientcasePrice
	 * @return Double
	 */
	public Double getBilledPrice() {
		return billed_price;
	}

	/**
	 * Set the billed_price of PatientcasePrice
	 * @param billed_price the billed_price to set
	 */
	public void setBilledPrice(Double billed_price) {
		this.billed_price = billed_price;
	}

	/**
	 * Get the youpay_billed_price of PatientcasePrice
	 * @return Double
	 */
	public Double getYoupayBilledPrice() {
		return youpay_billed_price;
	}

	/**
	 * Set the youpay_billed_price of PatientcasePrice
	 * @param youpay_billed_price the youpay_billed_price to set
	 */
	public void setYoupayBilledPrice(Double youpay_billed_price) {
		this.youpay_billed_price = youpay_billed_price;
	}

	/**
	 * Get the bonus_billed_price of PatientcasePrice
	 * @return Double
	 */
	public Double getBonusBilledPrice() {
		return bonus_billed_price;
	}

	/**
	 * Set the bonus_billed_price of PatientcasePrice
	 * @param bonus_billed_price the bonus_billed_price to set
	 */
	public void setBonusBilledPrice(Double bonus_billed_price) {
		this.bonus_billed_price = bonus_billed_price;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientcasePrice
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientcasePrice
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Get the patient_case of PatientcasePrice
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of PatientcasePrice
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

}
