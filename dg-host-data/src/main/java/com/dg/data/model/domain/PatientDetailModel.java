package com.dg.data.model.domain;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * PatientDetailModel Domain Model
 * @author DoctorGlobe
 *
 */
public class PatientDetailModel {

	/**
	 * The id of PatientDetailModel
	 */
	private BigInteger id;

	/**
	 * The name of PatientDetailModel
	 */
	@NotNull
	@Size(min = 3, max = 255)
	private String name;

	/**
	 * The age of PatientDetailModel
	 */
	@NotNull
	private String age;

	/**
	 * The gender of PatientDetailModel
	 */
	@NotNull
	private String gender;

	/**
	 * The email of PatientDetailModel
	 */
	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;

	/**
	 * The phone of PatientDetailModel
	 */
	private String phone;

	/**
	 * The city of PatientDetailModel
	 */
	private String city;

	/**
	 * The country of PatientDetailModel
	 */
	private String country;

	/**
	 * The country_code of PatientDetailModel
	 */
	private String country_code;

	/**
	 * The address of PatientDetailModel
	 */
	private String address;

	/**
	 * The photo of PatientDetailModel
	 */
	private String photo;

	/**
	 * The zip_code of PatientDetailModel
	 */
	private String zip_code;

	/**
	 * The patientcase_id of PatientDetailModel
	 */
	private BigInteger patientcase_id;

	/**
	 * The description of PatientDetailModel
	 */
	@Size(min = 1, max = 255)
	private String description;

	/**
	 * The status of PatientDetailModel
	 */
	@NotNull
	private String status;

	/**
	 * The treatment of PatientDetailModel
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The treatment_name of PatientDetailModel
	 */
	private String treatment_name;

	/**
	 * The patientcasefile_id of PatientDetailModel
	 */
	private BigInteger patientcasefile_id;

	/**
	 * The file_description of PatientDetailModel
	 */
	private String file_description;

	/**
	 * The file_type of PatientDetailModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String file_type;

	/**
	 * The file_name of PatientDetailModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String file_name;

	/**
	 * The doc_name of PatientDetailModel
	 */
	private String doc_name;

	/**
	 * The file_dt of PatientDetailModel
	 */
	private Timestamp file_dt;

	/**
	 * The patientconference_id of PatientDetailModel
	 */
	private BigInteger patientconference_id;

	/**
	 * The conference_dt of PatientDetailModel
	 */
	private Timestamp conference_dt;

	/**
	 * The patientconference_status of PatientDetailModel
	 */
	private String patientconference_status;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientDetailModel
	 */
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The week_call of PatientDetailModel
	 */
	private Integer week_call;

	/**
	 * The pcm_id of PatientDetailModel
	 */
	private BigInteger pcm_id;

	/**
	 * The sender of PatientDetailModel
	 */
	private Integer sender;

	/**
	 * The receiver of PatientDetailModel
	 */
	private Integer receiver;

	/**
	 * The subject of PatientDetailModel
	 */
	private String subject;

	/**
	 * The message of PatientDetailModel
	 */
	private String message;

	/**
	 * The sender_type of PatientDetailModel
	 */
	private String sender_type;

	/**
	 * The pcm_status of PatientDetailModel
	 */
	private String pcm_status;

	/**
	 * The sent_dt of PatientDetailModel
	 */
	private Timestamp sent_dt;

	/**
	 * The booking_id of PatientDetailModel
	 */
	private BigInteger booking_id;

	/**
	 * The booking_dt of PatientDetailModel
	 */
	private Timestamp booking_dt;

	/**
	 * The booking_status of PatientDetailModel
	 */
	private String booking_status;

	/**
	 * The practitioner of PatientDetailModel
	 */
	private BigInteger practitioner;

	/**
	 * The booking_timezone of PatientDetailModel
	 */
	private String booking_timezone;

	/**
	 * The conference_timezone of PatientDetailModel
	 */
	private String conference_timezone;

	/**
	 * Get the id of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientDetailModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of PatientDetailModel
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of PatientDetailModel
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the age of PatientDetailModel
	 * @return String
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Set the age of PatientDetailModel
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Get the gender of PatientDetailModel
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the gender of PatientDetailModel
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the email of PatientDetailModel
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of PatientDetailModel
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the phone of PatientDetailModel
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the phone of PatientDetailModel
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the city of PatientDetailModel
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city of PatientDetailModel
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the country of PatientDetailModel
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the country of PatientDetailModel
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the country_code of PatientDetailModel
	 * @return String
	 */
	public String getCountryCode() {
		return country_code;
	}

	/**
	 * Set the country_code of PatientDetailModel
	 * @param country_code the country_code to set
	 */
	public void setCountryCode(String country_code) {
		this.country_code = country_code;
	}

	/**
	 * Get the address of PatientDetailModel
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the address of PatientDetailModel
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the photo of PatientDetailModel
	 * @return String
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Set the photo of PatientDetailModel
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Get the zip_code of PatientDetailModel
	 * @return String
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the zip_code of PatientDetailModel
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * Get the patientcase_id of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPatientcaseId() {
		return patientcase_id;
	}

	/**
	 * Set the patientcase_id of PatientDetailModel
	 * @param patientcase_id the patientcase_id to set
	 */
	public void setPatientcaseId(BigInteger patientcase_id) {
		this.patientcase_id = patientcase_id;
	}

	/**
	 * Get the description of PatientDetailModel
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of PatientDetailModel
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the status of PatientDetailModel
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of PatientDetailModel
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the treatment of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of PatientDetailModel
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the treatment_name of PatientDetailModel
	 * @return String
	 */
	public String getTreatmentName() {
		return treatment_name;
	}

	/**
	 * Set the treatment_name of PatientDetailModel
	 * @param treatment_name the treatment_name to set
	 */
	public void setTreatmentName(String treatment_name) {
		this.treatment_name = treatment_name;
	}

	/**
	 * Get the patientcasefile_id of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPatientcasefileId() {
		return patientcasefile_id;
	}

	/**
	 * Set the patientcasefile_id of PatientDetailModel
	 * @param patientcasefile_id the patientcasefile_id to set
	 */
	public void setPatientcasefileId(BigInteger patientcasefile_id) {
		this.patientcasefile_id = patientcasefile_id;
	}

	/**
	 * Get the file_description of PatientDetailModel
	 * @return String
	 */
	public String getFileDescription() {
		return file_description;
	}

	/**
	 * Set the file_description of PatientDetailModel
	 * @param file_description the file_description to set
	 */
	public void setFileDescription(String file_description) {
		this.file_description = file_description;
	}

	/**
	 * Get the file_type of PatientDetailModel
	 * @return String
	 */
	public String getFileType() {
		return file_type;
	}

	/**
	 * Set the file_type of PatientDetailModel
	 * @param file_type the file_type to set
	 */
	public void setFileType(String file_type) {
		this.file_type = file_type;
	}

	/**
	 * Get the file_name of PatientDetailModel
	 * @return String
	 */
	public String getFileName() {
		return file_name;
	}

	/**
	 * Set the file_name of PatientDetailModel
	 * @param file_name the file_name to set
	 */
	public void setFileName(String file_name) {
		this.file_name = file_name;
	}

	/**
	 * Get the doc_name of PatientDetailModel
	 * @return String
	 */
	public String getDocName() {
		return doc_name;
	}

	/**
	 * Set the doc_name of PatientDetailModel
	 * @param doc_name the doc_name to set
	 */
	public void setDocName(String doc_name) {
		this.doc_name = doc_name;
	}

	/**
	 * Get the file_dt of PatientDetailModel
	 * @return Timestamp
	 */
	public Timestamp getFileDt() {
		return file_dt;
	}

	/**
	 * Set the file_dt of PatientDetailModel
	 * @param file_dt the file_dt to set
	 */
	public void setFileDt(Timestamp file_dt) {
		this.file_dt = file_dt;
	}

	/**
	 * Get the patientconference_id of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPatientconferenceId() {
		return patientconference_id;
	}

	/**
	 * Set the patientconference_id of PatientDetailModel
	 * @param patientconference_id the patientconference_id to set
	 */
	public void setPatientconferenceId(BigInteger patientconference_id) {
		this.patientconference_id = patientconference_id;
	}

	/**
	 * Get the conference_dt of PatientDetailModel
	 * @return Timestamp
	 */
	public Timestamp getConferenceDt() {
		return conference_dt;
	}

	/**
	 * Set the conference_dt of PatientDetailModel
	 * @param conference_dt the conference_dt to set
	 */
	public void setConferenceDt(Timestamp conference_dt) {
		this.conference_dt = conference_dt;
	}

	/**
	 * Get the patientconference_status of PatientDetailModel
	 * @return String
	 */
	public String getPatientconferenceStatus() {
		return patientconference_status;
	}

	/**
	 * Set the patientconference_status of PatientDetailModel
	 * @param patientconference_status the patientconference_status to set
	 */
	public void setPatientconferenceStatus(String patientconference_status) {
		this.patientconference_status = patientconference_status;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientDetailModel
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Get the week_call of PatientDetailModel
	 * @return Integer
	 */
	public Integer getWeekCall() {
		return week_call;
	}

	/**
	 * Set the week_call of PatientDetailModel
	 * @param week_call the week_call to set
	 */
	public void setWeekCall(Integer week_call) {
		this.week_call = week_call;
	}

	/**
	 * Get the pcm_id of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPcmId() {
		return pcm_id;
	}

	/**
	 * Set the pcm_id of PatientDetailModel
	 * @param pcm_id the pcm_id to set
	 */
	public void setPcmId(BigInteger pcm_id) {
		this.pcm_id = pcm_id;
	}

	/**
	 * Get the sender of PatientDetailModel
	 * @return Integer
	 */
	public Integer getSender() {
		return sender;
	}

	/**
	 * Set the sender of PatientDetailModel
	 * @param sender the sender to set
	 */
	public void setSender(Integer sender) {
		this.sender = sender;
	}

	/**
	 * Get the receiver of PatientDetailModel
	 * @return Integer
	 */
	public Integer getReceiver() {
		return receiver;
	}

	/**
	 * Set the receiver of PatientDetailModel
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	/**
	 * Get the subject of PatientDetailModel
	 * @return String
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Set the subject of PatientDetailModel
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Get the message of PatientDetailModel
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the message of PatientDetailModel
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the sender_type of PatientDetailModel
	 * @return String
	 */
	public String getSenderType() {
		return sender_type;
	}

	/**
	 * Set the sender_type of PatientDetailModel
	 * @param sender_type the sender_type to set
	 */
	public void setSenderType(String sender_type) {
		this.sender_type = sender_type;
	}

	/**
	 * Get the pcm_status of PatientDetailModel
	 * @return String
	 */
	public String getPcmStatus() {
		return pcm_status;
	}

	/**
	 * Set the pcm_status of PatientDetailModel
	 * @param pcm_status the pcm_status to set
	 */
	public void setPcmStatus(String pcm_status) {
		this.pcm_status = pcm_status;
	}

	/**
	 * Get the sent_dt of PatientDetailModel
	 * @return Timestamp
	 */
	public Timestamp getSentDt() {
		return sent_dt;
	}

	/**
	 * Set the sent_dt of PatientDetailModel
	 * @param sent_dt the sent_dt to set
	 */
	public void setSentDt(Timestamp sent_dt) {
		this.sent_dt = sent_dt;
	}

	/**
	 * Get the booking_id of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getBookingId() {
		return booking_id;
	}

	/**
	 * Set the booking_id of PatientDetailModel
	 * @param booking_id the booking_id to set
	 */
	public void setBookingId(BigInteger booking_id) {
		this.booking_id = booking_id;
	}

	/**
	 * Get the booking_dt of PatientDetailModel
	 * @return Timestamp
	 */
	public Timestamp getBookingDt() {
		return booking_dt;
	}

	/**
	 * Set the booking_dt of PatientDetailModel
	 * @param booking_dt the booking_dt to set
	 */
	public void setBookingDt(Timestamp booking_dt) {
		this.booking_dt = booking_dt;
	}

	/**
	 * Get the booking_status of PatientDetailModel
	 * @return String
	 */
	public String getBookingStatus() {
		return booking_status;
	}

	/**
	 * Set the booking_status of PatientDetailModel
	 * @param booking_status the booking_status to set
	 */
	public void setBookingStatus(String booking_status) {
		this.booking_status = booking_status;
	}

	/**
	 * Get the practitioner of PatientDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of PatientDetailModel
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * Get the booking_timezone of PatientDetailModel
	 * @return String
	 */
	public String getBookingTimezone() {
		return booking_timezone;
	}

	/**
	 * Set the booking_timezone of PatientDetailModel
	 * @param booking_timezone the booking_timezone to set
	 */
	public void setBookingTimezone(String booking_timezone) {
		this.booking_timezone = booking_timezone;
	}

	/**
	 * Get the conference_timezone of PatientDetailModel
	 * @return String
	 */
	public String getConferenceTimezone() {
		return conference_timezone;
	}

	/**
	 * Set the conference_timezone of PatientDetailModel
	 * @param conference_timezone the conference_timezone to set
	 */
	public void setConferenceTimezone(String conference_timezone) {
		this.conference_timezone = conference_timezone;
	}
}