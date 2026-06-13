/**
 * 
 */
package com.dg.doctor.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author kkowlgi
 * 
 */

public class PatientDetailModel {

	private BigInteger id;

	@NotNull
	@Size(min = 3, max = 255)
	private String name;

	@NotNull
	private String age;

	@NotNull
	private String gender;	

	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;	
	
	private String phone;
	
	private String city;
	
	private String country;
	
	private String country_code;
	
	private String address;	
	
	private String photo;
	
	private String zip_code;
	
    private BigInteger patientcase_id;
	
	@Size(min = 1, max = 255)
	private String description;

	@NotNull	
	private String status;
	
	@NotNull
	private BigInteger treatment;	
	
	private String treatment_name;
	
	private BigInteger patientcasefile_id;
	
	private String file_description;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String file_type;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String file_name;
	
	private String doc_name;
  
	private Timestamp file_dt;
	
	private BigInteger patientconference_id;

	private Timestamp conference_dt;

	private String patientconference_status;

	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;
	
	private Integer week_call;

	private BigInteger pcm_id;
	
	private Integer sender;
	
	private Integer receiver;
	
	private String subject;
	
	private String message;
	
	private String pcm_status;
	
	private String sender_type;
	
	private Timestamp sent_dt;
	
	private BigInteger booking_id;
	
	private Timestamp booking_dt;	
	
	private Integer total_files;
	
	private Integer total_messages;	
	
	private Integer new_messages;
	
	private String pcm_class;
	
	private BigInteger practitioner;
	
	private String booking_status;
	
	private String booking_timezone;
	
	private String conference_timezone;
	
	private String patient_timezone;
	
	private String patient_conference_date;
	
	private String patient_conference_time;
	
	private String patient_booking_date;
	
	private String patient_booking_time;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return the country_code
	 */
	public String getCountryCode() {
		return country_code;
	}

	/**
	 * @param country_code
	 *            the country_code to set
	 */
	public void setCountryCode(String country_code) {
		this.country_code = country_code;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the zip_code
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * @param zip_code
	 *            the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}
	
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
    /**
	* @return the patientcase_id
	*/
	public BigInteger getPatientcaseId() {
	 return patientcase_id;
	}

	/**
  	* @param patientcase_id the patientcase_id to set
	*/
	public void setPatientcaseId(BigInteger patientcase_id ) {
	 this.patientcase_id = patientcase_id;
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
	public BigInteger getTreatment() {
	 return treatment;
	}

	/**
  	* @param treatment the treatment to set
	*/
	public void setTreatment(BigInteger treatment ) {
	 this.treatment = treatment;
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
	* @return the patientcasefile_id
	*/
	public BigInteger getPatientcasefileId() {
	 return patientcasefile_id;
	}

	/**
  	* @param patientcasefile_id the patientcasefile_id to set
	*/
	public void setPatientcasefileId(BigInteger patientcasefile_id ) {
	 this.patientcasefile_id = patientcasefile_id;
	}
	
	/**
	* @return the file_description
	*/
	public String getFileDescription() {
	 return file_description;
	}

	/**
  	* @param file_description the file_description to set
	*/
	public void setFileDescription(String file_description ) {
	 this.file_description = file_description;
	}
	
	/**
	* @return the file_type
	*/
	public String getFileType() {
	 return file_type;
	}

	/**
   	* @param file_type the file_type to set
	*/
	public void setFileType(String file_type ) {
	 this.file_type = file_type;
	}

	/**
	* @return the file_name
	*/
	public String getFileName() {
	 return file_name;
	}

	/**
   	* @param file_name the file_name to set
	*/
	public void setFileName(String file_name ) {
	 this.file_name = file_name;
	}
	
	/**
	* @return the doc_name
	*/
	public String getDocName() {
	 return doc_name;
	}

	/**
   	* @param doc_name the doc_name to set
	*/
	public void setDocName(String doc_name ) {
	 this.doc_name = doc_name;
	}

	/**
	* @return the file_dt
	*/
	public Timestamp getFileDt() {
	 return file_dt;
	}

	/**
   	* @param file_dt the file_dt to set
	*/
	public void setFileDt(Timestamp file_dt ) {
	 this.file_dt = file_dt;
	}
	
    /**
	* @return the patientconference_id
	*/
	public BigInteger getPatientconferenceId() {
	 return patientconference_id;
	}

	/**
  	* @param id the id to set
	*/
	public void setPatientconferenceId(BigInteger patientconference_id ) {
	 this.patientconference_id = patientconference_id;
	}

	/**
	* @return the conference_String
	*/
	public Timestamp getConferenceDt() {
	 return conference_dt;
	}

	/**
  	* @param conference_String the conference_String to set
	*/
	public void setConferenceDt(Timestamp conference_dt ) {
	 this.conference_dt = conference_dt;
	}

	/**
	* @return the patientconference_status
	*/
	public String getPatientconferenceStatus() {
	 return patientconference_status;
	}

	/**
  	* @param status the status to set
	*/
	public void setPatientconferenceStatus(String patientconference_status ) {
	 this.patientconference_status = patientconference_status;
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
	 * @return the week_call
	 */
	public Integer getWeekCall() {
		return week_call;
	}

	/**
	 * @param week_call
	 *            the week_call to set
	 */
	public void setWeekCall(Integer week_call) {
		this.week_call = week_call;
	}	

	
	/**
	 * @return the pcm_id
	 */
	public BigInteger getPcmId() {
		return pcm_id;
	}

	/**
	 * @param pcm_id
	 *            the pcm_id to set
	 */
	public void setPcmId(BigInteger pcm_id) {
		this.pcm_id = pcm_id;
	}
	
	/**
	 * @return the sender
	 */
	public Integer getSender() {
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	
	/**
	 * @return the receiver
	 */
	public Integer getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver
	 *            the receiver to set
	 */
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	/**
	 * 
	 * @return the pcm_status
	 */
	public String getPcmStatus(){
		return pcm_status;
	}
	/**
	 * 
	 * @param pcm_status the pcm_status to set
	 */
	public void setPcmStatus(String pcm_status){
		this.pcm_status = pcm_status;
	}
	/**
	 * 
	 * @return the subject
	 */
	public String getSubject(){
		return subject;
	}
	/**
	 * 
	 * @param subject the subject to set
	 */
	public void setSubject(String subject){
		this.subject = subject;
	}
	/**
	 * 
	 * @return the message
	 */
	public String getMessage(){
		return message;
	}
	/**
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message){
		this.message = message;
	}
	
	/**
	 * 
	 * @return the sender_type
	 */
	public String getSenderType(){
		return sender_type;
	}
	/**
	 * 
	 * @param sender_type the sender_type to set
	 */
	public void setSenderType(String sender_type){
		this.sender_type = sender_type;
	}
	/**
	 * 
	 * @return the sent_dt
	 */
	public Timestamp getSentDt(){
		return sent_dt;
	}
	/**
	 * 
	 * @param sent_dt the sent_dt to set
	 */
	public void setSentDt(Timestamp sent_dt){
		this.sent_dt = sent_dt;
	}	
	
	/**
	 * @return the booking_id
	 */
	public BigInteger getBookingId() {
		return booking_id;
	}

	/**
	 * @param booking_id
	 *            the booking_id to set
	 */
	public void setBookingId(BigInteger booking_id) {
		this.booking_id = booking_id;
	}	
	/**
	 * 
	 * @return the booking_dt
	 */
	public Timestamp getBookingDt(){
		return booking_dt;
	}
	/**
	 * 
	 * @param booking_dt the booking_dt to set
	 */
	public void setBookingDt(Timestamp booking_dt){
		this.booking_dt = booking_dt;
	}	
	/**
	 * 
	 * @return the total_files
	 */
	public Integer getTotalFiles(){
		return total_files;
	}
	/**
	 * 
	 * @param total_files the total_files to set
	 */
	public void setTotalFiles(Integer total_files){
		this.total_files = total_files;
	}	
	/**
	 * 
	 * @return the total_messages
	 */
	public Integer getTotalMessages(){
		return total_messages;
	}
	/**
	 * 
	 * @param total_messages the total_messages to set
	 */
	public void setTotalMessages(Integer total_messages){
		this.total_messages = total_messages;
	}	
	/**
	 * 
	 * @return the new_messages
	 */
	public Integer getNewMessages(){
		return new_messages;
	}
	/**
	 * 
	 * @param new_messages the new_messages to set
	 */
	public void setNewMessages(Integer new_messages){
		this.new_messages = new_messages;
	}	
	
	/**
	 * 
	 * @return the pcm_class
	 */
	public String getPcmClass(){
		return pcm_class;
	}
	/**
	 * 
	 * @param sender_type the sender_type to set
	 */
	public void setPcmClass(String pcm_class){
		this.pcm_class = pcm_class;
	}
	
	/**
	 * @param practitioner
	 *            the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}	
	/**
	 * 
	 * @return the practitioner
	 */
	public BigInteger getPractitioner(){
		return practitioner;
	}
	/**
	 * 
	 * @return the booking_status
	 */
	public String getBookingStatus(){
		return booking_status;
	}
	/**
	 * 
	 * @param booking_status the booking_status to set
	 */
	public void setBookingStatus(String booking_status){
		this.booking_status = booking_status;
	}
	
	/**
	 * 
	 * @return the booking_timezone
	 */
	public String getBookingTimezone(){
		return booking_timezone;
	}
	/**
	 * 
	 * @param booking_timezone the booking_timezone to set
	 */
	public void setBookingTimezone(String booking_timezone){
		this.booking_timezone = booking_timezone;
	}
	/**
	 * 
	 * @return the conference_timezone
	 */
	public String getConferenceTimezone(){
		return conference_timezone;
	}
	/**
	 * 
	 * @param conference_timezone the conference_timezone to set
	 */
	public void setConferenceTimezone(String conference_timezone){
		this.conference_timezone = conference_timezone;
	}
	
	/**
	 * 
	 * @return the patient_timezone
	 */
	public String getPatientTimezone(){
		return patient_timezone;
	}
	/**
	 * 
	 * @param patient_timezone the patient_timezone to set
	 */
	public void setPatientTimezone(String patient_timezone){
		this.patient_timezone = patient_timezone;
	}
	
	/**
	 * 
	 * @return the patient_conference_date
	 */
	public String getPatientConferenceDate(){
		return patient_conference_date;
	}
	/**
	 * 
	 * @param patient_conference_date the patient_conference_date to set
	 */
	public void setPatientConferenceDate(String patient_conference_date){
		this.patient_conference_date = patient_conference_date;
	}
	/**
	 * 
	 * @return the patient_conference_time
	 */
	public String getPatientConferenceTime(){
		return patient_conference_time;
	}
	/**
	 * 
	 * @param patient_conference_time the patient_conference_time to set
	 */
	public void setPatientConferenceTime(String patient_conference_time){
		this.patient_conference_time = patient_conference_time;
	}
	/**
	 * 
	 * @return the patient_booking_date
	 */
	public String getPatientBookingDate(){
		return patient_booking_date;
	}
	/**
	 * 
	 * @param patient_booking_date the patient_booking_date to set
	 */
	public void setPatientBookingDate(String patient_booking_date){
		this.patient_booking_date = patient_booking_date;
	}
	/**
	 * 
	 * @return the patient_booking_time
	 */
	public String getPatientBookingTime(){
		return patient_booking_time;
	}
	/**
	 * 
	 * @param patient_booking_time the patient_booking_time to set
	 */
	public void setPatientBookingTime(String patient_booking_time){
		this.patient_booking_time = patient_booking_time;
	}
}