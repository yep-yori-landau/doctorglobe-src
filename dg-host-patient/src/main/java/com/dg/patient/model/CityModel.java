/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author DoctorGlobe
 * 
 */
public class CityModel {

	/**
	 * The id of CityModel
	 */
	private BigInteger id;

	/**
	 * The name of CityModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The state of CityModel
	 */
	private BigInteger state;

	/**
	 * The country of CityModel
	 */
	@NotNull
	private BigInteger country;

	/**
	 * The lat of CityModel
	 */
	private Double lat;

	/**
	 * The lon of CityModel
	 */
	private Double lon;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the state
	 */
	public BigInteger getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(BigInteger state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		if (lat != null) {
			this.lat = lat;
		}
		else {
			this.lat = 0.0;
		}
	}

	/**
	 * @return the lon
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		if (lon != null) {
			this.lon = lon;
		}
		else {
			this.lon = 0.0;
		}
	}

}
