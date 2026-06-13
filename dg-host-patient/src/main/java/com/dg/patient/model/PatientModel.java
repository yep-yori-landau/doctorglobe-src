/**
 * 
 */
package com.dg.patient.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author DoctorGlobe
 * 
 */
public class PatientModel {

	/**
	 * The id of PatientModel
	 */
	private BigInteger id;

	/**
	 * The title of PatientModel
	 */
	@Size(min = 0, max = 32)
	private String title;

	/**
	 * The first_name of PatientModel
	 */
	@NotNull
	@Size(min = 1, max = 100)
	private String first_name;

	/**
	 * The last_name of PatientModel
	 */
	@NotNull
	@Size(min = 1, max = 100)
	private String last_name;

	/**
	 * The dob of PatientModel
	 */
	private String dob;

	/**
	 * The gender of PatientModel
	 */
	@NotNull
	private String gender;

	/**
	 * The mobile of PatientModel
	 */
	private String mobile;

	/**
	 * The email of PatientModel
	 */
	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;

	/**
	 * The phone of PatientModel
	 */
	private String phone;

	/**
	 * The password of PatientModel
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The active of PatientModel
	 */
	private Boolean active;

	/**
	 * The address of PatientModel
	 */
	private String address;

	/**
	 * The zip_code of PatientModel
	 */
	private String zip_code;

	/**
	 * The city of PatientModel
	 */
	private BigInteger city;

	/**
	 * The photo of PatientModel
	 */
	private String photo;

	/**
	 * The lat of PatientModel
	 */
	private Double lat;

	/**
	 * The lon of PatientModel
	 */
	private Double lon;

	/**
	 * The user_agreement of PatientModel
	 */
	private Boolean user_agreement;

	/**
	 * The dependent of PatientModel
	 */
	private BigInteger dependent;

	/**
	 * The ytd_oop of PatientModel
	 */
	private Double ytd_oop;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * @return the zip_code
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * @return the city
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the lat
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * @return the user_agreement
	 */
	public Boolean getUserAgreement() {
		return user_agreement;
	}

	/**
	 * @param user_agreement the user_agreement to set
	 */
	public void setUserAgreement(Boolean user_agreement) {
		this.user_agreement = user_agreement;
	}

	/**
	 * @return the dependent
	 */
	public BigInteger getDependent() {
		return dependent;
	}

	/**
	 * @param dependent the dependent to set
	 */
	public void setDependent(BigInteger dependent) {
		this.dependent = dependent;
	}

	/**
	 * @return the ytd_oop
	 */
	public Double getYtdOop() {
		return ytd_oop;
	}

	/**
	 * @param ytd_oop the ytd_oop to set
	 */
	public void setYtdOop(Double ytd_oop) {
		this.ytd_oop = ytd_oop;
	}

}