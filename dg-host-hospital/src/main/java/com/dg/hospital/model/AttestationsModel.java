package com.dg.hospital.model;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

public class AttestationsModel{
	
	private BigInteger id;

	@NotNull	 
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
}