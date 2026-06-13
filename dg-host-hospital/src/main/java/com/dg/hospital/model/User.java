package com.dg.hospital.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class User {
    
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String first_name;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String last_name;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String mobile;

	@NotNull 
	@Size(min = 1, max = 255) 
	@Email
	private String email;

	@NotNull 
	@Size(min = 6, max = 32) 
	private String password;

	@NotNull	 
	private Boolean active;

	@NotNull  
	private BigInteger role;

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
	* @return the password
	*/
	public String getPassword() {
	 return password;
	}

	/**
   	* @param password the password to set
	*/
	public void setPassword(String password ) {
	 this.password = password;
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
	* @return the role
	*/
	public BigInteger getRole() {
	 return role;
	}

	/**
   	* @param role the role to set
	*/
	public void setRole(BigInteger role ) {
	 this.role = role;
	}      
}