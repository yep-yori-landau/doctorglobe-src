/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Translations DB Model
 * @author DoctorGlobe
 *
 */
public class Translations {

	/**
	 * The id of Translations.java
	 */
	private BigInteger id;

	/**
	 * The lang of Translations.java
	 */
	@NotNull
	@Size(min = 2, max = 2)
	private String lang;

	/**
	 * The label of Translations.java
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String label;

	/**
	 * The text of Translations.java
	 */
	private String text;

	/**
	 * Get the id of Translations.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Translations.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the lang of Translations.java
	 * @return String
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Set the lang of Translations.java
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * Get the label of Translations.java
	 * @return String
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Set the label of Translations.java
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Get the text of Translations.java
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the text of Translations.java
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
