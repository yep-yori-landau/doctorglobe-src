/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Patient DB Model
 * @author DoctorGlobe
 *
 */
public class Patient {

	/**
	 * The id of Patient
	 */
	private BigInteger id;

	/**
	 * The title of Patient
	 */
	private String title;

	/**
	 * The first_name of Patient
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of Patient
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The dob of Patient
	 */
	private String dob;

	/**
	 * The gender of Patient
	 */
	@NotNull
	@Size(min = 1, max = 11)
	private String gender;

	/**
	 * The mobile of Patient
	 */
	private String mobile;

	/**
	 * The email of Patient
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The phone of Patient
	 */
	private String phone;

	/**
	 * The password of Patient
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The address of Patient
	 */
	private String address;

	/**
	 * The zip_code of Patient
	 */
	private String zip_code;

	/**
	 * The city of Patient
	 */
	private BigInteger city;

	/**
	 * The photo of Patient
	 */
	private String photo;

	/**
	 * The active of Patient
	 */
	private Boolean active;

	/**
	 * The lat of Patient
	 */
	private Double lat;

	/**
	 * The lon of Patient
	 */
	private Double lon;

	/**
	 * The user_agreement of Patient
	 */
	private Boolean user_agreement;

	/**
	 * The dependent of Patient
	 */
	private BigInteger dependent;

	/**
	 * The ytd_oop of Patient
	 */
	private Double ytd_oop;

	/**
	 * Get the id of Patient
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Patient
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the title of Patient
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of Patient
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the first_name of Patient
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of Patient
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of Patient
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of Patient
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the dob of Patient
	 * @return String
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Set the dob of Patient
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Get the gender of Patient
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the gender of Patient
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the mobile of Patient
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Set the mobile of Patient
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Get the email of Patient
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of Patient
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the phone of Patient
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the phone of Patient
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the password of Patient
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of Patient
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the address of Patient
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the address of Patient
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the zip_code of Patient
	 * @return String
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the zip_code of Patient
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * Get the city of Patient
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of Patient
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * Get the photo of Patient
	 * @return String
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Set the photo of Patient
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Get the active of Patient
	 * @return Boolean
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Set the active of Patient
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Get the lat of Patient
	 * @return Double
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * Set the lat of Patient
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * Get the lon of Patient
	 * @return Double
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * Set the lon of Patient
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * Get the user_agreement of Patient
	 * @return Boolean
	 */
	public Boolean getUserAgreement() {
		return user_agreement;
	}

	/**
	 * Set the user_agreement of Patient
	 * @param user_agreement the user_agreement to set
	 */
	public void setUserAgreement(Boolean user_agreement) {
		this.user_agreement = user_agreement;
	}

	/**
	 * Get the dependent of Patient
	 * @return BigInteger
	 */
	public BigInteger getDependent() {
		return dependent;
	}

	/**
	 * Set the dependent of Patient
	 * @param dependent the dependent to set
	 */
	public void setDependent(BigInteger dependent) {
		this.dependent = dependent;
	}

	/**
	 * Get the ytd_oop of Patient
	 * @return Double
	 */
	public Double getYtdOop() {
		return ytd_oop;
	}

	/**
	 * Set the ytd_oop of Patient
	 * @param ytd_oop the ytd_oop to set
	 */
	public void setYtdOop(Double ytd_oop) {
		this.ytd_oop = ytd_oop;
	}

}
