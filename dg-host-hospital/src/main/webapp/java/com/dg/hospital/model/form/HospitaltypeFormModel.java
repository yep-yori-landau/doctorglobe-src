package com.dg.hospital.model.form;

import java.math.BigInteger;

public class HospitaltypeFormModel {

	private BigInteger id;

	private BigInteger healthcareprovidertype;	

	private BigInteger healthcareprovider;
	
	private Boolean is_checked;
	
	private String name;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the healthcareprovidertype
	 */
	public BigInteger getHealthcareprovidertype() {
		return healthcareprovidertype;
	}

	/**
	 * @param healthcareprovidertype
	 * the healthcareprovidertype to set
	 */
	public void setHealthcareprovidertype(BigInteger healthcareprovidertype) {
		this.healthcareprovidertype = healthcareprovidertype;
	}
	
	/**
	 * @return the healthcareprovider
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * @param healthcareprovider
	 *            the healthcareprovidertype to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public Boolean getIsChecked(){
		return is_checked;
	}
	
	/**
	 * 
	 * @param is_checked the is_chekced to set
	 */
	public void setIsChecked(Boolean is_checked){
		this.is_checked = is_checked;
	}
	
	/**
	 * 
	 * @return amenity name
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