package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

public class HospitalSpecialtyTreatmentMethodPractitionerForm{
	
	private BigInteger specialty;
	
	private BigInteger treatment;
	
	private BigInteger method;
	
	private BigInteger healthcareprovider_specialty;
	
	private BigInteger healthcareprovider_specialty_treatment_method;
	
	private List<BigInteger> practitioner;
	
	private List<BigInteger> selected_practitioner;
	
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
	
	public BigInteger getHealthcareproviderSpecialty(){
		return healthcareprovider_specialty;
	}
	
	public void setHealthcareproviderSpecialty(BigInteger healthcareprovider_specialty){
		this.healthcareprovider_specialty = healthcareprovider_specialty;
	}
	
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethod(){
		return healthcareprovider_specialty_treatment_method;
	}
	
	public void setHealthcareproviderSpecialtyTreatmentMethod(BigInteger healthcareprovider_specialty_treatment_method){
		this.healthcareprovider_specialty_treatment_method = healthcareprovider_specialty_treatment_method;
	}
	
	public List<BigInteger> getPractitioner(){
		return practitioner;
	}
	
	public void setPractitioner(List<BigInteger> pracitioner){
		this.practitioner = pracitioner;
	}
	
	public List<BigInteger> getSelectedPractitioner(){
		return selected_practitioner;
	}
	
	public void setSelectedPractitioner(List<BigInteger> selected_pracitioner){
		this.selected_practitioner = selected_pracitioner;
	}
	
}