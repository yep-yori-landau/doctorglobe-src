package com.dg.patient.form;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author DoctorGlobe
 *
 */
public class SelectDoctorForm {

	/**
	 * The hstm of SelectDoctorForm
	 */
	@NotNull
	private BigInteger hstm;

	/**
	 * The selected_hstmp of SelectDoctorForm
	 */
	private BigInteger selected_hstmp;

	/**
	 * The first_name of SelectDoctorForm
	 */
	private String first_name;

	/**
	 * The last_name of SelectDoctorForm
	 */
	private String last_name;
	
	/**
	 * The booking_date of SelectDoctorForm.java
	 */
	private String booking_date;

	/**
	 * Get the hstm of SelectDoctorForm
	 * @return BigInteger
	 */
	public BigInteger getHstm() {
		return hstm;
	}

	/**
	 * Set the hstm of SelectDoctorForm
	 * @param hstm the hstm to set
	 */
	public void setHstm(BigInteger hstm) {
		this.hstm = hstm;
	}

	/**
	 * Get the selected_hstmp of SelectDoctorForm
	 * @return BigInteger
	 */
	public BigInteger getSelectedHstmp() {
		return selected_hstmp;
	}

	/**
	 * Set the selected_hstmp of SelectDoctorForm
	 * @param selected_hstmp the selected_hstmp to set
	 */
	public void setSelectedHstmp(BigInteger selected_hstmp) {
		this.selected_hstmp = selected_hstmp;
	}

	/**
	 * Get the first_name of SelectDoctorForm
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of SelectDoctorForm
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of SelectDoctorForm
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of SelectDoctorForm
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the booking_date of SelectDoctorForm
	 * @return String
	 */
	public String getBookingDate() {
		return booking_date;
	}

	/**
	 * Set the booking_date of SelectDoctorForm
	 * @param booking_date the booking_date to set
	 */
	public void setBookingDate(String booking_date) {
		this.booking_date = booking_date;
	}	

}