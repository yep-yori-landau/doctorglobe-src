/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientcase DB Model
 * @author DoctorGlobe
 *
 */
public class Patientcase {

	/**
	 * The id of Patientcase
	 */
	private BigInteger id;

	/**
	 * The description of Patientcase
	 */
	private String description;

	/**
	 * The status of Patientcase
	 */
	@NotNull
	@Size(min = 1, max = 31)
	private String status;

	/**
	 * The treatment of Patientcase
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The patient of Patientcase
	 */
	@NotNull
	private BigInteger patient;

	/**
	 * Get the id of Patientcase
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientcase
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the description of Patientcase
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Patientcase
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the status of Patientcase
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of Patientcase
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the treatment of Patientcase
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of Patientcase
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the patient of Patientcase
	 * @return BigInteger
	 */
	public BigInteger getPatient() {
		return patient;
	}

	/**
	 * Set the patient of Patientcase
	 * @param patient the patient to set
	 */
	public void setPatient(BigInteger patient) {
		this.patient = patient;
	}

}
