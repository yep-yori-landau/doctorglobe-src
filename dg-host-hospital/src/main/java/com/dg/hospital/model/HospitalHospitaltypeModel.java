package com.dg.hospital.model;

import java.math.BigInteger;

public class HospitalHospitaltypeModel{
	
	private BigInteger id;

	private BigInteger healthcareprovidertype;	

	private BigInteger healthcareprovider;
	
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
}