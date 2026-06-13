package com.dg.hospital.form;

import java.math.BigInteger;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import com.dg.hospital.model.HospitalRatingsModel;

public class RatingForm{	
	
	private List<HospitalRatingsModel> hospitalRatingsModel;
	
	@NotNull	
	private BigInteger healthcareprovider;
	
	@Max(100)
	private Integer readmissionRate;
	
	@Max(100)
	private Integer mortalityRate;
  
	@Max(100)
	private Integer infectionRate; 
	
	private Boolean medicalLawsuit;
	
	/**
	 * @return the healthcareprovider
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * @param healthcareprovider
	 *            the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}
	
	/**
	* @return the readmission_rate
	*/
	public Integer getReadmissionRate() {
	 return readmissionRate;
	}

	/**
   	* @param readmission_rate the readmission_rate to set
	*/
	public void setReadmissionRate(Integer readmissionRate ) {
	 this.readmissionRate = readmissionRate;
	}

	/**
	* @return the mortality_rate
	*/
	public Integer getMortalityRate() {
	 return mortalityRate;
	}

	/**
   	* @param mortality_rate the mortality_rate to set
	*/
	public void setMortalityRate(Integer mortalityRate ) {
	 this.mortalityRate = mortalityRate;
	}

	/**
	* @return the infection_rate
	*/
	public Integer getInfectionRate() {
	 return infectionRate;
	}

	/**
   	* @param infection_rate the infection_rate to set
	*/
	public void setInfectionRate(Integer infectionRate ) {
	 this.infectionRate = infectionRate;
	}

	/**
	* @return the medical_lawsuit
	*/
	public Boolean getMedicalLawsuit() {
	 return medicalLawsuit;
	}

	/**
   	* @param medical_lawsuit the medical_lawsuit to set
	*/
	public void setMedicalLawsuit(Boolean medicalLawsuit ) {
	 this.medicalLawsuit = medicalLawsuit;
	}
	
	public List<HospitalRatingsModel> getHospitalRatingsModel(){
		return hospitalRatingsModel;
	}
	
	public void setHospitalRatingsModel(List<HospitalRatingsModel> hospitalRatingsModel){
		this.hospitalRatingsModel = hospitalRatingsModel;
	}
}