package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.HospitalSpecialtyModel;

public class HospitalSpecialtyTreatmentForm{	
	
	private HospitalSpecialtyModel hospitalSpecialtyModel;
	
	private List<BigInteger> specialty_treatment;
	
	private List<BigInteger> selected_treatment;
	
	public HospitalSpecialtyModel getHospitalSpecialtyModel(){
		return hospitalSpecialtyModel;
	}
	
	public void setHospitalSpecialtyModel(HospitalSpecialtyModel hospitalSpecialtyModel){
		this.hospitalSpecialtyModel = hospitalSpecialtyModel;
	}
	
	public List<BigInteger> getSpecialtyTreatment(){
		return specialty_treatment;
	}
	
	public void setSpecialtyTreatment(List<BigInteger> specialty_treatment){
		this.specialty_treatment = specialty_treatment;
	}
	
	public List<BigInteger> getSelectedTreatment(){
		return selected_treatment;
	}
	
	public void setSelectedTreatment(List<BigInteger> selected_treatment){
		this.selected_treatment = selected_treatment;
	}
	
}