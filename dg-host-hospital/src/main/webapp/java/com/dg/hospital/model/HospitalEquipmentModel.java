package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalEquipmentModel{
	
	private BigInteger id;
	  
	private String purchase_dt;
  
	private Integer hours_used;
  
	@NotNull
	private BigInteger healthcareprovider;

	@NotNull  
	private BigInteger equipment;

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
	* @return the purchase_dt
	*/
	public String getPurchaseDt() {
	 return purchase_dt;
	}

	/**
   	* @param purchase_dt the purchase_dt to set
	*/
	public void setPurchaseDt(String purchase_dt ) {
		if(purchase_dt != ""){
			this.purchase_dt = purchase_dt;
		}else{
			this.purchase_dt = null;
		}
	}

	/**
	* @return the hours_used
	*/
	public Integer getHoursUsed() {
	 return hours_used;
	}

	/**
   	* @param hours_used the hours_used to set
	*/
	public void setHoursUsed(Integer hours_used ) {
	 this.hours_used = hours_used;
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
	* @return the equipment
	*/
	public BigInteger getEquipment() {
	 return equipment;
	}

	/**
   	* @param equipment the equipment to set
	*/
	public void setEquipment(BigInteger equipment ) {
	 this.equipment = equipment;
	}
}