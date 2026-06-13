/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * EmployeeCorporatecompany DB Model
 * @author DoctorGlobe
 *
 */
public class EmployeeCorporatecompany {

	/**
	 * The id of EmployeeCorporatecompany
	 */
	private BigInteger id;

	/**
	 * The corporatecompany_insurance of EmployeeCorporatecompany
	 */
	@NotNull
	private BigInteger corporatecompany_insurance;

	/**
	 * The patient of EmployeeCorporatecompany
	 */
	@NotNull
	private BigInteger patient;

	/**
	 * The employee_id of EmployeeCorporatecompany
	 */
	@Size(min = 0, max = 255)
	private String employee_id;

	/**
	 * The policy_id of EmployeeCorporatecompany
	 */
	@Size(min = 0, max = 255)
	private String policy_id;

	/**
	 * The email of EmployeeCorporatecompany
	 */
	@Email
	private String email;

	/**
	 * Get the id of EmployeeCorporatecompany
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of EmployeeCorporatecompany
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the corporatecompany_insurance of EmployeeCorporatecompany
	 * @return BigInteger
	 */
	public BigInteger getCorporatecompanyInsurance() {
		return corporatecompany_insurance;
	}

	/**
	 * Set the corporatecompany_insurance of EmployeeCorporatecompany
	 * @param corporatecompany_insurance the corporatecompany_insurance to set
	 */
	public void setCorporatecompanyInsurance(
			BigInteger corporatecompany_insurance) {
		this.corporatecompany_insurance = corporatecompany_insurance;
	}

	/**
	 * Get the patient of EmployeeCorporatecompany
	 * @return BigInteger
	 */
	public BigInteger getPatient() {
		return patient;
	}

	/**
	 * Set the patient of EmployeeCorporatecompany
	 * @param patient the patient to set
	 */
	public void setPatient(BigInteger patient) {
		this.patient = patient;
	}

	/**
	 * Get the employee_id of EmployeeCorporatecompany
	 * @return String
	 */
	public String getEmployeeId() {
		return employee_id;
	}

	/**
	 * Set the employee_id of EmployeeCorporatecompany
	 * @param employee_id the employee_id to set
	 */
	public void setEmployeeId(String employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * Get the policy_id of EmployeeCorporatecompany
	 * @return String
	 */
	public String getPolicyId() {
		return policy_id;
	}

	/**
	 * Set the policy_id of EmployeeCorporatecompany
	 * @param policy_id the policy_id to set
	 */
	public void setPolicyId(String policy_id) {
		this.policy_id = policy_id;
	}

	/**
	 * Get the email of EmployeeCorporatecompany
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of EmployeeCorporatecompany
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
