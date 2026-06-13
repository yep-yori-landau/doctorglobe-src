/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderAccreditation DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderAccreditation {

	/**
	 * The id of HealthcareproviderAccreditation
	 */
	private BigInteger id;

	/**
	 * The accreditation_dt of HealthcareproviderAccreditation
	 */
	@NotNull
	private String accreditation_dt;

	/**
	 * The accreditation of HealthcareproviderAccreditation
	 */
	@NotNull
	private BigInteger accreditation;

	/**
	 * The healthcareprovider of HealthcareproviderAccreditation
	 */
	@NotNull
	private BigInteger healthcareprovider;

	/**
	 * Get the id of HealthcareproviderAccreditation
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderAccreditation
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the accreditation_dt of HealthcareproviderAccreditation
	 * @return String
	 */
	public String getAccreditationDt() {
		return accreditation_dt;
	}

	/**
	 * Set the accreditation_dt of HealthcareproviderAccreditation
	 * @param accreditation_dt the accreditation_dt to set
	 */
	public void setAccreditationDt(String accreditation_dt) {
		this.accreditation_dt = accreditation_dt;
	}

	/**
	 * Get the accreditation of HealthcareproviderAccreditation
	 * @return BigInteger
	 */
	public BigInteger getAccreditation() {
		return accreditation;
	}

	/**
	 * Set the accreditation of HealthcareproviderAccreditation
	 * @param accreditation the accreditation to set
	 */
	public void setAccreditation(BigInteger accreditation) {
		this.accreditation = accreditation;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderAccreditation
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderAccreditation
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

}
