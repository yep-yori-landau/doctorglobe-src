package com.dg.hospital.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.dg.hospital.model.form.HospitalInsuranceFormModel;

public class InsuranceForm{

	@NotNull
	private List<HospitalInsuranceFormModel> hospitalInsuranceFormModel;		
	
	public List<HospitalInsuranceFormModel> getHospitalInsuranceFormModel(){
		return hospitalInsuranceFormModel;
	}
	
	public void setHospitalInsuranceFormModel(List<HospitalInsuranceFormModel> hospitalInsuranceFormModel){
		this.hospitalInsuranceFormModel = hospitalInsuranceFormModel;
	}	
}