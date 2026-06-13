package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class HospitalRatingsModel{
	
	private BigInteger id;

	@NotNull  
	private Integer score;

	@NotNull  
	private BigInteger ratingcompany;
  
	private BigInteger healthcareprovider;

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
	* @return the score
	*/
	public Integer getScore() {
	 return score;
	}

	/**
   	* @param score the score to set
	*/
	public void setScore(Integer score ) {
	 this.score = score;
	}

	/**
	* @return the ratingcompany
	*/
	public BigInteger getRatingcompany() {
	 return ratingcompany;
	}

	/**
   	* @param ratingcompany the ratingcompany to set
	*/
	public void setRatingcompany(BigInteger ratingcompany ) {
	 this.ratingcompany = ratingcompany;
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
}