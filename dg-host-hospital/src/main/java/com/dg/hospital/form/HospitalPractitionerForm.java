package com.dg.hospital.form;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.hospital.model.HospitalPractitionerDetailModel;
import com.dg.hospital.model.PractitionerModel;

public class HospitalPractitionerForm{
	
	private static final Logger logger = LoggerFactory.getLogger(HospitalPractitionerForm.class);
	
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 32) 
	private String title;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String first_name;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String last_name;
  
	private String dob;

	@NotNull 
	@Size(min = 1, max = 11) 
	private String gender; 
	
	@NotNull
	private String mobile;

	@NotNull 
	@Size(min = 1, max = 255) 
	@Email
	private String email;
	 
	private String phone; 
	 
	private String address_1;	 
	 
	private String address_2;
	 
	private String zip_code;
	
	private BigInteger city;
	
	private String photo;
  
	private String description;	

	@NotNull 
	@Size(min = 1, max = 26) 
	private String usa_certification;	 
	
	private Boolean usa_training;
  
	private String graduation_dt;
	
	private String graduation_institution;
  
	private String specialty_dt; 
	 
	private String specialty_institution;
	
	@NotNull
	private String degree;

	@NotNull  
	private BigInteger type;
	
	private BigInteger role;
	
	@NotNull
	private String medical_license;
	
	@NotNull 
	private String currency;
	
	private BigDecimal insurance_cap;
    
    private String policy_file;
	
    @NotNull
	private BigInteger healthcareprovider;
	
	private BigInteger practitioner;
	
	private List<BigInteger> specialtyModel;
	
	private List<BigInteger> practitionerSpecialty;

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
	* @return the title
	*/
	public String getTitle() {
	 return title;
	}

	/**
   	* @param title the title to set
	*/
	public void setTitle(String title ) {
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
	public void setFirstName(String first_name ) {
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
	public void setLastName(String last_name ) {
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
	public void setDob(String dob ) {
		try{
			if(this.dob != ""){
				this.dob = dob;	 
			 }else{
				 this.dob = null;
			 }
		}catch(Exception ex){
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
	public void setGender(String gender ) {
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
	public void setMobile(String mobile ) {
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
	public void setEmail(String email ) {
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
	public void setPhone(String phone ) {
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
	public void setAddress_1(String address_1 ) {
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
	public void setAddress_2(String address_2 ) {
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
	public void setZipCode(String zip_code ) {
	 this.zip_code = zip_code;
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
	* @return the photo
	*/
	public String getPhoto() {
	 return photo;
	}

	/**
   	* @param photo the photo to set
	*/
	public void setPhoto(String photo ) {
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
	public void setDescription(String description ) {
	 this.description = description;
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
	public void setUsaCertification(String usa_certification ) {
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
	public void setUsaTraining(Boolean usa_training ) {
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
	public void setGraduationDt(String graduation_dt ) {
		if(graduation_dt != null && !graduation_dt.isEmpty()){
			this.graduation_dt = graduation_dt;
		}else{
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
	public void setGraduationInstitution(String graduation_institution ) {
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
	public void setSpecialtyDt(String specialty_dt ) {
		if(specialty_dt != null && !specialty_dt.isEmpty()){
			this.specialty_dt = specialty_dt;
		}else{
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
	public void setSpecialtyInstitution(String specialty_institution ) {
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
	public void setType(BigInteger type ) {
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
	public void setRole(BigInteger role ) {
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
	public void setDegree(String degree ) {
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
	public void setMedicalLicense(String medical_license ) {
	 this.medical_license = medical_license;
	}
	
	/**
	* @return the insurance_cap
	*/
	public BigDecimal getInsuranceCap() {
	return insurance_cap;
	}
	
	/**
   	* @param insurance_cap the insurance_cap to set
	*/
	public void setInsuranceCap(BigDecimal insurance_cap ) {
	 this.insurance_cap = insurance_cap;
	}
	
	/**
	* @return the currency
	*/
	public String getCurrency() {
	return currency;
	}
	
	/**
   	* @param currency the currency to set
	*/
	public void setCurrency(String currency ) {
	 this.currency = currency;
	}	
	
	/**
	* @return the policy_file
	*/
	public String getPolicyFile() {
	return policy_file;
	}
	
	/**
   	* @param policy_file the policy_file to set
	*/
	public void setPolicyFile(String policy_file ) {
		this.policy_file = policy_file;
	}
	
	/**
	* @return the healthcareprovider
	*/
	public BigInteger getHealthcareprovider() {
	 return healthcareprovider;
	}

	/**
   	* @param healthcareprovider the healthcareprovider to set
	*/
	public void setHealthcareprovider(BigInteger healthcareprovider ) {
	 this.healthcareprovider = healthcareprovider;
	}
	
	/**
	* @return the practitioner
	*/
	public BigInteger getPractitioner() {
	 return practitioner;
	}

	/**
   	* @param practitioner the practitioner to set
	*/
	public void setPractitioner(BigInteger practitioner ) {
	 this.practitioner = practitioner;
	}
	
	public List<BigInteger> getSpecialtyModel(){
		return specialtyModel;
	}
	
	public void setSpecialtyModel(List<BigInteger> specialtyModel){
		this.specialtyModel = specialtyModel;
	}
	
	public List<BigInteger> getPractitionerSpecialty(){
		return practitionerSpecialty;
	}
	
	public void setPractitionerSpecialty(List<BigInteger> practitionerSpecialty){
		this.practitionerSpecialty = practitionerSpecialty;
	}
	
	public void setFormPopulate(HospitalPractitionerDetailModel hpModel,PractitionerModel practitionerModel){
		if(hpModel.getId() != null){
			this.setId(hpModel.getId());			
			this.setTitle(hpModel.getTitle());			
			this.setFirstName(hpModel.getFirstName());
			this.setLastName(hpModel.getLastName());
			this.setMobile(hpModel.getMobile());
			this.setEmail(hpModel.getEmail());
			this.setInsuranceCap(hpModel.getInsuranceCap());
			this.setPolicyFile(hpModel.getPolicyFile());
			this.setPractitioner(hpModel.getPractitioner());
			this.setType(hpModel.getType());
			this.setDescription(hpModel.getDescription());
		}		
		if(practitionerModel.getId() != null){
			if(this.getTitle() == null || this.getTitle().length() == 0){
				this.setTitle(practitionerModel.getTitle());
			}
			if(this.getFirstName() == null || this.getFirstName().length() == 0){
				this.setFirstName(practitionerModel.getFirstName());
			}
			if(this.getLastName() == null || this.getLastName().length() == 0){
				this.setLastName(practitionerModel.getLastName());
			}
			logger.info("mobile {}",this.getMobile());
			if(this.getMobile() == null || this.getMobile().equals("")){
				this.setMobile(practitionerModel.getMobile());
			}
			if(this.getEmail() == null || this.getEmail().length() == 0){
				this.setEmail(practitionerModel.getEmail());
			}
			logger.info("description {}",this.getDescription());
			if(this.getDescription() == null ||  this.getDescription() == ""){
				this.setDescription(practitionerModel.getDescription());
			}			
			this.setGender(practitionerModel.getGender());
			this.setDob(practitionerModel.getDob());
			this.setPhoto(practitionerModel.getPhoto());
			this.setRole(practitionerModel.getRole());
			this.setPhone(practitionerModel.getPhone());
			this.setAddress_1(practitionerModel.getAddress_1());
			this.setAddress_2(practitionerModel.getAddress_2());
			this.setZipCode(practitionerModel.getZipCode());
			this.setCity(practitionerModel.getCity());
			this.setDegree(practitionerModel.getDegree());
			this.setMedicalLicense(practitionerModel.getMedicalLicense());
			this.setUsaCertification(practitionerModel.getUsaCertification());
			this.setUsaTraining(practitionerModel.getUsaTraining());			
		}
	}
	
}