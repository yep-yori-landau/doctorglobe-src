package com.dg.data.model.domain;

import java.math.BigInteger;

/**
 * CityStateCountryModel Domain Model
 * @author DoctorGlobe
 *
 */
public class CityStateCountryModel {

	/**
	 * The city id of CityStateCountryModel
	 */
	private BigInteger id;

	/**
	 * The country name of CityStateCountryModel
	 */
	private String country;

	/**
	 * The city name of CityStateCountryModel
	 */
	private String city;

	/**
	 * The state name of CityStateCountryModel
	 */
	private String state;

	/**
	 * Get the city id of CityStateCountryModel.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the city id of CityStateCountryModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the country name of CityStateCountryModel
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the country name of CityStateCountryModel
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the city name of CityStateCountryModel
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city name of CityStateCountryModel
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the state name of CityStateCountryModel
	 * @return String
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state name of CityStateCountryModel
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityStateCountryModel [id=" + id + ",city=" + city + ",country="
				+ country + ",state=" + state + "]";
	}

}