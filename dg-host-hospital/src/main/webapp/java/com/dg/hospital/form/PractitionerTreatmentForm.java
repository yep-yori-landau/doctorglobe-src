package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

public class PractitionerTreatmentForm{
	
	private BigInteger healthcareprovider;
	
	private BigInteger practitioner;
	
	private BigInteger practitioner_specialty;
	
	private List<BigInteger> treatments;
	
	private List<BigInteger> selected_treatment;
	
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
	
	public BigInteger getPractitionerSpecialty(){
		return practitioner_specialty;
	}
	
	public void setPractitionerSpecialty(BigInteger practitioner_specialty){
		this.practitioner_specialty = practitioner_specialty;
	}
	
	public List<BigInteger> getTreatments(){
		return treatments;
	}
	
	public void setTreatments(List<BigInteger> treatments){
		this.treatments = treatments;
	}
	
	public List<BigInteger> getSelectedTreatment(){
		return selected_treatment;
	}
	
	public void setSelectedTreatment(List<BigInteger> selected_treatment){
		this.selected_treatment = selected_treatment;
	}
	
}