package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HospitalAmenityModel{
	
	private BigInteger id;
	 
	@Size(min = 3, max = 3) 
	private String currency;
  
	private double price;
  
	private BigInteger healthcareprovider;

	@NotNull  
	private BigInteger amenity;

        /**
	* @return the id
	*/
	public BigInteger getId() {
	 return id;
	}

	/**
   	* @param id the id to set
	*/
	public void setId(BigInteger id ) {
	 this.id = id;
	}

	/**
	* @return the currency
	*/
	public String getCurrency() {
	 return currency;
	}

	/**
   	* @param currency the currency to set
	*/
	public void setCurrency(String currency ) {
	 this.currency = currency;
	}

	/**
	* @return the price
	*/
	public double getPrice() {
	 return price;
	}

	/**
   	* @param price the price to set
	*/
	public void setPrice(double price ) {
	 this.price = price;
	}

	/**
	* @return the healthcareprovider
	*/
	public BigInteger getHealthcareprovider() {
	 return healthcareprovider;
	}

	/**
   	* @param healthcareprovider the healthcareprovider to set
	*/
	public void setHealthcareprovider(BigInteger healthcareprovider ) {
	 this.healthcareprovider = healthcareprovider;
	}

	/**
	* @return the amenity
	*/
	public BigInteger getAmenity() {
	 return amenity;
	}

	/**
   	* @param amenity the amenity to set
	*/
	public void setAmenity(BigInteger amenity ) {
	 this.amenity = amenity;
	}
}