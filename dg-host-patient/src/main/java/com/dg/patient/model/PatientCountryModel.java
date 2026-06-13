package com.dg.patient.model;
/**
 * @author DoctorGlobe
 * 
 */
public class PatientCountryModel {

	/**
	 * The country of PatientCountryModel.java
	 */
	public String country;

	/**
	 * The country_code of PatientCountryModel.java
	 */
	private String country_code;

	/**
	 * The state of PatientCountryModel.java
	 */
	public String state;

	/**
	 * The city of PatientCountryModel.java
	 */
	public String city;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return country_code;
	}

	public void setCountryCode(String country_code) {
		this.country_code = country_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}