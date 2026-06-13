package com.dg.patient.form;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author DoctorGlobe
 *
 */
public class UploadFileForm {
	/**
	 * The name of UploadFileForm
	 */
	@NotNull
	private String name;

	/**
	 * The description of UploadFileForm
	 */
	@NotNull
	private String description;

	/**
	 * The patientcase of UploadFileForm
	 */
	@NotNull
	private BigInteger patientcase;

	/**
	 * The document of UploadFileForm
	 */
	@NotNull
	private BigInteger document;

	/**
	 * The file_dt of UploadFileForm
	 */
	@NotNull
	private String file_dt;

	/**
	 * Get the name of UploadFileForm
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of UploadFileForm
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the description of UploadFileForm
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of UploadFileForm
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the patientcase of UploadFileForm
	 * @return BigInteger
	 */
	public BigInteger getPatientcase() {
		return patientcase;
	}

	/**
	 * Set the patientcase of UploadFileForm
	 * @param patientcase the patientcase to set
	 */
	public void setPatientcase(BigInteger patientcase) {
		this.patientcase = patientcase;
	}

	/**
	 * Get the document of UploadFileForm
	 * @return BigInteger
	 */
	public BigInteger getDocument() {
		return document;
	}

	/**
	 * Set the document of UploadFileForm
	 * @param document the document to set
	 */
	public void setDocument(BigInteger document) {
		this.document = document;
	}

	/**
	 * Get the file_dt of UploadFileForm
	 * @return String
	 */
	public String getFileDt() {
		return file_dt;
	}

	/**
	 * Set the file_dt of UploadFileForm
	 * @param file_dt the file_dt to set
	 */
	public void setFileDt(String file_dt) {
		this.file_dt = file_dt;
	}

}