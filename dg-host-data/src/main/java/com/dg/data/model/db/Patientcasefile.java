/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Patientcasefile DB Model
 * @author DoctorGlobe
 *
 */
public class Patientcasefile {

	/**
	 * The id of Patientcasefile
	 */
	private BigInteger id;

	/**
	 * The description of Patientcasefile
	 */
	private String description;

	/**
	 * The file_type of Patientcasefile
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String file_type;

	/**
	 * The file_name of Patientcasefile
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String file_name;

	/**
	 * The file_dt of Patientcasefile
	 */
	private String file_dt;

	/**
	 * The patient_case of Patientcasefile
	 */
	private BigInteger patient_case;

	/**
	 * The name of Patientcasefile
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The document of Patientcasefile
	 */
	@NotNull
	private BigInteger document;

	/**
	 * Get the id of Patientcasefile
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patientcasefile
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the description of Patientcasefile
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Patientcasefile
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the file_type of Patientcasefile
	 * @return String
	 */
	public String getFileType() {
		return file_type;
	}

	/**
	 * Set the file_type of Patientcasefile
	 * @param file_type the file_type to set
	 */
	public void setFileType(String file_type) {
		this.file_type = file_type;
	}

	/**
	 * Get the file_name of Patientcasefile
	 * @return String
	 */
	public String getFileName() {
		return file_name;
	}

	/**
	 * Set the file_name of Patientcasefile
	 * @param file_name the file_name to set
	 */
	public void setFileName(String file_name) {
		this.file_name = file_name;
	}

	/**
	 * Get the file_dt of Patientcasefile
	 * @return String
	 */
	public String getFileDt() {
		return file_dt;
	}

	/**
	 * Set the file_dt of Patientcasefile
	 * @param file_dt the file_dt to set
	 */
	public void setFileDt(String file_dt) {
		this.file_dt = file_dt;
	}

	/**
	 * Get the patient_case of Patientcasefile
	 * @return BigInteger
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * Set the patient_case of Patientcasefile
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
	}

	/**
	 * Get the name of Patientcasefile
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Patientcasefile
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the document of Patientcasefile
	 * @return BigInteger
	 */
	public BigInteger getDocument() {
		return document;
	}

	/**
	 * Set the document of Patientcasefile
	 * @param document the document to set
	 */
	public void setDocument(BigInteger document) {
		this.document = document;
	}

}
