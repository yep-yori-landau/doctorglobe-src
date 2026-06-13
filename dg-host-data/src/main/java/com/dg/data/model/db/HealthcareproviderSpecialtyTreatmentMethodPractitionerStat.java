/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderSpecialtyTreatmentMethodPractitionerStat {

	/**
	 * The id of HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 */
	private BigInteger id;

	/**
	 * The description of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String description;

	/**
	 * The stat of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 */
	@NotNull
	private BigInteger stat;

	/**
	 * The healthcareprovider_specialty_treatment_method_practitioner of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 */
	private BigInteger healthcareprovider_specialty_treatment_method_practitioner;

	/**
	 * Get the id of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the description of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the stat of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @return BigInteger
	 */
	public BigInteger getStat() {
		return stat;
	}

	/**
	 * Set the stat of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @param stat the stat to set
	 */
	public void setStat(BigInteger stat) {
		this.stat = stat;
	}

	/**
	 * Get the healthcareprovider_specialty_treatment_method_practitioner of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialtyTreatmentMethodPractitioner() {
		return healthcareprovider_specialty_treatment_method_practitioner;
	}

	/**
	 * Set the healthcareprovider_specialty_treatment_method_practitioner of
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat.java
	 * @param healthcareprovider_specialty_treatment_method_practitioner the
	 * healthcareprovider_specialty_treatment_method_practitioner to set
	 */
	public void setHealthcareproviderSpecialtyTreatmentMethodPractitioner(
			BigInteger healthcareprovider_specialty_treatment_method_practitioner) {
		this.healthcareprovider_specialty_treatment_method_practitioner = healthcareprovider_specialty_treatment_method_practitioner;
	}

}
