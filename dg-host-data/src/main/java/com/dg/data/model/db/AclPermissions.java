/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * AclPermissions DB Model
 * @author DoctorGlobe
 *
 */
public class AclPermissions {

	/**
	 * The id of AclPermissions
	 */
	private BigInteger id;

	/**
	 * The role of AclPermissions
	 */
	@NotNull
	private BigInteger role;

	/**
	 * The resource of AclPermissions
	 */
	@NotNull
	private BigInteger resource;

	/**
	 * The permission of AclPermissions
	 */
	@NotNull
	@Size(min = 1, max = 14)
	private String permission;

	/**
	 * Get the id of AclPermissions
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of AclPermissions
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the role of AclPermissions
	 * @return BigInteger
	 */
	public BigInteger getRole() {
		return role;
	}

	/**
	 * Set the role of AclPermissions
	 * @param role the role to set
	 */
	public void setRole(BigInteger role) {
		this.role = role;
	}

	/**
	 * Get the resource of AclPermissions
	 * @return BigInteger
	 */
	public BigInteger getResource() {
		return resource;
	}

	/**
	 * Set the resource of AclPermissions
	 * @param resource the resource to set
	 */
	public void setResource(BigInteger resource) {
		this.resource = resource;
	}

	/**
	 * Get the permission of AclPermissions
	 * @return String
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * Set the permission of AclPermissions
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

}
