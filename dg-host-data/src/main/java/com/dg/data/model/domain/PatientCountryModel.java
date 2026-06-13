package com.dg.data.model.domain;

/**
 * PatientCountryModel Domain Model
 * @author DoctorGlobe
 *
 */
public class PatientCountryModel {

	/**
	 * The country of PatientCountryModel
	 */
	public String country;

	/**
	 * The country_code of PatientCountryModel
	 */
	private String country_code;

	/**
	 * The state of PatientCountryModel
	 */
	public String state;

	/**
	 * The city of PatientCountryModel
	 */
	public String city;

	/**
	 * Get the country of PatientCountryModel
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the country of PatientCountryModel
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the country_code of PatientCountryModel
	 * @return String
	 */
	public String getCountryCode() {
		return country_code;
	}

	/**
	 * Set the country_code of PatientCountryModel
	 * @param country_code the country_code to set
	 */
	public void setCountryCode(String country_code) {
		this.country_code = country_code;
	}

	/**
	 * Get the state of PatientCountryModel
	 * @return String
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state of PatientCountryModel
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get the city of PatientCountryModel
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city of PatientCountryModel
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}