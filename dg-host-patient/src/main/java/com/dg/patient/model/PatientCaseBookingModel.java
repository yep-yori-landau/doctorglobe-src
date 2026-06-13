/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * @author DoctorGlobe
 * 
 */
public class PatientCaseBookingModel {

	/**
	 * The id of PatientCaseBookingModel
	 */
	private BigInteger id;

	/**
	 * The reference of PatientCaseBookingModel
	 */
	@NotNull
	private String reference;

	/**
	 * The booking_dt of PatientCaseBookingModel
	 */
	@NotNull
	private String booking_dt;

	/**
	 * The status of PatientCaseBookingModel
	 */
	@NotNull
	private String status;

	/**
	 * The patient_case of PatientCaseBookingModel
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of PatientCaseBookingModel
	 */
	@NotNull
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * The timezone of PatientCaseBookingModel
	 */
	private String timezone;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
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
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the booking_dt
	 */
	public String getBookingDt() {
		return booking_dt;
	}

	/**
	 * @param booking_dt the booking_dt to set
	 */
	public void setBookingDt(String booking_dt) {
		this.booking_dt = booking_dt;
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
	public void setStatus(String status) {
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
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

	/**
	 * @return the healthcareprovider_specialty_treatment_method_practitioner
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * 
	 * @return timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * 
	 * @param timezone
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

}