package com.dg.data.model.domain;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

/**
 * TreatmentDocumentModel Domain Model
 * @author DoctorGlobe
 *
 */
public class TreatmentDocumentModel {

	/**
	 * The id of TreatmentDocumentModel
	 */
	private BigInteger id;

	/**
	 * The treatment of TreatmentDocumentModel
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The document of TreatmentDocumentModel
	 */
	@NotNull
	private BigInteger document;

	/**
	 * The name of TreatmentDocumentModel
	 */
	private String name;

	/**
	 * Get the id of TreatmentDocumentModel
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentDocumentModel
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment of TreatmentDocumentModel
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of TreatmentDocumentModel
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the document of TreatmentDocumentModel
	 * @return BigInteger
	 */
	public BigInteger getDocument() {
		return document;
	}

	/**
	 * Set the document of TreatmentDocumentModel
	 * @param document the document to set
	 */
	public void setDocument(BigInteger document) {
		this.document = document;
	}

	/**
	 * Get the name of TreatmentDocumentModel
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of TreatmentDocumentModel
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}