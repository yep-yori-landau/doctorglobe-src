package com.dg.doctor.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class CancelForm
{
	@NotNull
	private BigInteger patientcase;
	
	@NotNull
	private BigInteger hcpstmp;
	
	@NotNull
	private BigInteger receiver;
	
	@NotNull
	private Boolean deletecase;
	/**
	 * @return the patientcase
	 */
	public BigInteger getPatientcase() {
		return patientcase;
	}

	/**
	 * @param patientcase
	 *            the patientcase to set
	 */
	public void setPatientcase(BigInteger patientcase) {
		this.patientcase = patientcase;
	}	
	
	/**
	 * @return the hcpstmp
	 */
	public BigInteger getHcpstmp() {
		return hcpstmp;
	}

	/**
	 * @param hcpstmp
	 *            the hcpstmp to set
	 */
	public void setHcpstmp(BigInteger hcpstmp) {
		this.hcpstmp = hcpstmp;
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
	 * @return deletecase
	 */
	public Boolean getDeletecase(){
		return deletecase;
	}
	
	/**
	 * 
	 * @param deletecase
	 */
	public void setDeletecase(Boolean deletecase){
		this.deletecase = deletecase;
	}
}