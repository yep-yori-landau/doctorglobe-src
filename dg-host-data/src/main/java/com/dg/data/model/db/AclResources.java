/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * AclResources DB Model
 * @author DoctorGlobe
 *
 */
public class AclResources {

	/**
	 * The id of AclResources
	 */
	private BigInteger id;

	/**
	 * The resource of AclResources
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String resource;

	/**
	 * Get the id of AclResources
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of AclResources
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the resource of AclResources
	 * @return String
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * Set the resource of AclResources
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}

}
