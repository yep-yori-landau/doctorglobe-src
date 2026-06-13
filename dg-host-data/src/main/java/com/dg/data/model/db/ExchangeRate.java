/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ExchangeRate DB Model
 * @author DoctorGlobe
 *
 */
public class ExchangeRate {

	/**
	 * The id of ExchangeRate
	 */
	private BigInteger id;

	/**
	 * The from_cur of ExchangeRate
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String from_cur;

	/**
	 * The to_cur of ExchangeRate
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String to_cur;

	/**
	 * The rate of ExchangeRate
	 */
	@NotNull
	private double rate;

	/**
	 * Get the id of ExchangeRate
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of ExchangeRate
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the from_cur of ExchangeRate
	 * @return String
	 */
	public String getFromCur() {
		return from_cur;
	}

	/**
	 * Set the from_cur of ExchangeRate
	 * @param from_cur the from_cur to set
	 */
	public void setFromCur(String from_cur) {
		this.from_cur = from_cur;
	}

	/**
	 * Get the to_cur of ExchangeRate
	 * @return String
	 */
	public String getToCur() {
		return to_cur;
	}

	/**
	 * Set the to_cur of ExchangeRate
	 * @param to_cur the to_cur to set
	 */
	public void setToCur(String to_cur) {
		this.to_cur = to_cur;
	}

	/**
	 * Get the rate of ExchangeRate
	 * @return double
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Set the rate of ExchangeRate
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

}
