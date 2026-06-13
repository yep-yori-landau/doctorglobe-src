package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PractitionerLanguage DB Model
 * @author DoctorGlobe
 *
 */
public class PractitionerLanguage {

	/**
	 * The id of PractitionerLanguage.java
	 */
	private BigInteger id;

	/**
	 * The language of PractitionerLanguage.java
	 */
	@NotNull
	@Size(min = 2, max = 2)
	private String language;

	/**
	 * The practitioner of PractitionerLanguage.java
	 */
	@NotNull
	private BigInteger practitioner;

	/**
	 * Get the id of PractitionerLanguage.java
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of PractitionerLanguage.java
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the language of PractitionerLanguage.java
	 * @return String
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Set the language of PractitionerLanguage.java
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Get the practitioner of PractitionerLanguage.java
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of PractitionerLanguage.java
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

}
