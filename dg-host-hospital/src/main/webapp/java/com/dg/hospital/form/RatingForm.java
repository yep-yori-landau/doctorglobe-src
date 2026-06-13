package com.dg.hospital.form;

import java.util.List;

import com.dg.hospital.model.HospitalRatingsModel;

public class RatingForm{
	
	private List<HospitalRatingsModel> hospitalRatingsModel;
	
	public List<HospitalRatingsModel> getHospitalRatingsModel(){
		return hospitalRatingsModel;
	}
	
	public void setHospitalRatingsModel(List<HospitalRatingsModel> hospitalRatingsModel){
		this.hospitalRatingsModel = hospitalRatingsModel;
	}
}