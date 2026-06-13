package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author DoctorGlobe
 * 
 */
public class HospitalSpecialtyTreatmentMethodPractitionerModel {

	/**
	 * The id of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private BigInteger id;

	/**
	 * The years_practiced of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Integer years_practiced;

	/**
	 * The number_performed_overall of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Integer number_performed_overall;

	/**
	 * The number_performed_last_year of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Integer number_performed_last_year;

	/**
	 * The corrections_last_year of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Integer corrections_last_year;

	/**
	 * The availability_days of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Integer availability_days;

	/**
	 * The currency of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String currency;

	/**
	 * The healthcareprovider_price of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	@NotNull
	private Double healthcareprovider_price;

	/**
	 * The practitioner_price of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	@NotNull
	private Double practitioner_price;

	/**
	 * The anesthesia_price of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	@NotNull
	private Double anesthesia_price;

	/**
	 * The active of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Boolean active;

	/**
	 * The practitioner of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	@NotNull
	private BigInteger practitioner;

	/**
	 * The healthcareprovider_specialty_treatment_method of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private BigInteger healthcareprovider_specialty_treatment_method;

	/**
	 * The corporatecompany_insurance of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private BigInteger corporatecompany_insurance;

	/**
	 * The verified of HospitalSpecialtyTreatmentMethodPractitionerModel
	 */
	private Boolean verified;

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
	 * @return the years_practiced
	 */
	public Integer getYearsPracticed() {
		return years_practiced;
	}

	/**
	 * @param years_practiced the years_practiced to set
	 */
	public void setYearsPracticed(Integer years_practiced) {
		this.years_practiced = years_practiced;
	}

	/**
	 * @return the number_performed_overall
	 */
	public Integer getNumberPerformedOverall() {
		return number_performed_overall;
	}

	/**
	 * @param number_performed_overall the number_performed_overall to set
	 */
	public void setNumberPerformedOverall(Integer number_performed_overall) {
		this.number_performed_overall = number_performed_overall;
	}

	/**
	 * @return the number_performed_last_year
	 */
	public Integer getNumberPerformedLastYear() {
		return number_performed_last_year;
	}

	/**
	 * @param number_performed_last_year the number_performed_last_year to set
	 */
	public void setNumberPerformedLastYear(Integer number_performed_last_year) {
		this.number_performed_last_year = number_performed_last_year;
	}

	/**
	 * @return the corrections_last_year
	 */
	public Integer getCorrectionsLastYear() {
		return corrections_last_year;
	}

	/**
	 * @param corrections_last_year the corrections_last_year to set
	 */
	public void setCorrectionsLastYear(Integer corrections_last_year) {
		this.corrections_last_year = corrections_last_year;
	}

	/**
	 * @return the availability_days
	 */
	public Integer getAvailabilityDays() {
		return availability_days;
	}

	/**
	 * @param availability_days the availability_days to set
	 */
	public void setAvailabilityDays(Integer availability_days) {
		this.availability_days = availability_days;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the healthcareprovider_price
	 */
	public Double getHealthcareproviderPrice() {
		return healthcareprovider_price;
	}

	/**
	 * @param healthcareprovider_price the healthcareprovider_price to set
	 */
	public void setHealthcareproviderPrice(Double healthcareprovider_price) {
		if (healthcareprovider_price != null) {
			this.healthcareprovider_price = healthcareprovider_price;
		}
		else {
			this.healthcareprovider_price = 0.0;
		}
	}

	/**
	 * @return the practitioner_price
	 */
	public Double getPractitionerPrice() {
		return practitioner_price;
	}

	/**
	 * @param practitioner_price the practitioner_price to set
	 */
	public void setPractitionerPrice(Double practitioner_price) {
		this.practitioner_price = practitioner_price;
	}

	/**
	 * @return the anesthesia_price
	 */
	public Double getAnesthesiaPrice() {
		return anesthesia_price;
	}

	/**
	 * @param anesthesia_price the anesthesia_price to set
	 */
	public void setAnesthesiaPrice(Double anesthesia_price) {
		if (anesthesia_price != null) {
			this.anesthesia_price = anesthesia_price;
		}
		else {
			this.anesthesia_price = 0.0;
		}
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
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
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * @return the healthcareprovider_specialty_treatment_method
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethod() {
		return healthcareprovider_specialty_treatment_method;
	}

	/**
	 * @param healthcareprovider_specialty_treatment_method the
	 * healthcareprovider_specialty_treatment_method to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty_treatment_method) {
		this.healthcareprovider_specialty_treatment_method = healthcareprovider_specialty_treatment_method;
	}

	/**
	 * @return the corporatecompany_insurance
	 */
	public BigInteger getCorporatecompanyInsurance() {
		return corporatecompany_insurance;
	}

	/**
	 * @param corporatecompany_insurance the corporatecompany_insurance to set
	 */
	public void setCorporatecompanyInsurance(
			BigInteger corporatecompany_insurance) {
		this.corporatecompany_insurance = corporatecompany_insurance;
	}

	/**
	 * @return the verified
	 */
	public Boolean getVerified() {
		return verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
}