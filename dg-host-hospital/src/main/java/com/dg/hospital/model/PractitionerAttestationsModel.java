package com.dg.hospital.model;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PractitionerAttestationsModel{
	
private BigInteger id;
	
	private Boolean value;

	@NotNull  
	private BigInteger attestation;

	@NotNull  
	private BigInteger practitioner;

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
	* @return the value
	*/
	public Boolean getValue() {
	 return value;
	}

	/**
   	* @param value the value to set
	*/
	public void setValue(Boolean value ) {
	 this.value = value;
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
	* @return the practitioner
	*/
	public BigInteger getPractitioner() {
	 return practitioner;
	}

	/**
   	* @param practitioner the practitioner to set
	*/
	public void setPractitioner(BigInteger practitioner ) {
	 this.practitioner = practitioner;
	}


	
}