package com.dg.hospital.form;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class HospitalForm{
	
	private BigInteger id;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String name;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String address_1; 
	 
	private String address_2;

	@NotNull 
	@Size(min = 1, max = 255) 
	private String zip_code; 
	 
	private String website; 
	
	private String contact_name; 
	 
	private String phone_1; 
	 
	private String phone_2;

	@NotNull 
	@Size(min = 1, max = 255) 
	@Email
	private String email; 
	
	private String fax;
  
	private String description;
  
	private String established;
  
	private String building_commissioned;
  
	private String renovated; 
	
	private String affiliation; 
	
	private String cms_certificate; 
	 
	private String npi; 
	
	private Boolean teaching_hospital;
  
	private Integer readmission_rate;
  
	private Integer mortality_rate;
  
	private Integer infection_rate; 
	
	private Boolean medical_lawsuit;
  
	private Double lat;
  
	private Double lon;
  
	private BigInteger branch;
  
	private BigInteger chain;	

	@NotNull  
	private BigInteger city;
	
	private String us_certified;
	
	private String type;

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
	* @return the name
	*/
	public String getName() {
	 return name;
	}

	/**
   	* @param name the name to set
	*/
	public void setName(String name ) {
	 this.name = name;
	}

	/**
	* @return the address_1
	*/
	public String getAddress1() {
	 return address_1;
	}

	/**
   	* @param address_1 the address_1 to set
	*/
	public void setAddress1(String address_1 ) {
	 this.address_1 = address_1;
	}

	/**
	* @return the address_2
	*/
	public String getAddress2() {
	 return address_2;
	}

	/**
   	* @param address_2 the address_2 to set
	*/
	public void setAddress2(String address_2 ) {
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
	* @return the website
	*/
	public String getWebsite() {
	 return website;
	}

	/**
   	* @param website the website to set
	*/
	public void setWebsite(String website ) {
	 this.website = website;
	}

	/**
	* @return the contact_name
	*/
	public String getContactName() {
	 return contact_name;
	}

	/**
   	* @param contact_name the contact_name to set
	*/
	public void setContactName(String contact_name ) {
	 this.contact_name = contact_name;
	}

	/**
	* @return the phone_1
	*/
	public String getPhone1() {
	 return phone_1;
	}

	/**
   	* @param phone_1 the phone_1 to set
	*/
	public void setPhone1(String phone_1 ) {
	 this.phone_1 = phone_1;
	}

	/**
	* @return the phone_2
	*/
	public String getPhone2() {
	 return phone_2;
	}

	/**
   	* @param phone_2 the phone_2 to set
	*/
	public void setPhone2(String phone_2 ) {
	 this.phone_2 = phone_2;
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
	* @return the fax
	*/
	public String getFax() {
	 return fax;
	}

	/**
   	* @param fax the fax to set
	*/
	public void setFax(String fax ) {
	 this.fax = fax;
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
	* @return the established
	*/
	public String getEstablished() {
	 return established;
	}

	/**
   	* @param established the established to set
	*/
	public void setEstablished(String established ) {
		if(established != ""){
			this.established = established;
		}else{
			this.established = null;
		}	 
	}

	/**
	* @return the building_commissioned
	*/
	public String getBuildingCommissioned() {
	 return building_commissioned;
	}

	/**
   	* @param building_commissioned the building_commissioned to set
	*/
	public void setBuildingCommissioned(String building_commissioned ) {
		if(building_commissioned != ""){
			this.building_commissioned = building_commissioned;
		}else{
			this.building_commissioned = null;
		}
	}

	/**
	* @return the renovated
	*/
	public String getRenovated() {
	 return renovated;
	}

	/**
   	* @param renovated the renovated to set
	*/
	public void setRenovated(String renovated ) {
		if(renovated != ""){
			this.renovated = renovated;
		}else{
			this.renovated = null;
		}
	}

	/**
	* @return the affiliation
	*/
	public String getAffiliation() {
	 return affiliation;
	}

	/**
   	* @param affiliation the affiliation to set
	*/
	public void setAffiliation(String affiliation ) {
	 this.affiliation = affiliation;
	}

	/**
	* @return the cms_certificate
	*/
	public String getCmsCertificate() {
	 return cms_certificate;
	}

	/**
   	* @param cms_certificate the cms_certificate to set
	*/
	public void setCmsCertificate(String cms_certificate ) {
	 this.cms_certificate = cms_certificate;
	}

	/**
	* @return the npi
	*/
	public String getNpi() {
	 return npi;
	}

	/**
   	* @param npi the npi to set
	*/
	public void setNpi(String npi ) {
	 this.npi = npi;
	}

	/**
	* @return the teaching_hospital
	*/
	public Boolean getTeachingHospital() {
	 return teaching_hospital;
	}

	/**
   	* @param teaching_hospital the teaching_hospital to set
	*/
	public void setTeachingHospital(Boolean teaching_hospital ) {
	 this.teaching_hospital = teaching_hospital;
	}

	/**
	* @return the readmission_rate
	*/
	public Integer getReadmissionRate() {
	 return readmission_rate;
	}

	/**
   	* @param readmission_rate the readmission_rate to set
	*/
	public void setReadmissionRate(Integer readmission_rate ) {
	 this.readmission_rate = readmission_rate;
	}

	/**
	* @return the mortality_rate
	*/
	public Integer getMortalityRate() {
	 return mortality_rate;
	}

	/**
   	* @param mortality_rate the mortality_rate to set
	*/
	public void setMortalityRate(Integer mortality_rate ) {
	 this.mortality_rate = mortality_rate;
	}

	/**
	* @return the infection_rate
	*/
	public Integer getInfectionRate() {
	 return infection_rate;
	}

	/**
   	* @param infection_rate the infection_rate to set
	*/
	public void setInfectionRate(Integer infection_rate ) {
	 this.infection_rate = infection_rate;
	}

	/**
	* @return the medical_lawsuit
	*/
	public Boolean getMedicalLawsuit() {
	 return medical_lawsuit;
	}

	/**
   	* @param medical_lawsuit the medical_lawsuit to set
	*/
	public void setMedicalLawsuit(Boolean medical_lawsuit ) {
	 this.medical_lawsuit = medical_lawsuit;
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
	public void setLat(Double lat ) {
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
	public void setLon(Double lon ) {
	 this.lon = lon;
	}

	/**
	* @return the branch
	*/
	public BigInteger getBranch() {
	 return branch;
	}

	/**
   	* @param branch the branch to set
	*/
	public void setBranch(BigInteger branch ) {
	 this.branch = branch;
	}

	/**
	* @return the chain
	*/
	public BigInteger getChain() {
	 return chain;
	}

	/**
   	* @param chain the chain to set
	*/
	public void setChain(BigInteger chain ) {
	 this.chain = chain;
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
	* @return the us_certified
	*/
	public String getUsCertified() {
	 return us_certified;
	}

	/**
   	* @param us_certified the us_certified to set
	*/
	public void setUsCertified(String us_certified ) {
		if(us_certified != ""){
			this.us_certified = us_certified;
		}else{
			this.us_certified = null;
		}
	}
	
	/**
	* @return the type
	*/
	public String getType() {
	return type;
	}
	
	/**
   	* @param type the type to set
	*/
	public void setType(String type ) {
	 this.type = type;
	}
}