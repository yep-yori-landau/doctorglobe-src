package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.PractitionerModel;

public class PractitionerSpecialtyForm{
	
	private PractitionerModel practitionerModel;
	
	private BigInteger healthcareprovider;
	
	private List<BigInteger> specialtyModel;
	
	private List<BigInteger> practitionerSpecialty;
	
	public PractitionerModel getPractitionerModel(){
		return practitionerModel;
	}
	
	public void setPractitionerModel(PractitionerModel practitionerModel){
		this.practitionerModel = practitionerModel;
	}
	
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
	
	public List<BigInteger> getPractitionerSpecialty(){
		return practitionerSpecialty;
	}
	
	public void setPractitionerSpecialty(List<BigInteger> practitionerSpecialty){
		this.practitionerSpecialty = practitionerSpecialty;
	}
	
}