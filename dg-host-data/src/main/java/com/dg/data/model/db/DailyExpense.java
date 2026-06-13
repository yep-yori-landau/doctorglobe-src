/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * DailyExpense DB Model
 * @author DoctorGlobe
 *
 */
public class DailyExpense {

	/**
	 * The id of DailyExpense
	 */
	private BigInteger id;

	/**
	 * The country of DailyExpense
	 */
	@NotNull
	private BigInteger country;

	/**
	 * The amount of DailyExpense
	 */
	/**
	 * The amount of DailyExpense
	 */
	@NotNull
	private Double amount;

	/**
	 * The currency of DailyExpense
	 */
	@NotNull
	private String currency;

	/**
	 * Get the id of DailyExpense
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of DailyExpense
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the country of DailyExpense
	 * @return BigInteger
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * Set the country of DailyExpense
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * Get the amount of DailyExpense
	 * @return Double
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Set the amount of DailyExpense
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Get the currency of DailyExpense
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of DailyExpense
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
