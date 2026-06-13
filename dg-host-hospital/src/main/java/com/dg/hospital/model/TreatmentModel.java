package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TreatmentModel{
	
	private BigInteger id;	

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;	
	
	@Size(min = 0, max = 255)
	private String drg_definition;
	
	@Size(min = 0, max = 5) 
	private String drg_code;

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
	* @return the name
	*/
	public String getName() {
	 return name;
	}

	/**
   	* @param name the name to set
	*/
	public void setName(String name ) {
	 this.name = name;
	}
	
	/**
	* @return the drg_definition
	*/
	public String getDrgDefinition() {
	 return drg_definition;
	}

	/**
   	* @param drg_definition the drg_definition to set
	*/
	public void setDrgDefinition(String drg_definition ) {
	 this.drg_definition = drg_definition;
	}
	
	/**
	* @return the drg_code
	*/
	public String getDrgCode() {
	 return drg_code;
	}

	/**
   	* @param drg_code the drg_code to set
	*/
	public void setDrgCode(String drg_code ) {
	 this.drg_code = drg_code;
	}
}