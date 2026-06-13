package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CorporatecompanyInsurance DB Model
 * @author DoctorGlobe
 *
 */
public class CorporatecompanyInsurance {

	/**
	 * The id of CorporatecompanyInsurance
	 */
	private BigInteger id;

	/**
	 * The program_name of CorporatecompanyInsurance
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String program_name;

	/**
	 * The annual_oop of CorporatecompanyInsurance
	 */
	private Double annual_oop;

	/**
	 * The deductible of CorporatecompanyInsurance
	 */
	private Double deductible;

	/**
	 * The co_insurance of CorporatecompanyInsurance
	 */
	private Integer co_insurance;

	/**
	 * The corporate_company of CorporatecompanyInsurance
	 */
	@NotNull
	private BigInteger corporate_company;

	/**
	 * The type of CorporatecompanyInsurance
	 */
	private String type;

	/**
	 * The hsa_compatible of CorporatecompanyInsurance
	 */
	private Boolean hsa_compatible;

	/**
	 * Get the id of CorporatecompanyInsurance
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of CorporatecompanyInsurance
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the program_name of CorporatecompanyInsurance
	 * @return String
	 */
	public String getProgramName() {
		return program_name;
	}

	/**
	 * Set the program_name of CorporatecompanyInsurance
	 * @param program_name the program_name to set
	 */
	public void setProgramName(String program_name) {
		this.program_name = program_name;
	}

	/**
	 * Get the annual_oop of CorporatecompanyInsurance
	 * @return Double
	 */
	public Double getAnnualOop() {
		return annual_oop;
	}

	/**
	 * Set the annual_oop of CorporatecompanyInsurance
	 * @param annual_oop the annual_oop to set
	 */
	public void setAnnualOop(Double annual_oop) {
		this.annual_oop = annual_oop;
	}

	/**
	 * Get the deductible of CorporatecompanyInsurance
	 * @return Double
	 */
	public Double getDeductible() {
		return deductible;
	}

	/**
	 * Set the deductible of CorporatecompanyInsurance
	 * @param deductible the deductible to set
	 */
	public void setDeductible(Double deductible) {
		this.deductible = deductible;
	}

	/**
	 * Get the co_insurance of CorporatecompanyInsurance
	 * @return Integer
	 */
	public Integer getCoInsurance() {
		return co_insurance;
	}

	/**
	 * Set the co_insurance of CorporatecompanyInsurance
	 * @param co_insurance the co_insurance to set
	 */
	public void setCoInsurance(Integer co_insurance) {
		this.co_insurance = co_insurance;
	}

	/**
	 * Get the corporate_company of CorporatecompanyInsurance
	 * @return BigInteger
	 */
	public BigInteger getCorporateCompany() {
		return corporate_company;
	}

	/**
	 * Set the corporate_company of CorporatecompanyInsurance
	 * @param corporate_company the corporate_company to set
	 */
	public void setCorporateCompany(BigInteger corporate_company) {
		this.corporate_company = corporate_company;
	}

	/**
	 * Get the type of CorporatecompanyInsurance
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of CorporatecompanyInsurance
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the hsa_compatible of CorporatecompanyInsurance
	 * @return Boolean
	 */
	public Boolean getHsaCompatible() {
		return hsa_compatible;
	}

	/**
	 * Set the hsa_compatible of CorporatecompanyInsurance
	 * @param hsa_compatible the hsa_compatible to set
	 */
	public void setHsaCompatible(Boolean hsa_compatible) {
		this.hsa_compatible = hsa_compatible;
	}

}
