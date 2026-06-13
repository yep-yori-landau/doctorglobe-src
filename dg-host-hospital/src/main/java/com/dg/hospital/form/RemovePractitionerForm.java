package com.dg.hospital.form;

import java.math.BigInteger;

public class RemovePractitionerForm{
	
	private BigInteger id;
	
	private BigInteger healthcareprovider;
	
	public BigInteger getId(){
		return id;
	}
	
	public void setId(BigInteger id){
		this.id = id;
	}
	
	public BigInteger getHealthcareprovider(){
		return healthcareprovider;
	}
	
	public void setHealthcareprovider(BigInteger healthcareprovider){
		this.healthcareprovider = healthcareprovider;
	}
	
}