package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class SpecialtyTreatmentModel{
	
	private BigInteger id;

	@NotNull  
	private BigInteger treatment;

	@NotNull  
	private BigInteger specialty;

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
}