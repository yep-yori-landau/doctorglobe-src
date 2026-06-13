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
public class Practitioner {

	/**
	 * The id of Practitioner
	 */
	private BigInteger id;

	/**
	 * The title of Practitioner
	 */
	@NotNull
	@Size(min = 1, max = 32)
	private String title;

	/**
	 * The first_name of Practitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String first_name;

	/**
	 * The last_name of Practitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String last_name;

	/**
	 * The dob of Practitioner
	 */
	private String dob;

	/**
	 * The gender of Practitioner
	 */
	@NotNull
	@Size(min = 1, max = 11)
	private String gender;

	/**
	 * The mobile of Practitioner
	 */
	@NotNull
	private String mobile;

	/**
	 * The email of Practitioner
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The phone of Practitioner
	 */
	private String phone;

	/**
	 * The address_1 of Practitioner
	 */
	private String address_1;

	/**
	 * The address_2 of Practitioner
	 */
	private String address_2;

	/**
	 * The zip_code of Practitioner
	 */
	private String zip_code;

	/**
	 * The photo of Practitioner
	 */
	private String photo;

	/**
	 * The description of Practitioner
	 */
	private String description;

	/**
	 * The password of Practitioner
	 */
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	/**
	 * The usa_certification of Practitioner
	 */
	@NotNull
	@Size(min = 1, max = 26)
	private String usa_certification;

	/**
	 * The usa_training of Practitioner
	 */
	private Boolean usa_training;

	/**
	 * The graduation_dt of Practitioner
	 */
	private String graduation_dt;

	/**
	 * The graduation_institution of Practitioner
	 */
	private String graduation_institution;

	/**
	 * The specialty_dt of Practitioner
	 */
	private String specialty_dt;

	/**
	 * The specialty_institution of Practitioner
	 */
	private String specialty_institution;

	/**
	 * The degree of Practitioner
	 */
	private String degree;

	/**
	 * The type of Practitioner
	 */
	@NotNull
	private BigInteger type;

	/**
	 * The role of Practitioner
	 */
	@NotNull
	private BigInteger role;

	/**
	 * The medical_license of Practitioner
	 */
	private String medical_license;

	/**
	 * The city of Practitioner
	 */
	private BigInteger city;

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
		try {
			if (this.dob != "") {
				this.dob = dob;
			}
			else {
				this.dob = null;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
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
	 * @return the address_1
	 */
	public String getAddress_1() {
		return address_1;
	}

	/**
	 * @param address_1 the address_1 to set
	 */
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	/**
	 * @return the address_2
	 */
	public String getAddress_2() {
		return address_2;
	}

	/**
	 * @param address_2 the address_2 to set
	 */
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	/**
	 * @return the zip_code
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the usa_certification
	 */
	public String getUsaCertification() {
		return usa_certification;
	}

	/**
	 * @param usa_certification the usa_certification to set
	 */
	public void setUsaCertification(String usa_certification) {
		this.usa_certification = usa_certification;
	}

	/**
	 * @return the usa_training
	 */
	public Boolean getUsaTraining() {
		return usa_training;
	}

	/**
	 * @param usa_training the usa_training to set
	 */
	public void setUsaTraining(Boolean usa_training) {
		this.usa_training = usa_training;
	}

	/**
	 * @return the graduation_dt
	 */
	public String getGraduationDt() {
		return graduation_dt;
	}

	/**
	 * @param graduation_dt the graduation_dt to set
	 */
	public void setGraduationDt(String graduation_dt) {
		if (graduation_dt != null && !graduation_dt.isEmpty()) {
			this.graduation_dt = graduation_dt;
		}
		else {
			this.graduation_dt = null;
		}
	}

	/**
	 * @return the graduation_institution
	 */
	public String getGraduationInstitution() {
		return graduation_institution;
	}

	/**
	 * @param graduation_institution the graduation_institution to set
	 */
	public void setGraduationInstitution(String graduation_institution) {
		this.graduation_institution = graduation_institution;
	}

	/**
	 * @return the specialty_dt
	 */
	public String getSpecialtyDt() {
		return specialty_dt;
	}

	/**
	 * @param specialty_dt the specialty_dt to set
	 */
	public void setSpecialtyDt(String specialty_dt) {
		if (specialty_dt != null && !specialty_dt.isEmpty()) {
			this.specialty_dt = specialty_dt;
		}
		else {
			this.specialty_dt = null;
		}
	}

	/**
	 * @return the specialty_institution
	 */
	public String getSpecialtyInstitution() {
		return specialty_institution;
	}

	/**
	 * @param specialty_institution the specialty_institution to set
	 */
	public void setSpecialtyInstitution(String specialty_institution) {
		this.specialty_institution = specialty_institution;
	}

	/**
	 * @return the type
	 */
	public BigInteger getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(BigInteger type) {
		this.type = type;
	}

	/**
	 * @return the role
	 */
	public BigInteger getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(BigInteger role) {
		this.role = role;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the medical_license
	 */
	public String getMedicalLicense() {
		return medical_license;
	}

	/**
	 * @param medical_license the medical_license to set
	 */
	public void setMedicalLicense(String medical_license) {
		this.medical_license = medical_license;
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
}
