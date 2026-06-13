package com.dg.patient.model;

import java.math.BigInteger;
/**
 * @author DoctorGlobe
 * 
 */
public class CorporatecompanyPatientModel {

	/**
	 * The id of CorporatecompanyPatientModel
	 */
	private BigInteger id;

	/**
	 * The cc_name of CorporatecompanyPatientModel
	 */
	private String cc_name;

	/**
	 * The patient_id of CorporatecompanyPatientModel
	 */
	private BigInteger patient_id;

	/**
	 * The first_name of CorporatecompanyPatientModel
	 */
	private String first_name;

	/**
	 * The last_name of CorporatecompanyPatientModel
	 */
	private String last_name;

	/**
	 * The email of CorporatecompanyPatientModel
	 */
	private String email;

	/**
	 * The city of CorporatecompanyPatientModel
	 */
	private String city;

	/**
	 * The state of CorporatecompanyPatientModel
	 */
	private String state;

	/**
	 * The country of CorporatecompanyPatientModel
	 */
	private String country;

	/**
	 * The employee_id of CorporatecompanyPatientModel
	 */
	private String employee_id;

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
	 * @param id the id to set
	 */
	public void setCcName(String cc_name) {
		this.cc_name = cc_name;
	}

	/**
	 * @return the cc_name
	 */
	public String getCcName() {
		return cc_name;
	}

	/**
	 * @return the first_name
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param id the id to set
	 */
	public void setPatientId(BigInteger patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * @return the patient_id
	 */
	public BigInteger getPatientId() {
		return patient_id;
	}

	/**
	 * @return the employee_id
	 */
	public String getEmployeeId() {
		return employee_id;
	}

	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployeeId(String employee_id) {
		this.employee_id = employee_id;
	}
}