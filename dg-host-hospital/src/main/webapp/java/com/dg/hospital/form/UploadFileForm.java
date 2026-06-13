package com.dg.hospital.form;

import java.math.BigInteger;

import javax.validation.constraints.Size;

public class UploadFileForm{
	
	private BigInteger id;
	
	private String path;
	 
	private String type;
 
	@Size(min = 1, max = 255) 
	private String description;
  
	private BigInteger healthcareprovider;
	
	private Integer is_primary;

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
	* @return the path
	*/
	public String getPath() {
	 return path;
	}

	/**
   	* @param path the path to set
	*/
	public void setPath(String path ) {
	 this.path = path;
	}

	/**
	* @return the type
	*/
	public String getType() {
	 return type;
	}

	/**
   	* @param type the type to set
	*/
	public void setType(String type ) {
	 this.type = type;
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

	/**
	 * 
	 * @return the is_primary
	 */
	public Integer getIsPrimary(){
		return is_primary;
	}
	
	/**
	 * 
	 * @param is_primary the is_primary to set
	 */
	public void setIsPrimary(Integer is_primary){
		this.is_primary = is_primary;
	}
}