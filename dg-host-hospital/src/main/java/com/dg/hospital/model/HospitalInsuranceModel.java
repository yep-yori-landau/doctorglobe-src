package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalInsuranceModel{
	
	private BigInteger id;

	@NotNull  
	private BigInteger insurance;
  
	private BigInteger healthcareprovider;

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
}