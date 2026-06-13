/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientcaseaudit DB Model
 * @author DoctorGlobe
 *
 */
public class Patientcaseaudit {

	/**
	 * The id of Patientcaseaudit
	 */
	private BigInteger id;

	/**
	 * The change_type of Patientcaseaudit
	 */
	@NotNull
	@Size(min = 1, max = 61)
	private String change_type;

	/**
	 * The change_dt of Patientcaseaudit
	 */
	@NotNull
	private String change_dt;

	/**
	 * The status_from of Patientcaseaudit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String status_from;

	/**
	 * The status_to of Patientcaseaudit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String status_to;

	/**
	 * The description of Patientcaseaudit
	 */
	@NotNull
	private String description;

	/**
	 * The patient_case of Patientcaseaudit
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * Get the id of Patientcaseaudit
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientcaseaudit
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the change_type of Patientcaseaudit
	 * @return String
	 */
	public String getChangeType() {
		return change_type;
	}

	/**
	 * Set the change_type of Patientcaseaudit
	 * @param change_type the change_type to set
	 */
	public void setChangeType(String change_type) {
		this.change_type = change_type;
	}

	/**
	 * Get the change_dt of Patientcaseaudit
	 * @return String
	 */
	public String getChangeDt() {
		return change_dt;
	}

	/**
	 * Set the change_dt of Patientcaseaudit
	 * @param change_dt the change_dt to set
	 */
	public void setChangeDt(String change_dt) {
		this.change_dt = change_dt;
	}

	/**
	 * Get the status_from of Patientcaseaudit
	 * @return String
	 */
	public String getStatusFrom() {
		return status_from;
	}

	/**
	 * Set the status_from of Patientcaseaudit
	 * @param status_from the status_from to set
	 */
	public void setStatusFrom(String status_from) {
		this.status_from = status_from;
	}

	/**
	 * Get the status_to of Patientcaseaudit
	 * @return String
	 */
	public String getStatusTo() {
		return status_to;
	}

	/**
	 * Set the status_to of Patientcaseaudit
	 * @param status_to the status_to to set
	 */
	public void setStatusTo(String status_to) {
		this.status_to = status_to;
	}

	/**
	 * Get the description of Patientcaseaudit
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Patientcaseaudit
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the patient_case of Patientcaseaudit
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of Patientcaseaudit
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

}
