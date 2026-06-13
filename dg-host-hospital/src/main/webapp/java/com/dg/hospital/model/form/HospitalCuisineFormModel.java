package com.dg.hospital.model.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalCuisineFormModel{
	
	private BigInteger id;

	@NotNull  
	private BigInteger cuisine;
  
	private BigInteger healthcareprovider;
	
	private Boolean is_checked;
	
	private String cuisine_name;

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
	* @return the cuisine
	*/
	public BigInteger getCuisine() {
	 return cuisine;
	}

	/**
   	* @param insurance the insurance to set
	*/
	public void setCuisine(BigInteger cuisine ) {
	 this.cuisine = cuisine;
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
	 * @return cuisine name
	 */
	public String getCuisineName(){
		return cuisine_name;
	}
	
	/**
	 * 
	 * @param cuisine_name
	 */
	public void setCuisineName(String cuisine_name){
		this.cuisine_name = cuisine_name;
	}

}