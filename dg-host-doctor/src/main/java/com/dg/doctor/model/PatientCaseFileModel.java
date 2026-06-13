/**
 * 
 */
package com.dg.doctor.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author kkowlgi
 * 
 */
public class PatientCaseFileModel {
    
	private BigInteger id;
  
	private String description;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String file_type;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String file_name;
  
	private String file_dt;

	@NotNull  
	private BigInteger patient_case;

        /**
	* @return the id
	*/
	public BigInteger getId() {
	 return id;
	}

	/**
   	* @param id the id to set
	*/
	public void setId(BigInteger id ) {
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
	public void setDescription(String description ) {
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
	public void setFileType(String file_type ) {
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
	public void setFileName(String file_name ) {
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
	public void setFileDt(String file_dt ) {
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
	public void setPatientCase(BigInteger patient_case ) {
	 this.patient_case = patient_case;
	}
      
}