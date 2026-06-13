/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderSpecialtyTreatmentMethod DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderSpecialtyTreatmentMethod {

	/**
	 * The id of HealthcareproviderSpecialtyTreatmentMethod.java
	 */
	private BigInteger id;

	/**
	 * The active of HealthcareproviderSpecialtyTreatmentMethod.java
	 */
	private Boolean active;

	/**
	 * The treatment of HealthcareproviderSpecialtyTreatmentMethod.java
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The method of HealthcareproviderSpecialtyTreatmentMethod.java
	 */
	@NotNull
	private BigInteger method;

	/**
	 * The healthcareprovider_specialty of
	 * HealthcareproviderSpecialtyTreatmentMethod.java
	 */
	private BigInteger healthcareprovider_specialty;

	/**
	 * The healthcareprovider_price of
	 * HealthcareproviderSpecialtyTreatmentMethod.java
	 */
	@NotNull
	private Double healthcareprovider_price;

	/**
	 * Get the id of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the active of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Get the treatment of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the method of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @return BigInteger
	 */
	public BigInteger getMethod() {
		return method;
	}

	/**
	 * Set the method of HealthcareproviderSpecialtyTreatmentMethod.java
	 * @param method the method to set
	 */
	public void setMethod(BigInteger method) {
		this.method = method;
	}

	/**
	 * Get the healthcareprovider_specialty of
	 * HealthcareproviderSpecialtyTreatmentMethod.java
	 * @return BigInteger
	 */
	public BigInteger getHealthcareproviderSpecialty() {
		return healthcareprovider_specialty;
	}

	/**
	 * Set the healthcareprovider_specialty of
	 * HealthcareproviderSpecialtyTreatmentMethod.java
	 * @param healthcareprovider_specialty the healthcareprovider_specialty to
	 * set
	 */
	public void setHealthcareproviderSpecialty(
			BigInteger healthcareprovider_specialty) {
		this.healthcareprovider_specialty = healthcareprovider_specialty;
	}

	/**
	 * Get the healthcareprovider_price of
	 * HealthcareproviderSpecialtyTreatmentMethod.java
	 * @return Double
	 */
	public Double getHealthcareproviderPrice() {
		return healthcareprovider_price;
	}

	/**
	 * Set the healthcareprovider_price of
	 * HealthcareproviderSpecialtyTreatmentMethod.java
	 * @param healthcareprovider_price the healthcareprovider_price to set
	 */
	public void setHealthcareproviderPrice(Double healthcareprovider_price) {
		this.healthcareprovider_price = healthcareprovider_price;
	}

}
