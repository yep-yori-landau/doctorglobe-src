package com.dg.doctor.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatientConferenceForm{
	
	private BigInteger id;

	@NotNull
	private String conference_dt;

	@NotNull
	private String status;

	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;	
	
	private String timezone;
	
	@NotNull
	private BigInteger receiver;
	
	@NotNull 
	@Size(min = 1, max = 255) 
	private String subject;

	@NotNull  
	private String body;
	
	@NotNull
	private BigInteger patientcase;
	
	@NotNull
	private String time;
	
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
	 * 
	 * @return receiver
	 */
	public BigInteger getReceiver(){
		return receiver;
	}
	
	/**
	 * 
	 * @param receiver
	 */
	public void setReceiver(BigInteger receiver){
		this.receiver = receiver;
	}
	
	/**
	 * 
	 * @return subject
	 */
	public String getSubject(){
		return subject;
	}
	
	/**
	 * 
	 * @param subject
	 */
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	/**
	 * 
	 * @return body
	 */
	public String getBody(){
		return body;
	}
	
	/**
	 * 
	 * @param body
	 */
	public void setBody(String body){
		this.body = body;
	}
	
	/**
	 * 
	 * @return patientcase
	 */
	public BigInteger getPatientcase(){
		return patientcase;
	}
	
	/**
	 * 
	 * @param patientcase
	 */
	public void setPatientcase(BigInteger patientcase){
		this.patientcase = patientcase;
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
	
	/**
	 * 
	 * @return time
	 */
	public String getTime(){
		return time;
	}
	
	/**
	 * 
	 * @param time
	 */
	public void setTime(String time){
		this.time = time;
	}
}