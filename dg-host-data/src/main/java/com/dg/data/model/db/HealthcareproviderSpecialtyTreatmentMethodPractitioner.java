/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderSpecialtyTreatmentMethodPractitioner DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderSpecialtyTreatmentMethodPractitioner {

	/**
	 * The id of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private BigInteger id;

	/**
	 * The years_practiced of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Integer years_practiced;

	/**
	 * The number_performed_overall of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Integer number_performed_overall;

	/**
	 * The number_performed_last_year of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Integer number_performed_last_year;

	/**
	 * The corrections_last_year of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Integer corrections_last_year;

	/**
	 * The availability_days of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Integer availability_days;

	/**
	 * The currency of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String currency;

	/**
	 * The healthcareprovider_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Double healthcareprovider_price;

	/**
	 * The practitioner_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	@NotNull
	private Double practitioner_price;

	/**
	 * The anesthesia_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	@NotNull
	private Double anesthesia_price;

	/**
	 * The active of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Boolean active;

	/**
	 * The practitioner of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	@NotNull
	private BigInteger practitioner;

	/**
	 * The healthcareprovider_specialty_treatment_method of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private BigInteger healthcareprovider_specialty_treatment_method;

	/**
	 * The corporatecompany_insurance of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private BigInteger corporatecompany_insurance;

	/**
	 * The verified of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	private Boolean verified;

	/**
	 * Get the id of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the years_practiced of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Integer
	 */
	public Integer getYearsPracticed() {
		return years_practiced;
	}

	/**
	 * Set the years_practiced of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param years_practiced the years_practiced to set
	 */
	public void setYearsPracticed(Integer years_practiced) {
		this.years_practiced = years_practiced;
	}

	/**
	 * Get the number_performed_overall of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Integer
	 */
	public Integer getNumberPerformedOverall() {
		return number_performed_overall;
	}

	/**
	 * Set the number_performed_overall of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param number_performed_overall the number_performed_overall to set
	 */
	public void setNumberPerformedOverall(Integer number_performed_overall) {
		this.number_performed_overall = number_performed_overall;
	}

	/**
	 * Get the number_performed_last_year of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Integer
	 */
	public Integer getNumberPerformedLastYear() {
		return number_performed_last_year;
	}

	/**
	 * Set the number_performed_last_year of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param number_performed_last_year the number_performed_last_year to set
	 */
	public void setNumberPerformedLastYear(Integer number_performed_last_year) {
		this.number_performed_last_year = number_performed_last_year;
	}

	/**
	 * Get the corrections_last_year of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Integer
	 */
	public Integer getCorrectionsLastYear() {
		return corrections_last_year;
	}

	/**
	 * Set the corrections_last_year of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param corrections_last_year the corrections_last_year to set
	 */
	public void setCorrectionsLastYear(Integer corrections_last_year) {
		this.corrections_last_year = corrections_last_year;
	}

	/**
	 * Get the availability_days of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Integer
	 */
	public Integer getAvailabilityDays() {
		return availability_days;
	}

	/**
	 * Set the availability_days of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param availability_days the availability_days to set
	 */
	public void setAvailabilityDays(Integer availability_days) {
		this.availability_days = availability_days;
	}

	/**
	 * Get the currency of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the healthcareprovider_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Double
	 */
	public Double getHealthcareproviderPrice() {
		return healthcareprovider_price;
	}

	/**
	 * Set the healthcareprovider_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param healthcareprovider_price the healthcareprovider_price to set
	 */
	public void setHealthcareproviderPrice(Double healthcareprovider_price) {
		this.healthcareprovider_price = healthcareprovider_price;
	}

	/**
	 * Get the practitioner_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Double
	 */
	public Double getPractitionerPrice() {
		return practitioner_price;
	}

	/**
	 * Set the practitioner_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param practitioner_price the practitioner_price to set
	 */
	public void setPractitionerPrice(Double practitioner_price) {
		this.practitioner_price = practitioner_price;
	}

	/**
	 * Get the anesthesia_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Double
	 */
	public Double getAnesthesiaPrice() {
		return anesthesia_price;
	}

	/**
	 * Set the anesthesia_price of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param anesthesia_price the anesthesia_price to set
	 */
	public void setAnesthesiaPrice(Double anesthesia_price) {
		this.anesthesia_price = anesthesia_price;
	}

	/**
	 * Get the active of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Get the practitioner of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethod() {
		return healthcareprovider_specialty_treatment_method;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param healthcareprovider_specialty_treatment_method the
	 * healthcareprovider_specialty_treatment_method to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty_treatment_method) {
		this.healthcareprovider_specialty_treatment_method = healthcareprovider_specialty_treatment_method;
	}

	/**
	 * Get the corporatecompany_insurance of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return BigInteger
	 */
	public BigInteger getCorporatecompanyInsurance() {
		return corporatecompany_insurance;
	}

	/**
	 * Set the corporatecompany_insurance of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param corporatecompany_insurance the corporatecompany_insurance to set
	 */
	public void setCorporatecompanyInsurance(
			BigInteger corporatecompany_insurance) {
		this.corporatecompany_insurance = corporatecompany_insurance;
	}

	/**
	 * Get the verified of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @return Boolean
	 */
	public Boolean getVerified() {
		return verified;
	}

	/**
	 * Set the verified of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner
	 * @param verified the verified to set
	 */
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

}
