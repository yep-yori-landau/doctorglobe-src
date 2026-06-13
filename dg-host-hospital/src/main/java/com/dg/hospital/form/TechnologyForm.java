package com.dg.hospital.form;

import java.util.List;

import com.dg.hospital.model.HospitalEquipmentModel;

public class TechnologyForm{
	
	private List<HospitalEquipmentModel> hospitalEquipmentModel;
	
	public List<HospitalEquipmentModel> getHospitalEquipmentModel(){
		return hospitalEquipmentModel;
	}
	
	public void setHospitalEquipmentModel(List<HospitalEquipmentModel> hospitalEquipmentModel){
		this.hospitalEquipmentModel = hospitalEquipmentModel;
	}
}