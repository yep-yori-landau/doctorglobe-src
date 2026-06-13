/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * HealthcareproviderSpecialty DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderSpecialty {

	/**
	 * The id of HealthcareproviderSpecialty
	 */
	private BigInteger id;

	/**
	 * The name of HealthcareproviderSpecialty
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The built of HealthcareproviderSpecialty
	 */
	private String built;

	/**
	 * The renovated of HealthcareproviderSpecialty
	 */
	private String renovated;

	/**
	 * The specialty of HealthcareproviderSpecialty
	 */
	@NotNull
	private BigInteger specialty;

	/**
	 * The healthcareprovider of HealthcareproviderSpecialty
	 */
	private BigInteger healthcareprovider;

	/**
	 * The active of HealthcareproviderSpecialty
	 */
	private Boolean active;

	/**
	 * Get the id of HealthcareproviderSpecialty
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderSpecialty
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of HealthcareproviderSpecialty
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of HealthcareproviderSpecialty
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the built of HealthcareproviderSpecialty
	 * @return String
	 */
	public String getBuilt() {
		return built;
	}

	/**
	 * Set the built of HealthcareproviderSpecialty
	 * @param built the built to set
	 */
	public void setBuilt(String built) {
		try {
			if (built != "") {
				this.built = built;
			}
			else {
				this.built = null;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Get the renovated of HealthcareproviderSpecialty
	 * @return String
	 */
	public String getRenovated() {
		return renovated;
	}

	/**
	 * Set the renovated of HealthcareproviderSpecialty
	 * @param renovated the renovated to set
	 */
	public void setRenovated(String renovated) {
		try {
			if (renovated != "") {
				this.renovated = renovated;
			}
			else {
				this.renovated = null;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Get the specialty of HealthcareproviderSpecialty
	 * @return BigInteger
	 */
	public BigInteger getSpecialty() {
		return specialty;
	}

	/**
	 * Set the specialty of HealthcareproviderSpecialty
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(BigInteger specialty) {
		this.specialty = specialty;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderSpecialty
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderSpecialty
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * Get the active of HealthcareproviderSpecialty
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of HealthcareproviderSpecialty
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}
