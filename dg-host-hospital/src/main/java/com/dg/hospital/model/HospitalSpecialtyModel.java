package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalSpecialtyModel{
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;
  
	private String built;
  
	private String renovated;

	@NotNull  
	private BigInteger specialty;
  
	private BigInteger healthcareprovider;
	
	private Boolean active;

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
	* @return the built
	*/
	public String getBuilt() {
	 return built;
	}

	/**
   	* @param built the built to set
	*/
	public void setBuilt(String built ) {
		 try{
			 if(built != ""){
				 this.built = built;	 
			 }else{
				 this.built = null;
			 }
		  }catch(Exception ex){
				ex.printStackTrace();
		  }
		 
	}

	/**
	* @return the renovated
	*/
	public String getRenovated() {
	 return renovated;
	}

	/**
   	* @param renovated the renovated to set
	*/
	public void setRenovated(String renovated ) {
		try{
			if(renovated != ""){
				this.renovated = renovated;	 
			 }else{
				 this.renovated = null;
			 }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	* @return the specialty
	*/
	public BigInteger getSpecialty() {
	 return specialty;
	}

	/**
   	* @param specialty the specialty to set
	*/
	public void setSpecialty(BigInteger specialty ) {
	 this.specialty = specialty;
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
	* @return the active
	*/
	public Boolean getActive() {
	 return active;
	}

	/**
   	* @param active the active to set
	*/
	public void setActive(Boolean active ) {
	 this.active = active;
	}
}