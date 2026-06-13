package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author DoctorGlobe
 * 
 */
public class TreatmentPriceModel {

	/**
	 * The id of TreatmentPriceModel
	 */
	private BigInteger id;

	/**
	 * The price of TreatmentPriceModel
	 */
	private Double price;

	/**
	 * The currency of TreatmentPriceModel
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String currency;

	/**
	 * The city of TreatmentPriceModel
	 */
	@NotNull
	private BigInteger city;

	/**
	 * The treatment of TreatmentPriceModel
	 */
	@NotNull
	private BigInteger treatment;

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
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the city
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
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

}