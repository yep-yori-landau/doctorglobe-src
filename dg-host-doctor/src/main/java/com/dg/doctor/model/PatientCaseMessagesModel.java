/**
 * 
 */
package com.dg.doctor.model;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author kkowlgi
 * 
 */
public class PatientCaseMessagesModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String reference;

	@NotNull 
	@Size(min = 1, max = 33) 
	private String sender_type;

	@NotNull  
	private BigInteger sender;

	@NotNull 
	@Size(min = 1, max = 33) 
	private String receiver_type;

	@NotNull  
	private BigInteger receiver;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String subject;

	@NotNull  
	private String body;

	@NotNull  
	private String sent_dt;

	@NotNull 
	@Size(min = 1, max = 13) 
	private String status;

	@NotNull  
	private BigInteger patient_case;

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
	* @return the reference
	*/
	public String getReference() {
	 return reference;
	}

	/**
   	* @param reference the reference to set
	*/
	public void setReference(String reference ) {
	 this.reference = reference;
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
	public void setSenderType(String sender_type ) {
	 this.sender_type = sender_type;
	}

	/**
	* @return the sender
	*/
	public BigInteger getSender() {
	 return sender;
	}

	/**
   	* @param sender the sender to set
	*/
	public void setSender(BigInteger sender ) {
	 this.sender = sender;
	}

	/**
	* @return the receiver_type
	*/
	public String getReceiverType() {
	 return receiver_type;
	}

	/**
   	* @param receiver_type the receiver_type to set
	*/
	public void setReceiverType(String receiver_type ) {
	 this.receiver_type = receiver_type;
	}

	/**
	* @return the receiver
	*/
	public BigInteger getReceiver() {
	 return receiver;
	}

	/**
   	* @param receiver the receiver to set
	*/
	public void setReceiver(BigInteger receiver ) {
	 this.receiver = receiver;
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
	public void setSubject(String subject ) {
	 this.subject = subject;
	}

	/**
	* @return the body
	*/
	public String getBody() {
	 return body;
	}

	/**
   	* @param body the body to set
	*/
	public void setBody(String body ) {
	 this.body = body;
	}

	/**
	* @return the sent_dt
	*/
	public String getSentDt() {
	 return sent_dt;
	}

	/**
   	* @param sent_dt the sent_dt to set
	*/
	public void setSentDt(String sent_dt ) {
	 this.sent_dt = sent_dt;
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
      
}
