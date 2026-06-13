package com.dg.hospital.model;

import java.math.BigInteger;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsuranceModel{
	
	private BigInteger id;
	
	private String name;
	
	/**
	 * 
	 * @return id
	 */
	public BigInteger getId(){
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(BigInteger id){
		this.id = id;
	}
	
	/**
	 * 
	 * @return
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