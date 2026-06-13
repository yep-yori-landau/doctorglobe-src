package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HospitalLanguageModel{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 2, max = 2) 
	private String language;
  
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
	* @return the language
	*/
	public String getLanguage() {
	 return language;
	}

	/**
   	* @param language the language to set
	*/
	public void setLanguage(String language ) {
	 this.language = language;
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