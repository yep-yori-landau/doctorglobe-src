/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * Attestations DB Model
 * @author DoctorGlobe
 *
 */
public class AttestationsPractitioner {

	/**
	 * The id of AttestationsPractitioner
	 */
	private BigInteger id;

	/**
	 * The value of AttestationsPractitioner
	 */
	private Boolean value;

	/**
	 * The attestation of AttestationsPractitioner
	 */
	@NotNull
	private BigInteger attestation;

	/**
	 * The practitioner of AttestationsPractitioner
	 */
	@NotNull
	private BigInteger practitioner;

	/**
	 * Get the id of AttestationsPractitioner
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of AttestationsPractitioner
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the value of AttestationsPractitioner
	 * @return Boolean
	 */
	public Boolean getValue() {
		return value;
	}

	/**
	 * Set the value of AttestationsPractitioner
	 * @param value the value to set
	 */
	public void setValue(Boolean value) {
		this.value = value;
	}

	/**
	 * Get the attestation of AttestationsPractitioner
	 * @return BigInteger
	 */
	public BigInteger getAttestation() {
		return attestation;
	}

	/**
	 * Set the attestation of AttestationsPractitioner
	 * @param attestation the attestation to set
	 */
	public void setAttestation(BigInteger attestation) {
		this.attestation = attestation;
	}

	/**
	 * Get the practitioner of AttestationsPractitioner
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of AttestationsPractitioner
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

}
