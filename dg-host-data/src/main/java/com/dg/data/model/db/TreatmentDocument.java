/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * TreatmentDocument DB Model
 * @author DoctorGlobe
 *
 */
public class TreatmentDocument {

	/**
	 * The id of TreatmentDocument
	 */
	private BigInteger id;

	/**
	 * The treatment of TreatmentDocument
	 */
	@NotNull
	private BigInteger treatment;

	/**
	 * The document of TreatmentDocument
	 */
	@NotNull
	private BigInteger document;

	/**
	 * Get the id of TreatmentDocument
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of TreatmentDocument
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the treatment of TreatmentDocument
	 * @return BigInteger
	 */
	public BigInteger getTreatment() {
		return treatment;
	}

	/**
	 * Set the treatment of TreatmentDocument
	 * @param treatment the treatment to set
	 */
	public void setTreatment(BigInteger treatment) {
		this.treatment = treatment;
	}

	/**
	 * Get the document of TreatmentDocument
	 * @return BigInteger
	 */
	public BigInteger getDocument() {
		return document;
	}

	/**
	 * Set the document of TreatmentDocument
	 * @param document the document to set
	 */
	public void setDocument(BigInteger document) {
		this.document = document;
	}

}
