package com.dg.hospital.model.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalAccreditationFormModel{
	
	private BigInteger id;

	@NotNull  
	private String accreditation_dt;

	@NotNull  
	private BigInteger accreditation;

	@NotNull  
	private BigInteger healthcareprovider;
	
	private Boolean is_checked;
	
	private String name;

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
	* @return the accreditation_dt
	*/
	public String getAccreditationDt() {
	 return accreditation_dt;
	}

	/**
   	* @param accreditation_dt the accreditation_dt to set
	*/
	public void setAccreditationDt(String accreditation_dt ) {
	 this.accreditation_dt = accreditation_dt;
	}

	/**
	* @return the accreditation
	*/
	public BigInteger getAccreditation() {
	 return accreditation;
	}

	/**
   	* @param accreditation the accreditation to set
	*/
	public void setAccreditation(BigInteger accreditation ) {
	 this.accreditation = accreditation;
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
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
}