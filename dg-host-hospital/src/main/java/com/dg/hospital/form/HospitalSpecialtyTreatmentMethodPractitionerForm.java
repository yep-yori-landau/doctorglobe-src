package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

public class HospitalSpecialtyTreatmentMethodPractitionerForm{
	
	private BigInteger specialty;
	
	private BigInteger treatment;
	
	private BigInteger method;
	
	private BigInteger healthcareprovider_specialty;
	
	private BigInteger healthcareprovider_specialty_treatment_method;
	
	private BigInteger corporatecompany_insurance;
	
	private List<BigInteger> practitioner;
	
	private List<BigInteger> selected_practitioner;
	
	private Double healthcareprovider_price;
	
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
	
	/**
	* @return the healthcareprovider_price
	*/
	public Double getHealthcareproviderPrice() {
	 return healthcareprovider_price;
	}

	/**
   	* @param healthcareprovider_price the healthcareprovider_price to set
	*/
	public void setHealthcareproviderPrice(Double healthcareprovider_price ) {
	 if(healthcareprovider_price != null){	
		 this.healthcareprovider_price = healthcareprovider_price;
	 }else{
		 this.healthcareprovider_price = 0.0;
	 }	 
	}
	
	/**
	* @return the corporatecompany_insurance
	*/
	public BigInteger getCorporatecompanyInsurance() {
	 return corporatecompany_insurance;
	}

	/**
   	* @param corporatecompany_insurance the corporatecompany_insurance to set
	*/
	public void setCorporatecompanyInsurance(BigInteger corporatecompany_insurance ) {
	 this.corporatecompany_insurance = corporatecompany_insurance;
	}	
	
}