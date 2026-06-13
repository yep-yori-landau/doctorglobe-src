package com.dg.data.model.domain;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * TreatmentSearchModel Domain Model
 * @author DoctorGlobe
 *
 */

public class PatientModel {

	/**
	 * The id of PatientModel
	 */
	private BigInteger id;

	/**
	 * The title of PatientModel
	 */
	private String title;

	/**
	 * The first_name of PatientModel
	 */
	@NotNull
	@Size(min = 3, max = 255)
	private String first_name;

	/**
	 * The last_name of PatientModel
	 */
	@NotNull
	@Size(min = 3, max = 255)
	private String last_name;

	/**
	 * The dob of PatientModel
	 */
	private String dob;

	/**
	 * The gender of PatientModel
	 */
	@NotNull
	private String gender;

	/**
	 * The mobile of PatientModel
	 */
	private String mobile;

	/**
	 * The email of PatientModel
	 */
	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;

	/**
	 * The phone of PatientModel
	 */
	private String phone;

	/**
	 * The password of PatientModel
	 */
	@NotNull
	@Size(min = 6, max = 32)
	private String password;

	/**
	 * The company of PatientModel
	 */
	private Integer company;

	/**
	 * The company_name of PatientModel
	 */
	private String company_name;

	/**
	 * The treatment_id of PatientModel
	 */
	private Integer treatment_id;

	/**
	 * The active of PatientModel
	 */
	private Boolean active;

	/**
	 * Get the id of PatientModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PatientModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the title of PatientModel
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of PatientModel
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the first_name of PatientModel
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of PatientModel
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of PatientModel
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of PatientModel
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the dob of PatientModel
	 * @return String
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Set the dob of PatientModel
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Get the gender of PatientModel
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the gender of PatientModel
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the mobile of PatientModel
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Set the mobile of PatientModel
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Get the email of PatientModel
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of PatientModel
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the phone of PatientModel
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the phone of PatientModel
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the password of PatientModel
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of PatientModel
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the company of PatientModel
	 * @return Integer
	 */
	public Integer getCompany() {
		return company;
	}

	/**
	 * Set the company of PatientModel
	 * @param company the company to set
	 */
	public void setCompany(Integer company) {
		this.company = company;
	}

	/**
	 * Get the company_name of PatientModel
	 * @return String
	 */
	public String getCompanyName() {
		return company_name;
	}

	/**
	 * Set the company_name of PatientModel
	 * @param company_name the company_name to set
	 */
	public void setCompanyName(String company_name) {
		this.company_name = company_name;
	}

	/**
	 * Get the treatment_id of PatientModel
	 * @return Integer
	 */
	public Integer getTreatmentId() {
		return treatment_id;
	}

	/**
	 * Set the treatment_id of PatientModel
	 * @param treatment_id the treatment_id to set
	 */
	public void setTreatmentId(Integer treatment_id) {
		this.treatment_id = treatment_id;
	}

	/**
	 * Get the active of PatientModel
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of PatientModel
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}