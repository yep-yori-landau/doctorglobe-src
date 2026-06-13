package com.dg.hospital.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class HospitalPractitionerDetailModel{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 32) 
	private String title;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String first_name;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String last_name;
	
	private String mobile;
	
	@NotNull 
	@Size(min = 1, max = 255) 
	@Email
	private String email;	
	
	@NotNull 
	private String currency;
	
	private BigDecimal insurance_cap;
    
    private String policy_file;
	
	private String description;
	
	@NotNull  
	private BigInteger healthcareprovider;
	
	@NotNull  
	private BigInteger practitioner;
	
	@NotNull  
	private BigInteger type;
	
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
	* @return the title
	*/
	public String getTitle() {
	 return title;
	}

	/**
   	* @param title the title to set
	*/
	public void setTitle(String title ) {
	 this.title = title;
	}

	/**
	* @return the first_name
	*/
	public String getFirstName() {
	 return first_name;
	}

	/**
   	* @param first_name the first_name to set
	*/
	public void setFirstName(String first_name ) {
	 this.first_name = first_name;
	}

	/**
	* @return the last_name
	*/
	public String getLastName() {
	 return last_name;
	}

	/**
   	* @param last_name the last_name to set
	*/
	public void setLastName(String last_name ) {
	 this.last_name = last_name;
	}
	
	/**
	* @return the mobile
	*/
	public String getMobile() {
	 return mobile;
	}

	/**
   	* @param mobile the mobile to set
	*/
	public void setMobile(String mobile ) {
	 this.mobile = mobile;
	}
	
	/**
	* @return the email
	*/
	public String getEmail() {
	 return email;
	}

	/**
   	* @param email the email to set
	*/
	public void setEmail(String email ) {
	 this.email = email;
	}
	
	/**
	* @return the insurance_cap
	*/
	public BigDecimal getInsuranceCap() {
	return insurance_cap;
	}
	
	/**
   	* @param insurance_cap the insurance_cap to set
	*/
	public void setInsuranceCap(BigDecimal insurance_cap ) {
	 this.insurance_cap = insurance_cap;
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
	* @return the policy_file
	*/
	public String getPolicyFile() {
	return policy_file;
	}
	
	/**
   	* @param policy_file the policy_file to set
	*/
	public void setPolicyFile(String policy_file ) {
		this.policy_file = policy_file;
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
	* @return the practitioner
	*/
	public BigInteger getPractitioner() {
	 return practitioner;
	}

	/**
   	* @param practitioner the practitioner to set
	*/
	public void setPractitioner(BigInteger practitioner ) {
	 this.practitioner = practitioner;
	}
	
	/**
	* @return the type
	*/
	public BigInteger getType() {
	 return type;
	}

	/**
   	* @param type the type to set
	*/
	public void setType(BigInteger type ) {
	 this.type = type;
	}
}