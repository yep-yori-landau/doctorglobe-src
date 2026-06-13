package com.dg.hospital.model.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

public class PractitionerAttestationsFormModel{
	
	private BigInteger id;	
	
	@NotNull  
	private BigInteger attestation;
  
	private BigInteger practitioner;
	
	private Boolean value;
	
	private String attestation_name;
	
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
	* @return the attestation
	*/
	public BigInteger getAttestation() {
		return attestation;
	}

	/**
  	* @param attestation the attestation to set
	*/
	public void setAttestation(BigInteger attestation ) {
		this.attestation = attestation;
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
	 * @param practitioner
	 */
	public void setPractitioner(BigInteger practitioner){
		this.practitioner = practitioner;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public Boolean getValue(){
		return value;
	}
	
	/**
	 * 
	 * @param value the value to set
	 */
	public void setValue(Boolean value){
		this.value = value;
	}
	
	/**
	* @return the attestation_name
	*/
	public String getAttestationName() {
		return attestation_name;
	}

	/**
  	* @param string the attestation_name to set
	*/
	public void setAttestationName(String attestation_name ) {
		this.attestation_name = attestation_name;
	}
}