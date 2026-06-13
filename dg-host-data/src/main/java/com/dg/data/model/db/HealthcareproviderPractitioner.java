package com.dg.data.model.db;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * HealthcareproviderPractitioner DB Model
 * @author DoctorGlobe
 *
 */
public class HealthcareproviderPractitioner {

	/**
	 * The id of HealthcareproviderPractitioner
	 */
	private BigInteger id;

	/**
	 * The title of HealthcareproviderPractitioner
	 */
	@NotNull
	@Size(min = 1, max = 32)
	private String title;

	/**
	 * The first_name of HealthcareproviderPractitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of HealthcareproviderPractitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The mobile of HealthcareproviderPractitioner
	 */
	private String mobile;

	/**
	 * The email of HealthcareproviderPractitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	@NotNull
	private String currency;

	/**
	 * The insurance_cap of HealthcareproviderPractitioner
	 */
	private BigDecimal insurance_cap;

	/**
	 * The policy_file of HealthcareproviderPractitioner
	 */
	private String policy_file;

	/**
	 * The description of HealthcareproviderPractitioner
	 */
	private String description;

	/**
	 * The healthcareprovider of HealthcareproviderPractitioner
	 */
	@NotNull
	private BigInteger healthcareprovider;

	/**
	 * The practitioner of HealthcareproviderPractitioner
	 */
	@NotNull
	private BigInteger practitioner;

	/**
	 * The type of HealthcareproviderPractitioner
	 */
	@NotNull
	private BigInteger type;

	/**
	 * Get the id of HealthcareproviderPractitioner
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderPractitioner
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the title of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of HealthcareproviderPractitioner
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the first_name of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of HealthcareproviderPractitioner
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of HealthcareproviderPractitioner
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the mobile of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Set the mobile of HealthcareproviderPractitioner
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Get the email of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of HealthcareproviderPractitioner
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the currency of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of HealthcareproviderPractitioner
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the insurance_cap of HealthcareproviderPractitioner
	 * @return BigDecimal
	 */
	public BigDecimal getInsuranceCap() {
		return insurance_cap;
	}

	/**
	 * Set the insurance_cap of HealthcareproviderPractitioner
	 * @param insurance_cap the insurance_cap to set
	 */
	public void setInsuranceCap(BigDecimal insurance_cap) {
		this.insurance_cap = insurance_cap;
	}

	/**
	 * Get the policy_file of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getPolicyFile() {
		return policy_file;
	}

	/**
	 * Set the policy_file of HealthcareproviderPractitioner
	 * @param policy_file the policy_file to set
	 */
	public void setPolicyFile(String policy_file) {
		this.policy_file = policy_file;
	}

	/**
	 * Get the description of HealthcareproviderPractitioner
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of HealthcareproviderPractitioner
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the healthcareprovider of HealthcareproviderPractitioner
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of HealthcareproviderPractitioner
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * Get the practitioner of HealthcareproviderPractitioner
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of HealthcareproviderPractitioner
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * Get the type of HealthcareproviderPractitioner
	 * @return BigInteger
	 */
	public BigInteger getType() {
		return type;
	}

	/**
	 * Set the type of HealthcareproviderPractitioner
	 * @param type the type to set
	 */
	public void setType(BigInteger type) {
		this.type = type;
	}

}