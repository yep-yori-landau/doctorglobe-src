package com.dg.hospital.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangePasswordForm{
	
	@NotNull	
	private BigInteger id;	
	
	@NotNull	
	private String old_password;

	@NotNull
	@Size(min = 6, max = 40)
	private String new_password;	
	
	@NotNull
	@Size(min = 6, max = 40)
	private String confirm_password;
	
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
		
	/**
	 * @return the old_password
	 */
	public String getOldPassword() {
		return old_password;
	}

	/**
	 * @param old_password
	 *            the old_password to set
	 */
	public void setOldPassword(String old_password) {
		this.old_password = old_password;
	}
	
	/**
	 * @return the new_password
	 */
	public String getNewPassword() {
		return new_password;
	}

	/**
	 * @param new_password
	 *            the new_password to set
	 */
	public void setNewPassword(String new_password) {
		this.new_password = new_password;
	}	
		
	/**
	 * @return the confirm_password
	 */
	public String getConfirmPassword() {
		return confirm_password;
	}

	/**
	 * @param cofirm_password
	 *            the confirm_password to set
	 */
	public void setConfirmPassword(String confirm_password) {
		this.confirm_password = confirm_password;
	}
}