/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientcasebooking DB Model
 * @author DoctorGlobe
 *
 */
public class Patientcasebooking {

	/**
	 * The id of Patientcasebooking
	 */
	private BigInteger id;

	/**
	 * The reference of Patientcasebooking
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String reference;

	/**
	 * The booking_dt of Patientcasebooking
	 */
	@NotNull
	private String booking_dt;

	/**
	 * The status of Patientcasebooking
	 */
	@NotNull
	@Size(min = 1, max = 24)
	private String status;

	/**
	 * The patient_case of Patientcasebooking
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientcasebooking
	 */
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The timezone of Patientcasebooking
	 */
	private String timezone;

	/**
	 * Get the id of Patientcasebooking
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientcasebooking
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the reference of Patientcasebooking
	 * @return String
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Set the reference of Patientcasebooking
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Get the booking_dt of Patientcasebooking
	 * @return String
	 */
	public String getBookingDt() {
		return booking_dt;
	}

	/**
	 * Set the booking_dt of Patientcasebooking
	 * @param booking_dt the booking_dt to set
	 */
	public void setBookingDt(String booking_dt) {
		this.booking_dt = booking_dt;
	}

	/**
	 * Get the status of Patientcasebooking
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of Patientcasebooking
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the patient_case of Patientcasebooking
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of Patientcasebooking
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientcasebooking
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * Patientcasebooking
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Get the timezone of Patientcasebooking
	 * @return String
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * Set the timezone of Patientcasebooking
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

}
