package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmenityModel{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;

	@NotNull  
	private Integer is_display;

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
	* @return the is_display
	*/
	public Integer getIsDisplay() {
	 return is_display;
	}

	/**
   	* @param is_display the is_display to set
	*/
	public void setIsDisplay(Integer is_display ) {
	 this.is_display = is_display;
	}

}