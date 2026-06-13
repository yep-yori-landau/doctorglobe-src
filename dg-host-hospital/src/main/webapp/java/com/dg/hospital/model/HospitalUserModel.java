package com.dg.hospital.model;

import java.math.BigInteger;

public class HospitalUserModel{
	
	private BigInteger id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String password;
	
	private BigInteger healthcareprovider;
	
	//private String healthcareprovider_name;
	
	public BigInteger getId(){
		return id;
	}
	
	public void setId(BigInteger id){
		this.id = id;
	}
	
	public String getFirstName(){
		return first_name;
	}
	
	public void setFirstName(String first_name){
		this.first_name = first_name;
	}
	
	public String getLastName(){
		return last_name;
	}
	
	public void setLastName(String last_name){
		this.last_name = last_name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public BigInteger getHealthcareprovider(){
		return healthcareprovider;
	}
	
	public void setHealthcareprovider(BigInteger healthcareprovider){
		this.healthcareprovider = healthcareprovider;
	}
	
	/*public String getHealthcareproviderName(){
		return healthcareprovider_name;
	}
	
	public void setHealthcareproviderName(String healthcareprovider_name){
		this.healthcareprovider_name = healthcareprovider_name;
	}*/
	
}