/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderSpecialtyPractitioner DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderSpecialtyPractitioner {

	/**
	 * The id of HealthcareproviderSpecialtyPractitioner
	 */
	private BigInteger id;

	/**
	 * The practitioner_email of HealthcareproviderSpecialtyPractitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String practitioner_email;

	/**
	 * The active of HealthcareproviderSpecialtyPractitioner
	 */
	private Boolean active;

	/**
	 * The healthcareprovider_specialty of
	 * HealthcareproviderSpecialtyPractitioner
	 */
	private BigInteger healthcareprovider_specialty;

	/**
	 * Get the id of HealthcareproviderSpecialtyPractitioner
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderSpecialtyPractitioner
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the practitioner_email of HealthcareproviderSpecialtyPractitioner
	 * @return String
	 */
	public String getPractitionerEmail() {
		return practitioner_email;
	}

	/**
	 * Set the practitioner_email of HealthcareproviderSpecialtyPractitioner
	 * @param practitioner_email the practitioner_email to set
	 */
	public void setPractitionerEmail(String practitioner_email) {
		this.practitioner_email = practitioner_email;
	}

	/**
	 * Get the active of HealthcareproviderSpecialtyPractitioner
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of HealthcareproviderSpecialtyPractitioner
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Get the healthcareprovider_specialty of
	 * HealthcareproviderSpecialtyPractitioner
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialty() {
		return healthcareprovider_specialty;
	}

	/**
	 * Set the healthcareprovider_specialty of
	 * HealthcareproviderSpecialtyPractitioner
	 * @param healthcareprovider_specialty the healthcareprovider_specialty to
	 * set
	 */
	public void setHealthcareproviderSpecialty(
			BigInteger healthcareprovider_specialty) {
		this.healthcareprovider_specialty = healthcareprovider_specialty;
	}

}
