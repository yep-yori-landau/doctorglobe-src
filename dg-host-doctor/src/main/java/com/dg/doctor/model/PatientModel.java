/**
 * 
 */
package com.dg.doctor.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author kkowlgi
 * 
 */

public class PatientModel {

	private BigInteger id;
	
	private String title;

	@NotNull
	@Size(min = 3, max = 255)
	private String first_name;

	@NotNull
	@Size(min = 3, max = 255)
	private String last_name;
	
	private String dob;

	@NotNull
	private String gender;
	
	private String mobile;

	@NotNull
	@Size(min = 3, max = 255)
	@Email
	private String email;
	
	private String phone;

	@NotNull
	@Size(min = 6, max = 32)
	private String password;

	private Integer company;	
	
	private Boolean active;
	
	private String address;
	
	private String zip_code;
	
	private BigInteger city;
	
	private String photo;
	
	private String url;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param title
	 *            the title to set
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
	 * @param first_name
	 *            the first_name to set
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
	 * @param last_name
	 *            the last_name to set
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
	 * @param dob
	 *            the dob to set
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
	 * @param gender
	 *            the gender to set
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
	 * @param mobile
	 *            the mobile to set
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
	 * @param email
	 *            the email to set
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
	 * @param phone
	 *            the phone to set
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
	 * @param password
	 *            the password to set
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
	public void setAddress(String address ) {
	 this.address = address;
	}
	
	/**
   	* @param zip_code the zip_code to set
	*/
	public void setZipCode(String zip_code ) {
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
	public void setCity(BigInteger city ) {
	 this.city = city;
	}
	
	/**
   	* @param photo the photo to set
	*/
	public void setPhoto(String photo ) {
	 this.photo = photo;
	}
	
	/**
	* @return the photo
	*/
	public String getPhoto() {
	 return photo;
	}

	/**
	 * @return the company
	 */
	public Integer getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Integer company) {
		this.company = company;
	}
		
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	/**
   	* @param url the url to set
	*/
	public void setUrl(String url ) {
	 this.url = url;
	}
	
	/**
	* @return the url
	*/
	public String getUrl() {
	 return url;
	}

}