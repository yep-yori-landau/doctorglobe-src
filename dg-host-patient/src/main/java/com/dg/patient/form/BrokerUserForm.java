package com.dg.patient.form;

import java.math.BigInteger;

/**
 * Broker user form
 * @author DoctorGlobe
 *
 */
public class BrokerUserForm {

	/**
	 * The search of BrokerUserForm
	 */
	private String search;

	/**
	 * The corporatecompany of BrokerUserForm
	 */
	private BigInteger corporatecompany;

	/**
	 * Get the search of BrokerUserForm.java
	 * @return String
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * Set the search of BrokerUserForm.java
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * Get the corporatecompany of BrokerUserForm.java
	 * @return BigInteger
	 */
	public BigInteger getCorporatecompany() {
		return corporatecompany;
	}

	/**
	 * Set the corporatecompany of BrokerUserForm.java
	 * @param corporatecompany the corporatecompany to set
	 */
	public void setCorporatecompany(BigInteger corporatecompany) {
		this.corporatecompany = corporatecompany;
	}
}