package com.dg.data.model.domain;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PatientConferenceDetailModel Domain Model
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
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientConferenceDetailModel
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The healthcareprovider_specialty_treatment_method of
	 * PatientConferenceDetailModel
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
	 * The booking_timezone of PatientConferenceDetailModel
	 */
	private String booking_timezone;

	/**
	 * The conference_timezone of PatientConferenceDetailModel
	 */
	private String conference_timezone;

	/**
	 * Get the id of PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientConferenceDetailModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the conference_dt of PatientConferenceDetailModel
	 * @return Timestamp
	 */
	public Timestamp getConferenceDt() {
		return conference_dt;
	}

	/**
	 * Set the conference_dt of PatientConferenceDetailModel
	 * @param conference_dt the conference_dt to set
	 */
	public void setConferenceDt(Timestamp conference_dt) {
		this.conference_dt = conference_dt;
	}

	/**
	 * Get the status of PatientConferenceDetailModel
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of PatientConferenceDetailModel
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * PatientConferenceDetailModel
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method of
	 * PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethod() {
		return healthcareprovider_specialty_treatment_method;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method of
	 * PatientConferenceDetailModel
	 * @param healthcareprovider_specialty_treatment_method the
	 * healthcareprovider_specialty_treatment_method to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty_treatment_method) {
		this.healthcareprovider_specialty_treatment_method = healthcareprovider_specialty_treatment_method;
	}

	/**
	 * Get the patient_case of PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of PatientConferenceDetailModel
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

	/**
	 * Get the practitioner of PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of PatientConferenceDetailModel
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * Get the practitioner_name of PatientConferenceDetailModel
	 * @return String
	 */
	public String getPractitionerName() {
		return practitioner_name;
	}

	/**
	 * Set the practitioner_name of PatientConferenceDetailModel
	 * @param practitioner_name the practitioner_name to set
	 */
	public void setPractitionerName(String practitioner_name) {
		this.practitioner_name = practitioner_name;
	}

	/**
	 * Get the practitioner_email of PatientConferenceDetailModel
	 * @return String
	 */
	public String getPractitionerEmail() {
		return practitioner_email;
	}

	/**
	 * Set the practitioner_email of PatientConferenceDetailModel
	 * @param practitioner_email the practitioner_email to set
	 */
	public void setPractitionerEmail(String practitioner_email) {
		this.practitioner_email = practitioner_email;
	}

	/**
	 * Get the practitioner_photo of PatientConferenceDetailModel
	 * @return String
	 */
	public String getPractitionerPhoto() {
		return practitioner_photo;
	}

	/**
	 * Set the practitioner_photo of PatientConferenceDetailModel
	 * @param practitioner_photo the practitioner_photo to set
	 */
	public void setPractitionerPhoto(String practitioner_photo) {
		this.practitioner_photo = practitioner_photo;
	}

	/**
	 * Get the healthcareprovider of PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of PatientConferenceDetailModel
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * Get the healthcareprovider_name of PatientConferenceDetailModel
	 * @return String
	 */
	public String getHealthcareproviderName() {
		return healthcareprovider_name;
	}

	/**
	 * Set the healthcareprovider_name of PatientConferenceDetailModel
	 * @param healthcareprovider_name the healthcareprovider_name to set
	 */
	public void setHealthcareproviderName(String healthcareprovider_name) {
		this.healthcareprovider_name = healthcareprovider_name;
	}

	/**
	 * Get the sender_type of PatientConferenceDetailModel
	 * @return String
	 */
	public String getSenderType() {
		return sender_type;
	}

	/**
	 * Set the sender_type of PatientConferenceDetailModel
	 * @param sender_type the sender_type to set
	 */
	public void setSenderType(String sender_type) {
		this.sender_type = sender_type;
	}

	/**
	 * Get the subject of PatientConferenceDetailModel
	 * @return String
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Set the subject of PatientConferenceDetailModel
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Get the sent_dt of PatientConferenceDetailModel
	 * @return Timestamp
	 */
	public Timestamp getSentDt() {
		return sent_dt;
	}

	/**
	 * Set the sent_dt of PatientConferenceDetailModel
	 * @param sent_dt the sent_dt to set
	 */
	public void setSentDt(Timestamp sent_dt) {
		this.sent_dt = sent_dt;
	}

	/**
	 * Get the message of PatientConferenceDetailModel
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set the message of PatientConferenceDetailModel
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get the message_id of PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getMessageId() {
		return message_id;
	}

	/**
	 * Set the message_id of PatientConferenceDetailModel
	 * @param message_id the message_id to set
	 */
	public void setMessageId(BigInteger message_id) {
		this.message_id = message_id;
	}

	/**
	 * Get the sender of PatientConferenceDetailModel
	 * @return Integer
	 */
	public Integer getSender() {
		return sender;
	}

	/**
	 * Set the sender of PatientConferenceDetailModel
	 * @param sender the sender to set
	 */
	public void setSender(Integer sender) {
		this.sender = sender;
	}

	/**
	 * Get the receiver of PatientConferenceDetailModel
	 * @return Integer
	 */
	public Integer getReceiver() {
		return receiver;
	}

	/**
	 * Set the receiver of PatientConferenceDetailModel
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	/**
	 * Get the booking_id of PatientConferenceDetailModel
	 * @return BigInteger
	 */
	public BigInteger getBookingId() {
		return booking_id;
	}

	/**
	 * Set the booking_id of PatientConferenceDetailModel
	 * @param booking_id the booking_id to set
	 */
	public void setBookingId(BigInteger booking_id) {
		this.booking_id = booking_id;
	}

	/**
	 * Get the booking_dt of PatientConferenceDetailModel
	 * @return Timestamp
	 */
	public Timestamp getBookingDt() {
		return booking_dt;
	}

	/**
	 * Set the booking_dt of PatientConferenceDetailModel
	 * @param booking_dt the booking_dt to set
	 */
	public void setBookingDt(Timestamp booking_dt) {
		this.booking_dt = booking_dt;
	}

	/**
	 * Get the booking_status of PatientConferenceDetailModel
	 * @return String
	 */
	public String getBookingStatus() {
		return booking_status;
	}

	/**
	 * Set the booking_status of PatientConferenceDetailModel
	 * @param booking_status the booking_status to set
	 */
	public void setBookingStatus(String booking_status) {
		this.booking_status = booking_status;
	}

	/**
	 * Get the booking_timezone of PatientConferenceDetailModel
	 * @return String
	 */
	public String getBookingTimezone() {
		return booking_timezone;
	}

	/**
	 * Set the booking_timezone of PatientConferenceDetailModel
	 * @param booking_timezone the booking_timezone to set
	 */
	public void setBookingTimezone(String booking_timezone) {
		this.booking_timezone = booking_timezone;
	}

	/**
	 * Get the conference_timezone of PatientConferenceDetailModel
	 * @return String
	 */
	public String getConferenceTimezone() {
		return conference_timezone;
	}

	/**
	 * Set the conference_timezone of PatientConferenceDetailModel
	 * @param conference_timezone the conference_timezone to set
	 */
	public void setConferenceTimezone(String conference_timezone) {
		this.conference_timezone = conference_timezone;
	}

}