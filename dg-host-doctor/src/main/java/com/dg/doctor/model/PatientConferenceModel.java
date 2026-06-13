/**
 * 
 */
package com.dg.doctor.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;



/**
 * @author kkowlgi
 * 
 */
public class PatientConferenceModel {
        
	private BigInteger id;

	private String conference_dt;

	private String status;

	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	private BigInteger patient_case;
	
	@NotNull
	private String timezone;

        /**
	* @return the id
	*/
	public BigInteger getId() {
	 return id;
	}

	/**
   	* @param id the id to set
	*/
	public void setId(BigInteger id ) {
	 this.id = id;
	}

	/**
	* @return the conference_String
	*/
	public String getConferenceDt() {
	 return conference_dt;
	}

	/**
   	* @param conference_String the conference_String to set
	*/
	public void setConferenceDt(String conference_dt ) {
	 this.conference_dt = conference_dt;
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
	* @return the healthcareprovider_specialty_treatment_method_practitioner
	*/
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
	 return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
   	* @param healthcareprovider_specialty_treatment_method_practitioner the healthcareprovider_specialty_treatment_method_practitioner to set
	*/
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(BigInteger healthcareprovider_specialty_treatment_method_practitioner ) {
	 this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	* @return the patient_case
	*/
	public BigInteger getPatientCase() {
	 return patient_case;
	}

	/**
   	* @param patient_case the patient_case to set
	*/
	public void setPatientCase(BigInteger patient_case ) {
	 this.patient_case = patient_case;
	}      
	
	/**
	 * 
	 * @return timezone
	 */
	public String getTimezone(){
		return timezone;
	}
	
	/**
	 * 
	 * @param timezone
	 */
	public void setTimezone(String timezone){
		this.timezone = timezone;
	}
}
