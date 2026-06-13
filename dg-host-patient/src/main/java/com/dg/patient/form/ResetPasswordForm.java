package com.dg.patient.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author DoctorGlobe
 * 
 */
/**
 * @author kamadhenu
 *
 */
public class ResetPasswordForm {

	/**
	 * The id of ResetPasswordForm
	 */
	@NotNull
	private Integer id;

	/**
	 * The new_password of ResetPasswordForm
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String new_password;

	/**
	 * The old_password of ResetPasswordForm
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String old_password;

	/**
	 * The confirm_password of ResetPasswordForm
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String confirm_password;

	/**
	 * The type of ResetPasswordForm
	 */
	@NotNull
	private String type;

	/**
	 * Get the id of ResetPasswordForm
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id of ResetPasswordForm
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the new_password of ResetPasswordForm
	 * @return String
	 */
	public String getNewPassword() {
		return new_password;
	}

	/**
	 * Set the new_password of ResetPasswordForm
	 * @param new_password the new_password to set
	 */
	public void setNewPassword(String new_password) {
		this.new_password = new_password;
	}

	/**
	 * Get the old_password of ResetPasswordForm
	 * @return String
	 */
	public String getOldPassword() {
		return old_password;
	}

	/**
	 * Set the old_password of ResetPasswordForm
	 * @param old_password the old_password to set
	 */
	public void setOldPassword(String old_password) {
		this.old_password = old_password;
	}

	/**
	 * Get the confirm_password of ResetPasswordForm
	 * @return String
	 */
	public String getConfirmPassword() {
		return confirm_password;
	}

	/**
	 * Set the confirm_password of ResetPasswordForm
	 * @param confirm_password the confirm_password to set
	 */
	public void setConfirmPassword(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	/**
	 * Get the type of ResetPasswordForm
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of ResetPasswordForm
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
