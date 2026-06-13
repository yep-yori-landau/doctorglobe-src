package com.dg.hospital.model;
import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @author kkowlgi
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalAccreditationModel {
          
	private BigInteger id;

	@NotNull  
	private String accreditation_dt;

	@NotNull  
	private BigInteger accreditation;

	@NotNull  
	private BigInteger healthcareprovider;

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
	* @return the accreditation_dt
	*/
	public String getAccreditationDt() {
	 return accreditation_dt;
	}

	/**
   	* @param accreditation_dt the accreditation_dt to set
	*/
	public void setAccreditationDt(String accreditation_dt ) {
	 this.accreditation_dt = accreditation_dt;
	}

	/**
	* @return the accreditation
	*/
	public BigInteger getAccreditation() {
	 return accreditation;
	}

	/**
   	* @param accreditation the accreditation to set
	*/
	public void setAccreditation(BigInteger accreditation ) {
	 this.accreditation = accreditation;
	}

	/**
	* @return the healthcareprovider
	*/
	public BigInteger getHealthcareprovider() {
	 return healthcareprovider;
	}

	/**
   	* @param healthcareprovider the healthcareprovider to set
	*/
	public void setHealthcareprovider(BigInteger healthcareprovider ) {
	 this.healthcareprovider = healthcareprovider;
	}      
}
