/**
 * 
 */
package com.dg.hospital.model;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Size;

/**
 * @author kkowlgi
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CorporatecompanyInsuranceModel {
          
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String program_name;
	
	private Double annual_oop;
	
	private Double deductible;
	
	private Integer co_insurance;	
	
	@NotNull
	private BigInteger corporate_company;	

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
	* @return the name
	*/
	public String getProgramName() {
	 return program_name;
	}

	/**
   	* @param name the name to set
	*/
	public void setProgramName(String program_name ) {
	 this.program_name = program_name;
	}
	
	/**
	* @return the annual_oop
	*/
	public Double getAnnualOop() {
	 return annual_oop;
	}

	/**
   	* @param annual_oop the annual_oop to set
	*/
	public void setAnnualOop(Double annual_oop ) {
	 this.annual_oop = annual_oop;
	}
	
	/**
	* @return the annual_oop
	*/
	public Double getDeductible() {
	 return deductible;
	}

	/**
   	* @param deductible the deductible to set
	*/
	public void setDeductible(Double deductible ) {
	 this.deductible = deductible;
	}
	
	/**
	* @return the co_insurance
	*/
	public Integer getCoInsurance() {
	 return co_insurance;
	}

	/**
   	* @param co_insurance the co_insurance to set
	*/
	public void setCoInsurance(Integer co_insurance ) {
	 this.co_insurance = co_insurance;
	}
	
    /**
	* @return the corporate_company
	*/
	public BigInteger getCorporateCompany() {
	 return corporate_company;
	}

	/**
  	* @param corporate_company the corporate_company to set
	*/
	public void setCorporateCompany(BigInteger corporate_company ) {
	 this.corporate_company = corporate_company;
	}
      
}
