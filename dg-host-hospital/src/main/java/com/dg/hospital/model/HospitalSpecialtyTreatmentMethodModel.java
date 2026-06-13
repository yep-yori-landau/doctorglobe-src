package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalSpecialtyTreatmentMethodModel{
	
private BigInteger id;
	
	private Boolean active;

	@NotNull  
	private BigInteger treatment;

	@NotNull  
	private BigInteger method;
  
	private BigInteger healthcareprovider_specialty;
	
	@NotNull
	private Double healthcareprovider_price;

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

	/**
	* @return the treatment
	*/
	public BigInteger getTreatment() {
	 return treatment;
	}

	/**
   	* @param treatment the treatment to set
	*/
	public void setTreatment(BigInteger treatment ) {
	 this.treatment = treatment;
	}

	/**
	* @return the method
	*/
	public BigInteger getMethod() {
	 return method;
	}

	/**
   	* @param method the method to set
	*/
	public void setMethod(BigInteger method ) {
	 this.method = method;
	}

	/**
	* @return the healthcareprovider_specialty
	*/
	public BigInteger getHealthcareproviderSpecialty() {
	 return healthcareprovider_specialty;
	}

	/**
   	* @param healthcareprovider_specialty the healthcareprovider_specialty to set
	*/
	public void setHealthcareproviderSpecialty(BigInteger healthcareprovider_specialty ) {
	 this.healthcareprovider_specialty = healthcareprovider_specialty;
	}
	
	/**
	* @return the healthcareprovider_price
	*/
	public Double getHealthcareproviderPrice() {
	 return healthcareprovider_price;
	}

	/**
   	* @param healthcareprovider_price the healthcareprovider_price to set
	*/
	public void setHealthcareproviderPrice(Double healthcareprovider_price ) {
		if(healthcareprovider_price != null){
			this.healthcareprovider_price = healthcareprovider_price;
		}else{
			this.healthcareprovider_price = 0.0;
		}
	}
}