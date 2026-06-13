/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * HealthcareproviderEquipment DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderEquipment {

	/**
	 * The id of HealthcareproviderEquipment
	 */
	private BigInteger id;

	/**
	 * The purchase_dt of HealthcareproviderEquipment
	 */
	private String purchase_dt;

	/**
	 * The hours_used of HealthcareproviderEquipment
	 */
	private Integer hours_used;

	/**
	 * The healthcareprovider of HealthcareproviderEquipment
	 */
	private BigInteger healthcareprovider;

	/**
	 * The equipment of HealthcareproviderEquipment
	 */
	@NotNull
	private BigInteger equipment;

	/**
	 * The brand of HealthcareproviderEquipment
	 */
	private String brand;

	/**
	 * The version of HealthcareproviderEquipment
	 */
	private String version;

	/**
	 * Get the id of HealthcareproviderEquipment
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderEquipment
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the purchase_dt of HealthcareproviderEquipment
	 * @return String
	 */
	public String getPurchaseDt() {
		return purchase_dt;
	}

	/**
	 * Set the purchase_dt of HealthcareproviderEquipment
	 * @param purchase_dt the purchase_dt to set
	 */
	public void setPurchaseDt(String purchase_dt) {
		if (purchase_dt != "") {
			this.purchase_dt = purchase_dt;
		}
		else {
			this.purchase_dt = null;
		}
	}

	/**
	 * Get the hours_used of HealthcareproviderEquipment
	 * @return Integer
	 */
	public Integer getHoursUsed() {
		return hours_used;
	}

	/**
	 * Set the hours_used of HealthcareproviderEquipment
	 * @param hours_used the hours_used to set
	 */
	public void setHoursUsed(Integer hours_used) {
		this.hours_used = hours_used;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderEquipment
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderEquipment
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * Get the equipment of HealthcareproviderEquipment
	 * @return BigInteger
	 */
	public BigInteger getEquipment() {
		return equipment;
	}

	/**
	 * Set the equipment of HealthcareproviderEquipment
	 * @param equipment the equipment to set
	 */
	public void setEquipment(BigInteger equipment) {
		this.equipment = equipment;
	}

	/**
	 * Get the brand of HealthcareproviderEquipment
	 * @return String
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Set the brand of HealthcareproviderEquipment
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Get the version of HealthcareproviderEquipment
	 * @return String
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Set the version of HealthcareproviderEquipment
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
