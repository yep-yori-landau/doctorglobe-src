package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
/**
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
	 * @return the treatment
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * @return the document
	 */
	public BigInteger getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(BigInteger document) {
		this.document = document;
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
}