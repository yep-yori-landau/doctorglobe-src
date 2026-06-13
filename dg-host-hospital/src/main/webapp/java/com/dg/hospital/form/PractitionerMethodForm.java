package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.form.PractitionerMethodFormModel;

public class PractitionerMethodForm{
	
	private BigInteger healthcareprovider;
	
	private BigInteger practitioner;
	
	private BigInteger specialty;
	
	private BigInteger treatment;
	
	private List<PractitionerMethodFormModel> practitionerMethodFormModel;
	
	public BigInteger getHealthcareprovider(){
		return healthcareprovider;
	}
	
	public void setHealthcareprovider(BigInteger healthcareprovider){
		this.healthcareprovider = healthcareprovider;
	}
	
	public BigInteger getPractitioner(){
		return practitioner;
	}
	
	public void setPractitioner(BigInteger practitioner){
		this.practitioner = practitioner;
	}
	
	public BigInteger getSpecialty(){
		return specialty;
	}
	
	public void setSpecialty(BigInteger specialty){
		this.specialty = specialty;
	}
	
	public BigInteger getTreatment(){
		return treatment;
	}
	
	public void setTreatment(BigInteger treatment){
		this.treatment = treatment;
	}
	
	public List<PractitionerMethodFormModel> getPractitionerMethodFormModel(){
		return practitionerMethodFormModel;
	}
	
	public void setPractitionerMethodFormModel(List<PractitionerMethodFormModel> practitionerMethodFormModel){
		this.practitionerMethodFormModel = practitionerMethodFormModel;
	}
}