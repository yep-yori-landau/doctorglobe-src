/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author DoctorGlobe
 * 
 */
public class AssociationModel {

	/**
	 * The id of AssociationModel
	 */
	private BigInteger id;

	/**
	 * The name of AssociationModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The whitelabel_url of AssociationModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String whitelabel_url;

	/**
	 * The theme of AssociationModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String theme;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the whitelabel_url
	 */
	public String getWhitelabelUrl() {
		return whitelabel_url;
	}

	/**
	 * @param whitelabel_url the whitelabel_url to set
	 */
	public void setWhitelabelUrl(String whitelabel_url) {
		this.whitelabel_url = whitelabel_url;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

}
