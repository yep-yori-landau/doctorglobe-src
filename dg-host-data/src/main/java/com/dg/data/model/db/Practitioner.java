/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * Practitioner DB Model
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
	 * The degree of Practitioner
	 */
	private String degree;

	/**
	 * The medical_license of Practitioner
	 */
	private String medical_license;

	/**
	 * The city of Practitioner
	 */
	private BigInteger city;

	/**
	 * Get the id of Practitioner
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Practitioner
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the title of Practitioner
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title of Practitioner
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the first_name of Practitioner
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of Practitioner
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of Practitioner
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of Practitioner
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Get the dob of Practitioner
	 * @return String
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Set the dob of Practitioner
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		try {
			if (dob != null && !dob.isEmpty()) {
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
	 * Get the gender of Practitioner
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set the gender of Practitioner
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Get the mobile of Practitioner
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Set the mobile of Practitioner
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Get the email of Practitioner
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of Practitioner
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the phone of Practitioner
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the phone of Practitioner
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the address_1 of Practitioner
	 * @return String
	 */
	public String getAddress_1() {
		return address_1;
	}

	/**
	 * Set the address_1 of Practitioner
	 * @param address_1 the address_1 to set
	 */
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	/**
	 * Get the address_2 of Practitioner
	 * @return String
	 */
	public String getAddress_2() {
		return address_2;
	}

	/**
	 * Set the address_2 of Practitioner
	 * @param address_2 the address_2 to set
	 */
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	/**
	 * Get the zip_code of Practitioner
	 * @return String
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the zip_code of Practitioner
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * Get the photo of Practitioner
	 * @return String
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Set the photo of Practitioner
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Get the description of Practitioner
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Practitioner
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the password of Practitioner
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of Practitioner
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the usa_certification of Practitioner
	 * @return String
	 */
	public String getUsaCertification() {
		return usa_certification;
	}

	/**
	 * Set the usa_certification of Practitioner
	 * @param usa_certification the usa_certification to set
	 */
	public void setUsaCertification(String usa_certification) {
		this.usa_certification = usa_certification;
	}

	/**
	 * Get the usa_training of Practitioner
	 * @return Boolean
	 */
	public Boolean getUsaTraining() {
		return usa_training;
	}

	/**
	 * Set the usa_training of Practitioner
	 * @param usa_training the usa_training to set
	 */
	public void setUsaTraining(Boolean usa_training) {
		this.usa_training = usa_training;
	}

	/**
	 * Get the graduation_dt of Practitioner
	 * @return String
	 */
	public String getGraduationDt() {
		return graduation_dt;
	}

	/**
	 * Set the graduation_dt of Practitioner
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
	 * Get the graduation_institution of Practitioner
	 * @return String
	 */
	public String getGraduationInstitution() {
		return graduation_institution;
	}

	/**
	 * Set the graduation_institution of Practitioner
	 * @param graduation_institution the graduation_institution to set
	 */
	public void setGraduationInstitution(String graduation_institution) {
		this.graduation_institution = graduation_institution;
	}

	/**
	 * Get the specialty_dt of Practitioner
	 * @return String
	 */
	public String getSpecialtyDt() {
		return specialty_dt;
	}

	/**
	 * Set the specialty_dt of Practitioner
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
	 * Get the specialty_institution of Practitioner
	 * @return String
	 */
	public String getSpecialtyInstitution() {
		return specialty_institution;
	}

	/**
	 * Set the specialty_institution of Practitioner
	 * @param specialty_institution the specialty_institution to set
	 */
	public void setSpecialtyInstitution(String specialty_institution) {
		this.specialty_institution = specialty_institution;
	}

	/**
	 * Get the type of Practitioner
	 * @return BigInteger
	 */
	public BigInteger getType() {
		return type;
	}

	/**
	 * Set the type of Practitioner
	 * @param type the type to set
	 */
	public void setType(BigInteger type) {
		this.type = type;
	}

	/**
	 * Get the role of Practitioner
	 * @return BigInteger
	 */
	public BigInteger getRole() {
		return role;
	}

	/**
	 * Set the role of Practitioner
	 * @param role the role to set
	 */
	public void setRole(BigInteger role) {
		this.role = role;
	}

	/**
	 * Get the degree of Practitioner
	 * @return String
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * Set the degree of Practitioner
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * Get the medical_license of Practitioner
	 * @return String
	 */
	public String getMedicalLicense() {
		return medical_license;
	}

	/**
	 * Set the medical_license of Practitioner
	 * @param medical_license the medical_license to set
	 */
	public void setMedicalLicense(String medical_license) {
		this.medical_license = medical_license;
	}

	/**
	 * Get the city of Practitioner
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of Practitioner
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

}
