package com.dg.hospital.form;

import java.util.List;

import com.dg.hospital.model.HospitalModel;
import com.dg.hospital.model.form.HospitalAccreditationFormModel;
import com.dg.hospital.model.form.HospitalUnitFeatureFormModel;
import com.dg.hospital.model.form.HospitaltypeFormModel;

public class FacilityForm {
	
	public HospitalModel hospitalModel;
	
	public List<HospitalAccreditationFormModel> hospitalAccreditationFormModel;
	
	public List<HospitaltypeFormModel> hospitaltypeFormModel;
	
	public List<HospitalUnitFeatureFormModel> hospitalUnitFeatureFormModel;
	
	public HospitalModel getHospitalModel(){
		return hospitalModel;
	}
	
	public void setHospitalModel(HospitalModel hospitalModel){
		this.hospitalModel = hospitalModel;
	}	
	
	public List<HospitalAccreditationFormModel> getHospitalAccreditationFormModel(){
		return hospitalAccreditationFormModel;
	}
	
	public void setHospitalAccreditationFormModel(List<HospitalAccreditationFormModel> hospitalAccreditationFormModel){		
		this.hospitalAccreditationFormModel = hospitalAccreditationFormModel;
	}
	
	public List<HospitaltypeFormModel> getHospitaltypeFormModel(){
		return hospitaltypeFormModel;
	}
	
	public void setHospitaltypeFormModel(List<HospitaltypeFormModel> hospitaltypeFormModel){		
		this.hospitaltypeFormModel = hospitaltypeFormModel;
	}
	
	public List<HospitalUnitFeatureFormModel> getHospitalUnitFeatureFormModel(){
		return hospitalUnitFeatureFormModel;
	}
	
	public void setHospitalUnitFeatureFormModel(List<HospitalUnitFeatureFormModel> hospitalUnitFeatureFormModel){		
		this.hospitalUnitFeatureFormModel = hospitalUnitFeatureFormModel;
	}
	
}