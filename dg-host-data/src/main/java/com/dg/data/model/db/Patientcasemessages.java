/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientcasemessages DB Model
 * @author DoctorGlobe
 *
 */
public class Patientcasemessages {

	/**
	 * The id of Patientcasemessages
	 */
	private BigInteger id;

	/**
	 * The reference of Patientcasemessages
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String reference;

	/**
	 * The sender_type of Patientcasemessages
	 */
	@NotNull
	@Size(min = 1, max = 33)
	private String sender_type;

	/**
	 * The sender of Patientcasemessages
	 */
	@NotNull
	private Integer sender;

	/**
	 * The receiver_type of Patientcasemessages
	 */
	@NotNull
	@Size(min = 1, max = 33)
	private String receiver_type;

	/**
	 * The receiver of Patientcasemessages
	 */
	@NotNull
	private Integer receiver;

	/**
	 * The subject of Patientcasemessages
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String subject;

	/**
	 * The body of Patientcasemessages
	 */
	@NotNull
	private String body;

	/**
	 * The sent_dt of Patientcasemessages
	 */
	@NotNull
	private String sent_dt;

	/**
	 * The status of Patientcasemessages
	 */
	@NotNull
	@Size(min = 1, max = 13)
	private String status;

	/**
	 * The patient_case of Patientcasemessages
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * Get the id of Patientcasemessages
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientcasemessages
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the reference of Patientcasemessages
	 * @return String
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Set the reference of Patientcasemessages
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Get the sender_type of Patientcasemessages
	 * @return String
	 */
	public String getSenderType() {
		return sender_type;
	}

	/**
	 * Set the sender_type of Patientcasemessages
	 * @param sender_type the sender_type to set
	 */
	public void setSenderType(String sender_type) {
		this.sender_type = sender_type;
	}

	/**
	 * Get the sender of Patientcasemessages
	 * @return Integer
	 */
	public Integer getSender() {
		return sender;
	}

	/**
	 * Set the sender of Patientcasemessages
	 * @param sender the sender to set
	 */
	public void setSender(Integer sender) {
		this.sender = sender;
	}

	/**
	 * Get the receiver_type of Patientcasemessages
	 * @return String
	 */
	public String getReceiverType() {
		return receiver_type;
	}

	/**
	 * Set the receiver_type of Patientcasemessages
	 * @param receiver_type the receiver_type to set
	 */
	public void setReceiverType(String receiver_type) {
		this.receiver_type = receiver_type;
	}

	/**
	 * Get the receiver of Patientcasemessages
	 * @return Integer
	 */
	public Integer getReceiver() {
		return receiver;
	}

	/**
	 * Set the receiver of Patientcasemessages
	 * @param receiver the receiver to set
	 */
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	/**
	 * Get the subject of Patientcasemessages
	 * @return String
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Set the subject of Patientcasemessages
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Get the body of Patientcasemessages
	 * @return String
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Set the body of Patientcasemessages
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Get the sent_dt of Patientcasemessages
	 * @return String
	 */
	public String getSentDt() {
		return sent_dt;
	}

	/**
	 * Set the sent_dt of Patientcasemessages
	 * @param sent_dt the sent_dt to set
	 */
	public void setSentDt(String sent_dt) {
		this.sent_dt = sent_dt;
	}

	/**
	 * Get the status of Patientcasemessages
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of Patientcasemessages
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the patient_case of Patientcasemessages
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of Patientcasemessages
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

}
