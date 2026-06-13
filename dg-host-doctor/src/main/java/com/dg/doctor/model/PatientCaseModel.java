package com.dg.doctor.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author kkowlgi
 * 
 */
public class PatientCaseModel {
        
	private Integer id;
	
	@Size(min = 1, max = 255)
	private String description;

	@NotNull	
	private String status;
	
	@NotNull
	private Integer treatment;

	@NotNull
	private Integer patient;
	
	private String treatment_name;
	
	private String patient_name;

        /**
	* @return the id
	*/
	public Integer getId() {
	 return id;
	}

	/**
   	* @param id the id to set
	*/
	public void setId(Integer id ) {
	 this.id = id;
	}

	/**
	* @return the description
	*/
	public String getDescription() {
	 return description;
	}

	/**
   	* @param description the description to set
	*/
	public void setDescription(String description ) {
	 this.description = description;
	}

	/**
	* @return the status
	*/
	public String getStatus() {
	 return status;
	}

	/**
   	* @param status the status to set
	*/
	public void setStatus(String status ) {
	 this.status = status;
	}

	/**
	* @return the treatment
	*/
	public Integer getTreatment() {
	 return treatment;
	}

	/**
   	* @param treatment the treatment to set
	*/
	public void setTreatment(Integer treatment ) {
	 this.treatment = treatment;
	}

	/**
	* @return the patient
	*/
	public Integer getPatient() {
	 return patient;
	}

	/**
   	* @param patient the patient to set
	*/
	public void setPatient(Integer patient ) {
	 this.patient = patient;
	}

	/**
	* @return the treatment_name
	*/
	public String getTreatmentName() {
	 return treatment_name;
	}

	/**
   	* @param treatment_name the treatment_name to set
	*/
	public void setTreatmentName(String treatment_name ) {
	 this.treatment_name = treatment_name;
	}

	/**
	* @return the patient_name
	*/
	public String getPatientName() {
	 return patient_name;
	}

	/**
   	* @param patient_name the patient_name to set
	*/
	public void setPatientName(String patient_name ) {
	 this.patient_name = patient_name;
	}
      
}