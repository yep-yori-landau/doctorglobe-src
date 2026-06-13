package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PractitionerLanguageModel{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 2, max = 2) 
	private String language;

	@NotNull  
	private BigInteger practitioner;

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
	* @return the practitioner
	*/
	public BigInteger getPractitioner() {
	 return practitioner;
	}

	/**
   	* @param practitioner the practitioner to set
	*/
	public void setPractitioner(BigInteger practitioner ) {
	 this.practitioner = practitioner;
	}

}