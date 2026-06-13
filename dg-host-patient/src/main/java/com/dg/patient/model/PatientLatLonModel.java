package com.dg.patient.model;

import java.math.BigInteger;
/**
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
	 * 
	 * @return
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * 
	 * @return
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * 
	 * @return
	 */
	public String getCityName() {
		return city_name;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCityName(String city_name) {
		this.city_name = city_name;
	}

	/**
	 * 
	 * @return
	 */
	public Double getCityLat() {
		return city_lat;
	}

	/**
	 * 
	 * @param city_lat
	 */
	public void setCityLat(Double city_lat) {
		this.city_lat = city_lat;
	}

	/**
	 * 
	 * @return
	 */
	public Double getCityLon() {
		return city_lon;
	}

	/**
	 * 
	 * @param city_lon
	 */
	public void setCityLon(Double city_lon) {
		this.city_lon = city_lon;
	}

	/**
	 * 
	 * @return
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * 
	 * @param lat
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @return
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * 
	 * @param lon
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * 
	 * @return state
	 */
	public BigInteger getState() {
		return state;
	}

	/**
	 * 
	 * @param state *
	 */
	public void setState(BigInteger state) {
		this.state = state;
	}

	/**
	 * 
	 * @return
	 */
	public String getStateName() {
		return state_name;
	}

	/**
	 * 
	 * @param city
	 */
	public void setStateName(String state_name) {
		this.state_name = state_name;
	}

	/**
	 * 
	 * @returns state code
	 */
	public String getStateCode() {
		return state_code;
	}

	/**
	 * 
	 * @param city
	 */
	public void setStateCode(String state_code) {
		this.state_code = state_code;
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