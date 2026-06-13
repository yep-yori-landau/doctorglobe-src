package com.dg.hospital.model.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HospitalAmenityFormModel{
	
	private BigInteger id;
	
	@Size(min = 3, max = 3) 
	private String currency;
  
	private double price;

	@NotNull  
	private BigInteger amenity;
  
	private BigInteger healthcareprovider;
	
	private Boolean is_checked;
	
	private String amenity_name;

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
	* @return the amenity
	*/
	public BigInteger getAmenity() {
	 return amenity;
	}

	/**
   	* @param insurance the insurance to set
	*/
	public void setAmenity(BigInteger amenity ) {
	 this.amenity = amenity;
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
	 * 
	 * @return boolean
	 */
	public Boolean getIsChecked(){
		return is_checked;
	}
	
	/**
	 * 
	 * @param is_checked the is_chekced to set
	 */
	public void setIsChecked(Boolean is_checked){
		this.is_checked = is_checked;
	}
	
	/**
	 * 
	 * @return amenity name
	 */
	public String getAmenityName(){
		return amenity_name;
	}
	
	/**
	 * 
	 * @param amenity_name
	 */
	public void setAmenityName(String amenity_name){
		this.amenity_name = amenity_name;
	}

}