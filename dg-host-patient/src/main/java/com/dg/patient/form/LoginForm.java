package com.dg.patient.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
/**
 * Login Form
 * @author DoctorGlobe
 *
 */
public class LoginForm {

	/**
	 * The email of LoginForm
	 */
	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;

	/**
	 * The password of LoginForm
	 */
	@NotNull
	@Size(min = 6, max = 32)
	private String password;

	/**
	 * The treatment of LoginForm
	 */
	private Integer treatment;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Get the password of LoginForm
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of LoginForm
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the treatment of LoginForm
	 * @return Integer
	 */
	public Integer getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of LoginForm
	 * @param treatment the treatment to set
	 */
	public void setTreatment(Integer treatment) {
		this.treatment = treatment;
	}

	/**
	 * Set the email of LoginForm
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
