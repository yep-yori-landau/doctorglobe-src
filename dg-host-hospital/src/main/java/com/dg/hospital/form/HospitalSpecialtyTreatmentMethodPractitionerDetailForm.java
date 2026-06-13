package com.dg.hospital.form;

import java.math.BigInteger;

import com.dg.hospital.model.HospitalSpecialtyTreatmentMethodPractitionerModel;

public class HospitalSpecialtyTreatmentMethodPractitionerDetailForm{	
	
	private BigInteger treatment;
	
	private BigInteger method;
	
	private BigInteger specialty;
	
	private HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel;	
       	
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
	
	public HospitalSpecialtyTreatmentMethodPractitionerModel getHstmpModel(){
		return hstmpModel;
	}
	
	public void setHstmpModel(HospitalSpecialtyTreatmentMethodPractitionerModel hstmpModel){
		this.hstmpModel = hstmpModel;
	}	
}