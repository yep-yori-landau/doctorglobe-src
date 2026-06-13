package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;

import com.dg.hospital.model.EquipmentModel;

public class HospitalTechnologyForm{
	
	private BigInteger healthcareprovider;
	
	private List<BigInteger> equipment;
	
	private List<BigInteger> hospitalEquipment;
	
	public BigInteger getHealthcareprovider(){
		return healthcareprovider;
	}
	
	public void setHealthcareprovider(BigInteger healthcareprovider){
		this.healthcareprovider = healthcareprovider;
	}
	
	public List<BigInteger> getEquipment(){
		return equipment;
	}
	
	public void setEquipment(List<BigInteger> equipment){
		this.equipment = equipment;
	}
	
	public List<BigInteger> getHospitalEquipment(){
		return hospitalEquipment;
	}
	
	public void setHospitalEquipment(List<BigInteger> hospitalEquipment){
		this.hospitalEquipment = hospitalEquipment;
	}
}