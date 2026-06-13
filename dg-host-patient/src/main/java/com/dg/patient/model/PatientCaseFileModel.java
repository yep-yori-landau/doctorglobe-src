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
public class PatientCaseFileModel {

	/**
	 * The id of PatientCaseFileModel
	 */
	private BigInteger id;

	/**
	 * The description of PatientCaseFileModel
	 */
	private String description;

	/**
	 * The file_type of PatientCaseFileModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String file_type;

	/**
	 * The file_name of PatientCaseFileModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String file_name;

	/**
	 * The file_dt of PatientCaseFileModel
	 */
	private String file_dt;

	/**
	 * The patient_case of PatientCaseFileModel
	 */
	@NotNull
	private BigInteger patient_case;

	/**
	 * The name of PatientCaseFileModel
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The document of PatientCaseFileModel
	 */
	@NotNull
	private BigInteger document;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the file_type
	 */
	public String getFileType() {
		return file_type;
	}

	/**
	 * @param file_type the file_type to set
	 */
	public void setFileType(String file_type) {
		this.file_type = file_type;
	}

	/**
	 * @return the file_name
	 */
	public String getFileName() {
		return file_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFileName(String file_name) {
		this.file_name = file_name;
	}

	/**
	 * @return the file_dt
	 */
	public String getFileDt() {
		return file_dt;
	}

	/**
	 * @param file_dt the file_dt to set
	 */
	public void setFileDt(String file_dt) {
		this.file_dt = file_dt;
	}

	/**
	 * @return the patient_case
	 */
	public BigInteger getPatientCase() {
		return patient_case;
	}

	/**
	 * @param patient_case the patient_case to set
	 */
	public void setPatientCase(BigInteger patient_case) {
		this.patient_case = patient_case;
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
	 * 
	 * @return
	 */
	public BigInteger getDocument() {
		return document;
	}

	/**
	 * 
	 * @param document
	 */
	public void setDocument(BigInteger document) {
		this.document = document;
	}

}
