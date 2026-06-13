package com.dg.data.model.domain;

import java.math.BigInteger;

/**
 * PatientLatLonModel Domain Model
 * @author DoctorGlobe
 *
 */
public class PatientLatLonModel {

	/**
	 * The id of PatientLatLonModel
	 */
	private BigInteger id;

	/**
	 * The country of PatientLatLonModel
	 */
	private BigInteger country;

	/**
	 * The city of PatientLatLonModel
	 */
	private BigInteger city;

	/**
	 * The city_name of PatientLatLonModel
	 */
	private String city_name;

	/**
	 * The city_lat of PatientLatLonModel
	 */
	private Double city_lat;

	/**
	 * The city_lon of PatientLatLonModel
	 */
	private Double city_lon;

	/**
	 * The lat of PatientLatLonModel
	 */
	private Double lat;

	/**
	 * The lon of PatientLatLonModel
	 */
	private Double lon;

	/**
	 * The state of PatientLatLonModel
	 */
	private BigInteger state;

	/**
	 * The state_code of PatientLatLonModel
	 */
	private String state_code;

	/**
	 * The state_name of PatientLatLonModel
	 */
	private String state_name;

	/**
	 * Get the id of PatientLatLonModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientLatLonModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the country of PatientLatLonModel
	 * @return BigInteger
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * Set the country of PatientLatLonModel
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * Get the city of PatientLatLonModel
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of PatientLatLonModel
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * Get the city_name of PatientLatLonModel
	 * @return String
	 */
	public String getCityName() {
		return city_name;
	}

	/**
	 * Set the city_name of PatientLatLonModel
	 * @param city_name the city_name to set
	 */
	public void setCityName(String city_name) {
		this.city_name = city_name;
	}

	/**
	 * Get the city_lat of PatientLatLonModel
	 * @return Double
	 */
	public Double getCityLat() {
		return city_lat;
	}

	/**
	 * Set the city_lat of PatientLatLonModel
	 * @param city_lat the city_lat to set
	 */
	public void setCityLat(Double city_lat) {
		this.city_lat = city_lat;
	}

	/**
	 * Get the city_lon of PatientLatLonModel
	 * @return Double
	 */
	public Double getCityLon() {
		return city_lon;
	}

	/**
	 * Set the city_lon of PatientLatLonModel
	 * @param city_lon the city_lon to set
	 */
	public void setCityLon(Double city_lon) {
		this.city_lon = city_lon;
	}

	/**
	 * Get the lat of PatientLatLonModel
	 * @return Double
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * Set the lat of PatientLatLonModel
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * Get the lon of PatientLatLonModel
	 * @return Double
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * Set the lon of PatientLatLonModel
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * Get the state of PatientLatLonModel
	 * @return BigInteger
	 */
	public BigInteger getState() {
		return state;
	}

	/**
	 * Set the state of PatientLatLonModel
	 * @param state the state to set
	 */
	public void setState(BigInteger state) {
		this.state = state;
	}

	/**
	 * Get the state_code of PatientLatLonModel
	 * @return String
	 */
	public String getStateCode() {
		return state_code;
	}

	/**
	 * Set the state_code of PatientLatLonModel
	 * @param state_code the state_code to set
	 */
	public void setStateCode(String state_code) {
		this.state_code = state_code;
	}

	/**
	 * Get the state_name of PatientLatLonModel
	 * @return String
	 */
	public String getStateName() {
		return state_name;
	}

	/**
	 * Set the state_name of PatientLatLonModel
	 * @param state_name the state_name to set
	 */
	public void setStateName(String state_name) {
		this.state_name = state_name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PatientLatLonModel [id=" + id + ",country=" + country + ",city="
				+ city + ",city_lat =" + city_lat + ",city_lon=" + city_lon
				+ ",city_name=" + city_name + ",lat=" + lat + ",lon=" + lon
				+ ",state=" + state + ",state_code=" + state_code
				+ ",state_name=" + state_name + "]";
	}

}