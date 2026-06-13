package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HospitalSpecialtyTreatmentMethodPractitionerStatModel{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String description;

	@NotNull  
	private BigInteger stat;
  
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

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
	* @return the description
	*/
	public String getDescription() {
	 return description;
	}

	/**
   	* @param description the description to set
	*/
	public void setDescription(String description ) {
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

}