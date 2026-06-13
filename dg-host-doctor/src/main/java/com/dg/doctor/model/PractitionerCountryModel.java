package com.dg.doctor.model;

/**
 * @author kkowlgi
 * 
 */

public class PractitionerCountryModel {

	private String country;
	
	private String country_code;
	
	private String city;	
	
	private String state;
	
	public String getCountry(){
		return country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public String getCountryCode(){
		return country_code;
	}
	
	public void setCountryCode(String country_code){
		this.country_code = country_code;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state = state;
	}	
}