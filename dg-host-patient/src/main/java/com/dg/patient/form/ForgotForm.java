package com.dg.patient.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Forgot Form
 * @author DoctorGlobe
 *
 */
public class ForgotForm {

	/**
	 * The email of ForgotForm
	 */
	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;

	/**
	 * Get the email of ForgotForm
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of ForgotForm
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
