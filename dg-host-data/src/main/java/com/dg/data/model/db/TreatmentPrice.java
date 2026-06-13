/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * TreatmentPrice DB Model
 * @author DoctorGlobe
 *
 */
public class TreatmentPrice {

	/**
	 * The id of TreatmentPrice
	 */
	private BigInteger id;

	/**
	 * The price of TreatmentPrice
	 */
	private Double price;

	/**
	 * The currency of TreatmentPrice
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String currency;

	/**
	 * The city of TreatmentPrice
	 */
	@NotNull
	private BigInteger city;

	/**
	 * The treatment of TreatmentPrice
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * Get the id of TreatmentPrice
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentPrice
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the price of TreatmentPrice
	 * @return Double
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Set the price of TreatmentPrice
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Get the currency of TreatmentPrice
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of TreatmentPrice
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the city of TreatmentPrice
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of TreatmentPrice
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * Get the treatment of TreatmentPrice
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of TreatmentPrice
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

}
