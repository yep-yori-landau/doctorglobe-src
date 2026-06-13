/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * AclRoles DB Model
 * @author DoctorGlobe
 *
 */
public class AclRoles {

	/**
	 * The id of AclRoles
	 */
	private BigInteger id;

	/**
	 * The role of AclRoles
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String role;

	/**
	 * Get the id of AclRoles
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of AclRoles
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the role of AclRoles
	 * @return String
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Set the role of AclRoles
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
