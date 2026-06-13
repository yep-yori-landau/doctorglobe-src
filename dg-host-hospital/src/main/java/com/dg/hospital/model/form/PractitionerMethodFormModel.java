package com.dg.hospital.model.form;

import java.math.BigInteger;

public class PractitionerMethodFormModel{
	
	private BigInteger method;
	
	private BigInteger hstm_id;
	
	private BigInteger hstmp_id;
	
	private Integer years_practiced;
	  
	private Integer number_performed_overall;
  
	private Integer number_performed_last_year;
  
	private Integer corrections_last_year;
  
	private Integer availability_days;
	 
	private String currency;	
	
	private Double healthcareprovider_price;
	  
	private Double practitioner_price;
	  
	private Double anesthesia_price;
	
	public BigInteger getMethod(){
		return method;
	}
	
	public void setMethod(BigInteger method){
		this.method = method;
	}
	
	public BigInteger getHstmId(){
		return hstm_id;
	}
	
	public void setHstmId(BigInteger hstm_id){
		this.hstm_id = hstm_id;
	}
	
	public BigInteger getHstmpId(){
		return hstmp_id;
	}
	
	public void setHstmpId(BigInteger hstmp_id){
		this.hstmp_id = hstmp_id;
	}
	
	/**
	* @return the years_practiced
	*/
	public Integer getYearsPracticed() {
	 return years_practiced;
	}

	/**
   	* @param years_practiced the years_practiced to set
	*/
	public void setYearsPracticed(Integer years_practiced ) {
	 this.years_practiced = years_practiced;
	}

	/**
	* @return the number_performed_overall
	*/
	public Integer getNumberPerformedOverall() {
	 return number_performed_overall;
	}

	/**
   	* @param number_performed_overall the number_performed_overall to set
	*/
	public void setNumberPerformedOverall(Integer number_performed_overall ) {
	 this.number_performed_overall = number_performed_overall;
	}

	/**
	* @return the number_performed_last_year
	*/
	public Integer getNumberPerformedLastYear() {
	 return number_performed_last_year;
	}

	/**
   	* @param number_performed_last_year the number_performed_last_year to set
	*/
	public void setNumberPerformedLastYear(Integer number_performed_last_year ) {
	 this.number_performed_last_year = number_performed_last_year;
	}

	/**
	* @return the corrections_last_year
	*/
	public Integer getCorrectionsLastYear() {
	 return corrections_last_year;
	}

	/**
   	* @param corrections_last_year the corrections_last_year to set
	*/
	public void setCorrectionsLastYear(Integer corrections_last_year ) {
	 this.corrections_last_year = corrections_last_year;
	}

	/**
	* @return the availability_days
	*/
	public Integer getAvailabilityDays() {
	 return availability_days;
	}

	/**
   	* @param availability_days the availability_days to set
	*/
	public void setAvailabilityDays(Integer availability_days ) {
	 this.availability_days = availability_days;
	}

	/**
	* @return the currency
	*/
	public String getCurrency() {
	 return currency;
	}

	/**
   	* @param currency the currency to set
	*/
	public void setCurrency(String currency ) {
	 this.currency = currency;
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

	/**
	* @return the practitioner_price
	*/
	public Double getPractitionerPrice() {
	 return practitioner_price;
	}

	/**
   	* @param practitioner_price the practitioner_price to set
	*/
	public void setPractitionerPrice(Double practitioner_price ) {
		if(practitioner_price != null){
			this.practitioner_price = practitioner_price;
		}else{
			this.practitioner_price = 0.0;
		}
	}

	/**
	* @return the anesthesia_price
	*/
	public Double getAnesthesiaPrice() {
	 return anesthesia_price;
	}

	/**
   	* @param anesthesia_price the anesthesia_price to set
	*/
	public void setAnesthesiaPrice(Double anesthesia_price ) {
		if(anesthesia_price != null ){
			this.anesthesia_price = anesthesia_price;
		}else{
			this.anesthesia_price = 0.0;
		}	
	}
	
}