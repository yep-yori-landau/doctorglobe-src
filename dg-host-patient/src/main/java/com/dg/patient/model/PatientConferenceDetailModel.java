package com.dg.patient.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author DoctorGlobe
 * 
 */
public class PatientConferenceDetailModel {
	/**
	 * The id of PatientConferenceDetailModel
	 */
	private BigInteger id;

	/**
	 * The conference_dt of PatientConferenceDetailModel
	 */
	@NotNull
	private Timestamp conference_dt;

	/**
	 * The status of PatientConferenceDetailModel
	 */
	@NotNull
	@Size(min = 1, max = 54)
	private String status;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of PatientConferenceDetailModel
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The healthcareprovider_specialty_treatment_method of PatientConferenceDetailModel
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method;

	/**
	 * The patient_case of PatientConferenceDetailModel
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * The practitioner of PatientConferenceDetailModel
	 */
	@NotNull
	private BigInteger practitioner;

	/**
	 * The practitioner_name of PatientConferenceDetailModel
	 */
	@NotNull
	private String practitioner_name;

	/**
	 * The practitioner_email of PatientConferenceDetailModel
	 */
	@NotNull
	private String practitioner_email;

	/**
	 * The practitioner_photo of PatientConferenceDetailModel
	 */
	@NotNull
	private String practitioner_photo;

	/**
	 * The healthcareprovider of PatientConferenceDetailModel
	 */
	@NotNull
	private BigInteger healthcareprovider;

	/**
	 * The healthcareprovider_name of PatientConferenceDetailModel
	 */
	@NotNull
	private String healthcareprovider_name;

	/**
	 * The sender_type of PatientConferenceDetailModel
	 */
	@NotNull
	private String sender_type;

	/**
	 * The subject of PatientConferenceDetailModel
	 */
	private String subject;

	/**
	 * The sent_dt of PatientConferenceDetailModel
	 */
	private Timestamp sent_dt;

	/**
	 * The message of PatientConferenceDetailModel
	 */
	private String message;

	/**
	 * The message_id of PatientConferenceDetailModel
	 */
	private BigInteger message_id;

	/**
	 * The sender of PatientConferenceDetailModel
	 */
	private Integer sender;

	/**
	 * The receiver of PatientConferenceDetailModel
	 */
	private Integer receiver;

	/**
	 * The booking_id of PatientConferenceDetailModel
	 */
	private BigInteger booking_id;

	/**
	 * The booking_dt of PatientConferenceDetailModel
	 */
	private Timestamp booking_dt;

	/**
	 * The booking_status of PatientConferenceDetailModel
	 */
	private String booking_status;

	/**
	 * The pcm_class of PatientConferenceDetailModel
	 */
	private String pcm_class;

	/**
	 * The booking_timezone of PatientConferenceDetailModel
	 */
	private String booking_timezone;

	/**
	 * The conference_timezone of PatientConferenceDetailModel
	 */
	private String conference_timezone;

	/**
	 * The patient_timezone of PatientConferenceDetailModel
	 */
	private String patient_timezone;

	/**
	 * The patient_conference_date of PatientConferenceDetailModel
	 */
	private String patient_conference_date;

	/**
	 * The patient_conference_time of PatientConferenceDetailModel
	 */
	private String patient_conference_time;

	/**
	 * The patient_booking_date of PatientConferenceDetailModel
	 */
	private String patient_booking_date;

	/**
	 * The patient_booking_time of PatientConferenceDetailModel
	 */
	private String patient_booking_time;

	/**
	 * The conference_date of PatientConferenceDetailModel
	 */
	private String conference_date;

	/**
	 * The days of PatientConferenceDetailModel
	 */
	private String days;

	/**
	 * The hours of PatientConferenceDetailModel
	 */
	private String hours;

	/**
	 * The minutes of PatientConferenceDetailModel
	 */
	private String minutes;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the conference_dt
	 */
	public Timestamp getConferenceDt() {
		return conference_dt;
	}

	/**
	 * @param conference_dt the conference_dt to set
	 */
	public void setConferenceDt(Timestamp conference_dt) {
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
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the healthcareprovider_specialty_treatment_method_practitioner
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * @return the healthcareprovider_specialty_treatment_method
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethod() {
		return healthcareprovider_specialty_treatment_method;
	}

	/**
	 * @param healthcareprovider_specialty_treatment_method the
	 * healthcareprovider_specialty_treatment_method to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty_treatment_method) {
		this.healthcareprovider_specialty_treatment_method = healthcareprovider_specialty_treatment_method;
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
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

	/**
	 * @return the practitoner
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * @return the practitoner_name
	 */
	public String getPractitionerName() {
		return practitioner_name;
	}

	/**
	 * @param practitioner_name the practitioner_name to set
	 */
	public void setPractitionerName(String practitioner_name) {
		this.practitioner_name = practitioner_name;
	}

	/**
	 * @return the practitoner_email
	 */
	public String getPractitionerEmail() {
		return practitioner_email;
	}

	/**
	 * @param practitioner_email the practitioner_email to set
	 */
	public void setPractitionerEmail(String practitioner_email) {
		this.practitioner_email = practitioner_email;
	}

	/**
	 * @return the practitoner_photo
	 */
	public String getPractitionerPhoto() {
		return practitioner_photo;
	}

	/**
	 * @param practitioner_photo the practitioner_photo to set
	 */
	public void setPractitionerPhoto(String practitioner_photo) {
		this.practitioner_photo = practitioner_photo;
	}

	/**
	 * @return the healthcareprovider
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * @return the healthcareprovider_name
	 */
	public String getHealthcareproviderName() {
		return healthcareprovider_name;
	}

	/**
	 * @param healthcareprovider_name the heathcareprovider_name to set
	 */
	public void setHealthcareproviderName(String healthcareprovider_name) {
		this.healthcareprovider_name = healthcareprovider_name;
	}

	/**
	 * @return the sender_type
	 */
	public String getSenderType() {
		return sender_type;
	}

	/**
	 * @param sender_type the sender_type to set
	 */
	public void setSenderType(String sender_type) {
		this.sender_type = sender_type;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the sent_dt
	 */
	public Timestamp getSentDt() {
		return sent_dt;
	}

	/**
	 * @param sent_dt the sent_dt to set
	 */
	public void setSentDt(Timestamp sent_dt) {
		this.sent_dt = sent_dt;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the message_id
	 */
	public BigInteger getMessageId() {
		return message_id;
	}

	/**
	 * @param message_id the message_id to set
	 */
	public void setMessageId(BigInteger message_id) {
		this.message_id = message_id;
	}

	/**
	 * @return the sender
	 */
	public Integer getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
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
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the booking_id
	 */
	public BigInteger getBookingId() {
		return booking_id;
	}

	/**
	 * @param booking_id the booking_id to set
	 */
	public void setBookingId(BigInteger booking_id) {
		this.booking_id = booking_id;
	}

	/**
	 * @return the booking_dt
	 */
	public Timestamp getBookingDt() {
		return booking_dt;
	}

	/**
	 * @param booking_dt the booking_dt to set
	 */
	public void setBookingDt(Timestamp booking_dt) {
		this.booking_dt = booking_dt;
	}

	/**
	 * @return the pcm_class
	 */
	public String getPcmClass() {
		return pcm_class;
	}

	/**
	 * @param pcm_class the pcm_class to set
	 */
	public void setPcmClass(String pcm_class) {
		this.pcm_class = pcm_class;
	}

	/**
	 * @return the booking_status
	 */
	public String getBookingStatus() {
		return booking_status;
	}

	/**
	 * @param booking_status the booking_status to set
	 */
	public void setBookingStatus(String booking_status) {
		this.booking_status = booking_status;
	}

	/**
	 * 
	 * @return the booking_timezone
	 */
	public String getBookingTimezone() {
		return booking_timezone;
	}

	/**
	 * 
	 * @param booking_timezone the booking_timezone to set
	 */
	public void setBookingTimezone(String booking_timezone) {
		this.booking_timezone = booking_timezone;
	}

	/**
	 * 
	 * @return the conference_timezone
	 */
	public String getConferenceTimezone() {
		return conference_timezone;
	}

	/**
	 * 
	 * @param conference_timezone the conference_timezone to set
	 */
	public void setConferenceTimezone(String conference_timezone) {
		this.conference_timezone = conference_timezone;
	}

	/**
	 * 
	 * @return the patient_timezone
	 */
	public String getPatientTimezone() {
		return patient_timezone;
	}

	/**
	 * 
	 * @param patient_timezone the patient_timezone to set
	 */
	public void setPatientTimezone(String patient_timezone) {
		this.patient_timezone = patient_timezone;
	}

	/**
	 * 
	 * @return the patient_conference_date
	 */
	public String getPatientConferenceDate() {
		return patient_conference_date;
	}

	/**
	 * 
	 * @param patient_conference_date the patient_conference_date to set
	 */
	public void setPatientConferenceDate(String patient_conference_date) {
		this.patient_conference_date = patient_conference_date;
	}

	/**
	 * 
	 * @return the patient_conference_time
	 */
	public String getPatientConferenceTime() {
		return patient_conference_time;
	}

	/**
	 * 
	 * @param patient_conference_time the patient_conference_time to set
	 */
	public void setPatientConferenceTime(String patient_conference_time) {
		this.patient_conference_time = patient_conference_time;
	}

	/**
	 * 
	 * @return the patient_booking_date
	 */
	public String getPatientBookingDate() {
		return patient_booking_date;
	}

	/**
	 * 
	 * @param patient_booking_date the patient_booking_date to set
	 */
	public void setPatientBookingDate(String patient_booking_date) {
		this.patient_booking_date = patient_booking_date;
	}

	/**
	 * 
	 * @return the patient_booking_time
	 */
	public String getPatientBookingTime() {
		return patient_booking_time;
	}

	/**
	 * 
	 * @param patient_booking_time the patient_booking_time to set
	 */
	public void setPatientBookingTime(String patient_booking_time) {
		this.patient_booking_time = patient_booking_time;
	}

	/**
	 * @return the conference_dt
	 */
	public String getConferenceDate() {
		return conference_date;
	}

	/**
	 * @param conference_dt the conference_dt to set
	 */
	public void setConferenceDate(String conference_date) {
		this.conference_date = conference_date;
	}

	/**
	 * @return the days
	 */
	public String getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(String days) {
		this.days = days;
	}

	/**
	 * @return the hours
	 */
	public String getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */
	public String getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

}
