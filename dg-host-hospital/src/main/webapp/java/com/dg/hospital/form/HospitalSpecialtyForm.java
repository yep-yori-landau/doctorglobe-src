package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.SpecialtyModel;

public class HospitalSpecialtyForm{
	
	private BigInteger healthcareprovider;
	
	private List<BigInteger> specialtyModel;
	
	private List<BigInteger> hospitalSpecialty;
	
	public BigInteger getHealthcareprovider(){
		return healthcareprovider;
	}
	
	public void setHealthcareprovider(BigInteger healthcareprovider){
		this.healthcareprovider = healthcareprovider;
	}
	
	public List<BigInteger> getSpecialtyModel(){
		return specialtyModel;
	}
	
	public void setSpecialtyModel(List<BigInteger> specialtyModel){
		this.specialtyModel = specialtyModel;
	}
	
	public List<BigInteger> getHospitalSpecialty(){
		return hospitalSpecialty;
	}
	
	public void setHospitalSpecialty(List<BigInteger> hospitalSpecialty){
		this.hospitalSpecialty = hospitalSpecialty;
	}	
	
}