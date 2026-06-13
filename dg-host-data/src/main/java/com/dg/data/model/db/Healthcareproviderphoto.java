/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.Size;

/**
 * Healthcareproviderphoto DB Model
 * @author DoctorGlobe
 *
 */
public class Healthcareproviderphoto {

	/**
	 * The id of Healthcareproviderphoto
	 */
	private BigInteger id;

	/**
	 * The path of Healthcareproviderphoto
	 */
	private String path;

	/**
	 * The type of Healthcareproviderphoto
	 */
	private String type;

	/**
	 * The description of Healthcareproviderphoto
	 */
	@Size(min = 1, max = 255)
	private String description;

	/**
	 * The healthcareprovider of Healthcareproviderphoto
	 */
	private BigInteger healthcareprovider;

	/**
	 * The is_primary of Healthcareproviderphoto
	 */
	private Integer is_primary;

	/**
	 * The name of Healthcareproviderphoto
	 */
	private String name;

	/**
	 * Get the id of Healthcareproviderphoto
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Healthcareproviderphoto
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the path of Healthcareproviderphoto
	 * @return String
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Set the path of Healthcareproviderphoto
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Get the type of Healthcareproviderphoto
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of Healthcareproviderphoto
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the description of Healthcareproviderphoto
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Healthcareproviderphoto
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the healthcareprovider of Healthcareproviderphoto
	 * @return BigInteger
	 */
	public BigInteger getHealthcareprovider() {
		return healthcareprovider;
	}

	/**
	 * Set the healthcareprovider of Healthcareproviderphoto
	 * @param healthcareprovider the healthcareprovider to set
	 */
	public void setHealthcareprovider(BigInteger healthcareprovider) {
		this.healthcareprovider = healthcareprovider;
	}

	/**
	 * Get the is_primary of Healthcareproviderphoto
	 * @return Integer
	 */
	public Integer getIsPrimary() {
		return is_primary;
	}

	/**
	 * Set the is_primary of Healthcareproviderphoto
	 * @param is_primary the is_primary to set
	 */
	public void setIsPrimary(Integer is_primary) {
		this.is_primary = is_primary;
	}

	/**
	 * Get the name of Healthcareproviderphoto
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Healthcareproviderphoto
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
