package com.dg.hospital.model.form;

import java.math.BigInteger;

public class PractitionerStatsFormModel{
	
	private BigInteger id;
	
	private String description;
	
	private BigInteger stat;
	
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;
	
	private String stat_name;
	
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
	 * 
	 * @return
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	* @return the stat
	*/
	public BigInteger getStat() {
		return stat;
	}

	/**
  	* @param stat the stat to set
	*/
	public void setStat(BigInteger stat ) {
		this.stat = stat;
	}
	
	/**
	* @return the healthcareprovider_specialty_treatment_method_practitioner
	*/
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
  	* @param healthcareprovider_specialty_treatment_method_practitioner the healthcareprovider_specialty_treatment_method_practitioner to set
	*/
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(BigInteger healthcareprovider_specialty_treatment_method_practitioner ) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStatName(){
		return stat_name;
	}
	
	/**
	 * 
	 * @param stat_name
	 */
	public void setStatName(String stat_name){
		this.stat_name = stat_name;
	}
}