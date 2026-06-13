package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.form.*;

public class PractitionerStatsForm{
	
	private BigInteger healthcareprovider;
	
	private BigInteger practitioner;
	
	private BigInteger specialty;
	
	private BigInteger treatment;
	
	private BigInteger method;
	
	private List<PractitionerStatsFormModel> practitionerStatsFormModel;
	
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
	
	public BigInteger getMethod(){
		return method;
	}
	
	public void setMethod(BigInteger method){
		this.method = method;
	}
	
	public List<PractitionerStatsFormModel> getPractitionerStatsFormModel(){
		return practitionerStatsFormModel;
	}
	
	public void setPractitionerStatsFormModel(List<PractitionerStatsFormModel> practitionerStatsFormModel){
		this.practitionerStatsFormModel = practitionerStatsFormModel;
	}

}