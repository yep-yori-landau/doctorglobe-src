package com.dg.hospital.model.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalInsuranceFormModel{
	
	private BigInteger id;

	@NotNull  
	private BigInteger insurance;
  
	private BigInteger healthcareprovider;
	
	private Boolean is_checked;
	
	private String insurance_name;

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
	* @return the insurance
	*/
	public BigInteger getInsurance() {
	 return insurance;
	}

	/**
   	* @param insurance the insurance to set
	*/
	public void setInsurance(BigInteger insurance ) {
	 this.insurance = insurance;
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
	 * @return isurance name
	 */
	public String getInsuranceName(){
		return insurance_name;
	}
	
	/**
	 * 
	 * @param Insurance_name
	 */
	public void setInsuranceName(String insurance_name){
		this.insurance_name = insurance_name;
	}

}