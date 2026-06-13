package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * History DB Model
 * @author DoctorGlobe
 *
 */
public class History {

	/**
	 * The id of History
	 */
	private BigInteger id;

	/**
	 * The name of History
	 */
	@NotNull
	private String name;

	/**
	 * The original_data of History
	 */
	private String original_data;

	/**
	 * The modify_data of History
	 */
	private String modify_data;

	/**
	 * The modify_date of History
	 */
	@NotNull
	private String modify_date;

	/**
	 * The user_type of History
	 */
	private String user_type;

	/**
	 * The user of History
	 */
	private BigInteger user;

	/**
	 * Get the id of History
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of History
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of History
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of History
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the original_data of History
	 * @return String
	 */
	public String getOriginalData() {
		return original_data;
	}

	/**
	 * Set the original_data of History
	 * @param original_data the original_data to set
	 */
	public void setOriginalData(String original_data) {
		this.original_data = original_data;
	}

	/**
	 * Get the modify_data of History
	 * @return String
	 */
	public String getModifyData() {
		return modify_data;
	}

	/**
	 * Set the modify_data of History
	 * @param modify_data the modify_data to set
	 */
	public void setModifyData(String modify_data) {
		this.modify_data = modify_data;
	}

	/**
	 * Get the modify_date of History
	 * @return String
	 */
	public String getModifyDate() {
		return modify_date;
	}

	/**
	 * Set the modify_date of History
	 * @param modify_date the modify_date to set
	 */
	public void setModifyDate(String modify_date) {
		this.modify_date = modify_date;
	}

	/**
	 * Get the user_type of History
	 * @return String
	 */
	public String getUserType() {
		return user_type;
	}

	/**
	 * Set the user_type of History
	 * @param user_type the user_type to set
	 */
	public void setUserType(String user_type) {
		this.user_type = user_type;
	}

	/**
	 * Get the user of History
	 * @return BigInteger
	 */
	public BigInteger getUser() {
		return user;
	}

	/**
	 * Set the user of History
	 * @param user the user to set
	 */
	public void setUser(BigInteger user) {
		this.user = user;
	}

}