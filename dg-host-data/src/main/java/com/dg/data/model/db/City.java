/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * City DB Model
 * @author DoctorGlobe
 *
 */
public class City {

	/**
	 * The id of City
	 */
	private BigInteger id;

	/**
	 * The name of City
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The state of City
	 */
	private BigInteger state;

	/**
	 * The country of City
	 */
	@NotNull
	private BigInteger country;

	/**
	 * The lat of City
	 */
	private Double lat;

	/**
	 * The lon of City
	 */
	private Double lon;

	/**
	 * Get the id of City
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of City
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of City
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of City
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the state of City
	 * @return BigInteger
	 */
	public BigInteger getState() {
		return state;
	}

	/**
	 * Set the state of City
	 * @param state the state to set
	 */
	public void setState(BigInteger state) {
		this.state = state;
	}

	/**
	 * Get the country of City
	 * @return BigInteger
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * Set the country of City
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * Get the lat of City
	 * @return Double
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * Set the lat of City
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * Get the lon of City
	 * @return Double
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * Set the lon of City
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

}
