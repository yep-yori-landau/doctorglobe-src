/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderAmenity DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderAmenity {

	/**
	 * The id of HealthcareproviderAmenity
	 */
	private BigInteger id;

	/**
	 * The currency of HealthcareproviderAmenity
	 */
	@Size(min = 3, max = 3)
	private String currency;

	/**
	 * The price of HealthcareproviderAmenity
	 */
	private Double price;

	/**
	 * The healthcareprovider of HealthcareproviderAmenity
	 */
	private BigInteger healthcareprovider;

	/**
	 * The amenity of HealthcareproviderAmenity
	 */
	@NotNull
	private BigInteger amenity;

	/**
	 * Get the id of HealthcareproviderAmenity
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderAmenity
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the currency of HealthcareproviderAmenity
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of HealthcareproviderAmenity
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the price of HealthcareproviderAmenity
	 * @return Double
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Set the price of HealthcareproviderAmenity
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		if (price != null) {
			this.price = price;
		}
		else {
			this.price = 0.0;
		}
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderAmenity
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderAmenity
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * Get the amenity of HealthcareproviderAmenity
	 * @return BigInteger
	 */
	public BigInteger getAmenity() {
		return amenity;
	}

	/**
	 * Set the amenity of HealthcareproviderAmenity
	 * @param amenity the amenity to set
	 */
	public void setAmenity(BigInteger amenity) {
		this.amenity = amenity;
	}

}
