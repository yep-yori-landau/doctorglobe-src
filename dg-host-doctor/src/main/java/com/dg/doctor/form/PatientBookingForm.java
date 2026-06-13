package com.dg.doctor.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatientBookingForm{
	
	private BigInteger id;

	@NotNull
	private String booking_dt;
	
	@NotNull
	private String time;

	@NotNull
	private String status;

	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;
	
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
	* @return the booking_dt
	*/
	public String getBookingDt() {
	 return booking_dt;
	}

	/**
   	* @param booking_dt the booking_dt to set
	*/
	public void setBookingDt(String booking_dt ) {
	 this.booking_dt = booking_dt;
	}
	
	/**
	* @return the time
	*/
	public String getTime() {
	 return time;
	}

	/**
   	* @param time the time to set
	*/
	public void setTime(String time ) {
	 this.time = time;
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

	
	@NotNull
	private BigInteger receiver;
	
	@NotNull 
	@Size(min = 1, max = 255) 
	private String subject;

	@NotNull  
	private String body;
	
	@NotNull
	private BigInteger patientcase;
	
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
}