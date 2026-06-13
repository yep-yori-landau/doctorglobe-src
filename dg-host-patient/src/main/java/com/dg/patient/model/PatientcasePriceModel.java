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
public class PatientcasePriceModel {

	/**
	 * The id of PatientcasePriceModel
	 */
	private BigInteger id;

	/**
	 * The list_price of PatientcasePriceModel
	 */
	@NotNull
	private Double list_price;

	/**
	 * The youpay_list_price of PatientcasePriceModel
	 */
	@NotNull
	private Double youpay_list_price;

	/**
	 * The bonus_list_price of PatientcasePriceModel
	 */
	@NotNull
	private Double bonus_list_price;

	/**
	 * The quote_price of PatientcasePriceModel
	 */
	private Double quote_price;

	/**
	 * The youpay_quote_price of PatientcasePriceModel
	 */
	private Double youpay_quote_price;

	/**
	 * The bonus_quote_price of PatientcasePriceModel
	 */
	private Double bonus_quote_price;

	/**
	 * The billed_price of PatientcasePriceModel
	 */
	private Double billed_price;

	/**
	 * The youpay_billed_price of PatientcasePriceModel
	 */
	private Double youpay_billed_price;

	/**
	 * The bonus_billed_price of PatientcasePriceModel
	 */
	private Double bonus_billed_price;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of PatientcasePriceModel
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The patient_case of PatientcasePriceModel
	 */
	@NotNull
	private BigInteger patient_case;

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
	 * 
	 * @return the list_price
	 */
	public Double getListPrice() {
		return list_price;
	}

	/**
	 * 
	 * @param list_price the list_price to set
	 */
	public void setListPrice(Double list_price) {
		this.list_price = list_price;
	}

	/**
	 * 
	 * @return the youpay_list_price
	 */
	public Double getYoupayListPrice() {
		return youpay_list_price;
	}

	/**
	 * 
	 * @param youpay_list_price the youpay_list_price to set
	 */
	public void setYoupayListPrice(Double youpay_list_price) {
		this.youpay_list_price = youpay_list_price;
	}

	/**
	 * 
	 * @return the bonus_list_price
	 */
	public Double getBonusListPrice() {
		return bonus_list_price;
	}

	/**
	 * 
	 * @param bonus_list_price the bonus_list_price to set
	 */
	public void setBonusListPrice(Double bonus_list_price) {
		this.bonus_list_price = bonus_list_price;
	}

	/**
	 * 
	 * @return the quote_price
	 */
	public Double getQuotePrice() {
		return quote_price;
	}

	/**
	 * 
	 * @param quote_price the quote_price to set
	 */
	public void setQuotePrice(Double quote_price) {
		this.quote_price = quote_price;
	}

	/**
	 * 
	 * @return the youpay_quote_price
	 */
	public Double getYoupayQuotePrice() {
		return youpay_quote_price;
	}

	/**
	 * 
	 * @param youpay_quote_price the youpay_quote_price to set
	 */
	public void setYoupayQuotePrice(Double youpay_quote_price) {
		this.youpay_quote_price = youpay_quote_price;
	}

	/**
	 * 
	 * @return the bonus_list_price
	 */
	public Double getBonusQuotePrice() {
		return bonus_quote_price;
	}

	/**
	 * 
	 * @param bonus_list_price the bonus_list_price to set
	 */
	public void setBonusQuotePrice(Double bonus_quote_price) {
		this.bonus_quote_price = bonus_quote_price;
	}

	/**
	 * 
	 * @return the billed_price
	 */
	public Double getBilledPrice() {
		return billed_price;
	}

	/**
	 * 
	 * @param billed_price the billed_price to set
	 */
	public void setBilledPrice(Double billed_price) {
		this.billed_price = billed_price;
	}

	/**
	 * 
	 * @return the youpay_billed_price
	 */
	public Double getYoupayBilledPrice() {
		return youpay_billed_price;
	}

	/**
	 * 
	 * @param youpay_billed_price the youpay_billed_price to set
	 */
	public void setYoupayBilledPrice(Double youpay_billed_price) {
		this.youpay_billed_price = youpay_billed_price;
	}

	/**
	 * 
	 * @return the bonus_billed_price
	 */
	public Double getBonusBilledPrice() {
		return bonus_billed_price;
	}

	/**
	 * 
	 * @param bonus_billed_price the bonus_billed_price to set
	 */
	public void setBonusBilledPrice(Double bonus_billed_price) {
		this.bonus_billed_price = bonus_billed_price;
	}

	/**
	 * @return the healthcareprovider_specialty_treatment_method_practitioner
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * @return the patient_case
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

}
