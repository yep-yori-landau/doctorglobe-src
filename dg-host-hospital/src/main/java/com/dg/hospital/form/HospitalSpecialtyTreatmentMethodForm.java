package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotNull;

public class HospitalSpecialtyTreatmentMethodForm{
	
	private BigInteger healthcareprovider_specialty;
	
	private BigInteger treatment;
	
	private BigInteger specialty;	
	
	private List<BigInteger> method;
	
	private List<BigInteger> treatment_method;	
	
	public BigInteger getHealthcareproviderSpecialty(){
		return healthcareprovider_specialty;		
	}
	
	public void setHealthcareproviderSpecialty(BigInteger healthcareprovider_specialty){
		this.healthcareprovider_specialty = healthcareprovider_specialty;
	}
	
	public BigInteger getTreatment(){
		return treatment;		
	}
	
	public void setTreatment(BigInteger treatment){
		this.treatment = treatment;
	}
	
	public BigInteger getSpecialty(){
		return specialty;		
	}
	
	public void setSpecialty(BigInteger specialty){
		this.specialty = specialty;
	}
	
	public List<BigInteger> getMethod(){
		return method;		
	}
	
	public void setMethod(List<BigInteger> method){
		this.method = method;
	}
	
	public List<BigInteger> getTreatmentMethod(){
		return treatment_method;		
	}
	
	public void setTreatmentMethod(List<BigInteger> treatment_method){
		this.treatment_method = treatment_method;
	}	
}