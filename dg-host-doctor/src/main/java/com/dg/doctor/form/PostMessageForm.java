package com.dg.doctor.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostMessageForm
{
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

}