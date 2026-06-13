package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalCuisineModel{
	
	private BigInteger id;

	@NotNull  
	private BigInteger cuisine;
  
	@NotNull  
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

}