package com.dg.hospital.form;

import java.util.List;

import com.dg.hospital.model.form.HospitalAmenityFormModel;
import com.dg.hospital.model.form.HospitalCuisineFormModel;
import com.dg.hospital.model.form.HospitalLanguageFormModel;

public class HospitalityForm{
	
	private List<HospitalAmenityFormModel> hospitalAmenityFormModel;
	
	private List<HospitalLanguageFormModel> hospitalLanguageFormModel;
	
	private List<HospitalCuisineFormModel> hospitalCuisineFormModel;
	
	public List<HospitalAmenityFormModel> getHospitalAmenityFormModel(){
		return hospitalAmenityFormModel;
	}
	
	public void setHospitalAmenityFormModel(List<HospitalAmenityFormModel> hospitalAmenityFormModel){
		this.hospitalAmenityFormModel = hospitalAmenityFormModel;
	}
	
	public List<HospitalLanguageFormModel> getHospitalLanguageFormModel(){
		return hospitalLanguageFormModel;
	}
	
	public void setHospitalLanguageFormModel(List<HospitalLanguageFormModel> hospitalLanguageFormModel){
		this.hospitalLanguageFormModel = hospitalLanguageFormModel;
	}
	
	public List<HospitalCuisineFormModel> getHospitalCuisineFormModel(){
		return hospitalCuisineFormModel;
	}
	
	public void setHospitalCuisineFormModel(List<HospitalCuisineFormModel> hospitalCuisineFormModel){
		this.hospitalCuisineFormModel = hospitalCuisineFormModel;
	}	
	
}