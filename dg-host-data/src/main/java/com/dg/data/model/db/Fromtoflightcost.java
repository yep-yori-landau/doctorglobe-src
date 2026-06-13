/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * Fromtoflightcost DB Model
 * @author DoctorGlobe
 *
 */
public class Fromtoflightcost {

	/**
	 * The id of Fromtoflightcost.java
	 */
	private BigInteger id;

	/**
	 * The from_city of Fromtoflightcost.java
	 */
	@NotNull
	private BigInteger from_city;

	/**
	 * The to_city of Fromtoflightcost.java
	 */
	@NotNull
	private BigInteger to_city;

	/**
	 * The amount of Fromtoflightcost.java
	 */
	@NotNull
	private Double amount;

	/**
	 * The currency of Fromtoflightcost.java
	 */
	@NotNull
	private String currency;

	/**
	 * Get the id of Fromtoflightcost.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Fromtoflightcost.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the from_city of Fromtoflightcost.java
	 * @return BigInteger
	 */
	public BigInteger getFromCity() {
		return from_city;
	}

	/**
	 * Set the from_city of Fromtoflightcost.java
	 * @param from_city the from_city to set
	 */
	public void setFromCity(BigInteger from_city) {
		this.from_city = from_city;
	}

	/**
	 * Get the to_city of Fromtoflightcost.java
	 * @return BigInteger
	 */
	public BigInteger getToCity() {
		return to_city;
	}

	/**
	 * Set the to_city of Fromtoflightcost.java
	 * @param to_city the to_city to set
	 */
	public void setToCity(BigInteger to_city) {
		this.to_city = to_city;
	}

	/**
	 * Get the amount of Fromtoflightcost.java
	 * @return Double
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Set the amount of Fromtoflightcost.java
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Get the currency of Fromtoflightcost.java
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of Fromtoflightcost.java
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
