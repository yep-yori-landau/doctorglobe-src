/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Audit DB Model
 * @author DoctorGlobe
 *
 */
public class Audit {

	/**
	 * The id of Audit
	 */
	private BigInteger id;

	/**
	 * The ip_address of Audit
	 */
	@NotNull
	@Size(min = 1, max = 40)
	private String ip_address;

	/**
	 * The change_table of Audit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String change_table;

	/**
	 * The change_id of Audit
	 */
	private Integer change_id;

	/**
	 * The change_field of Audit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String change_field;

	/**
	 * The change_from of Audit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String change_from;

	/**
	 * The change_to of Audit
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String change_to;

	/**
	 * The change_dt of Audit
	 */
	@NotNull
	private String change_dt;

	/**
	 * The user of Audit
	 */
	@NotNull
	private BigInteger user;

	/**
	 * Get the id of Audit
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Audit
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the ip_address of Audit
	 * @return String
	 */
	public String getIpAddress() {
		return ip_address;
	}

	/**
	 * Set the ip_address of Audit
	 * @param ip_address the ip_address to set
	 */
	public void setIpAddress(String ip_address) {
		this.ip_address = ip_address;
	}

	/**
	 * Get the change_table of Audit
	 * @return String
	 */
	public String getChangeTable() {
		return change_table;
	}

	/**
	 * Set the change_table of Audit
	 * @param change_table the change_table to set
	 */
	public void setChangeTable(String change_table) {
		this.change_table = change_table;
	}

	/**
	 * Get the change_id of Audit
	 * @return Integer
	 */
	public Integer getChangeId() {
		return change_id;
	}

	/**
	 * Set the change_id of Audit
	 * @param change_id the change_id to set
	 */
	public void setChangeId(Integer change_id) {
		this.change_id = change_id;
	}

	/**
	 * Get the change_field of Audit
	 * @return String
	 */
	public String getChangeField() {
		return change_field;
	}

	/**
	 * Set the change_field of Audit
	 * @param change_field the change_field to set
	 */
	public void setChangeField(String change_field) {
		this.change_field = change_field;
	}

	/**
	 * Get the change_from of Audit
	 * @return String
	 */
	public String getChangeFrom() {
		return change_from;
	}

	/**
	 * Set the change_from of Audit
	 * @param change_from the change_from to set
	 */
	public void setChangeFrom(String change_from) {
		this.change_from = change_from;
	}

	/**
	 * Get the change_to of Audit
	 * @return String
	 */
	public String getChangeTo() {
		return change_to;
	}

	/**
	 * Set the change_to of Audit
	 * @param change_to the change_to to set
	 */
	public void setChangeTo(String change_to) {
		this.change_to = change_to;
	}

	/**
	 * Get the change_dt of Audit
	 * @return String
	 */
	public String getChangeDt() {
		return change_dt;
	}

	/**
	 * Set the change_dt of Audit
	 * @param change_dt the change_dt to set
	 */
	public void setChangeDt(String change_dt) {
		this.change_dt = change_dt;
	}

	/**
	 * Get the user of Audit
	 * @return BigInteger
	 */
	public BigInteger getUser() {
		return user;
	}

	/**
	 * Set the user of Audit
	 * @param user the user to set
	 */
	public void setUser(BigInteger user) {
		this.user = user;
	}

}
