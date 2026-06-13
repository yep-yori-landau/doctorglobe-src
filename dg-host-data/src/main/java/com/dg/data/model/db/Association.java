/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Association DB Model
 * @author DoctorGlobe
 *
 */
public class Association {

	/**
	 * The id of Association
	 */
	private BigInteger id;

	/**
	 * The name of Association
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The whitelabel_url of Association
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String whitelabel_url;

	/**
	 * The theme of Association
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String theme;

	/**
	 * Get the id of Association
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Association
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Association
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Association
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the whitelabel_url of Association
	 * @return String
	 */
	public String getWhitelabelUrl() {
		return whitelabel_url;
	}

	/**
	 * Set the whitelabel_url of Association
	 * @param whitelabel_url the whitelabel_url to set
	 */
	public void setWhitelabelUrl(String whitelabel_url) {
		this.whitelabel_url = whitelabel_url;
	}

	/**
	 * Get the theme of Association
	 * @return String
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * Set the theme of Association
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

}
