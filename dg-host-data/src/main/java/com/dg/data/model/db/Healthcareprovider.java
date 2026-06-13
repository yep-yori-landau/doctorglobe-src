package com.dg.data.model.db;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Healthcareprovider DB Model
 * @author DoctorGlobe
 *
 */
public class Healthcareprovider {

	/**
	 * The id of Healthcareprovider
	 */
	private BigInteger id;

	/**
	 * The name of Healthcareprovider
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The address_1 of Healthcareprovider
	 */
	private String address_1;

	/**
	 * The address_2 of Healthcareprovider
	 */
	private String address_2;

	/**
	 * The zip_code of Healthcareprovider
	 */
	private String zip_code;

	/**
	 * The website of Healthcareprovider
	 */
	private String website;

	/**
	 * The contact_name of Healthcareprovider
	 */
	private String contact_name;

	/**
	 * The phone_1 of Healthcareprovider
	 */
	private String phone_1;

	/**
	 * The phone_2 of Healthcareprovider
	 */
	private String phone_2;

	/**
	 * The email of Healthcareprovider
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The fax of Healthcareprovider
	 */
	private String fax;

	/**
	 * The description of Healthcareprovider
	 */
	/**
	 * The description of Healthcareprovider
	 */
	private String description;

	/**
	 * The established of Healthcareprovider
	 */
	private String established;

	/**
	 * The building_commissioned of Healthcareprovider
	 */
	private String building_commissioned;

	/**
	 * The renovated of Healthcareprovider
	 */
	private String renovated;

	/**
	 * The affiliation of Healthcareprovider
	 */
	private String affiliation;

	/**
	 * The cms_certificate of Healthcareprovider
	 */
	private String cms_certificate;

	/**
	 * The npi of Healthcareprovider
	 */
	private String npi;

	/**
	 * The teaching_hospital of Healthcareprovider
	 */
	/**
	 * The teaching_hospital of Healthcareprovider
	 */
	private Boolean teaching_hospital;

	/**
	 * The readmission_rate of Healthcareprovider
	 */
	private Integer readmission_rate;

	/**
	 * The mortality_rate of Healthcareprovider
	 */
	private Integer mortality_rate;

	/**
	 * The infection_rate of Healthcareprovider
	 */
	private Integer infection_rate;

	/**
	 * The medical_lawsuit of Healthcareprovider
	 */
	private Boolean medical_lawsuit;

	/**
	 * The lat of Healthcareprovider
	 */
	private Double lat;

	/**
	 * The lon of Healthcareprovider
	 */
	private Double lon;

	/**
	 * The branch of Healthcareprovider
	 */
	private BigInteger branch;

	/**
	 * The chain of Healthcareprovider
	 */
	private BigInteger chain;

	/**
	 * The city of Healthcareprovider
	 */
	@NotNull
	private BigInteger city;

	/**
	 * The type of Healthcareprovider
	 */
	private String type;

	/**
	 * The currency of Healthcareprovider
	 */
	@NotNull
	private String currency;

	/**
	 * The cc_email of Healthcareprovider
	 */
	private Boolean cc_email;

	/**
	 * The insurance_cap of Healthcareprovider
	 */
	private BigDecimal insurance_cap;

	/**
	 * The policy_file of Healthcareprovider
	 */
	/**
	 * The policy_file of Healthcareprovider
	 */
	private String policy_file;

	/**
	 * The is_policy_covered_practitioners of Healthcareprovider
	 */
	private Boolean is_policy_covered_practitioners;

	/**
	 * The insurance_carrier of Healthcareprovider
	 */
	private String insurance_carrier;

	/**
	 * The policy_number of Healthcareprovider
	 */
	private String policy_number;

	/**
	 * The per_case_insurance_cap of Healthcareprovider
	 */
	private BigDecimal per_case_insurance_cap;

	/**
	 * The drg_id of Healthcareprovider
	 */
	@Size(min = 0, max = 10)
	private String drg_id;

	/**
	 * The hrr_description of Healthcareprovider
	 */
	@Size(min = 0, max = 255)
	private String hrr_description;

	/**
	 * The aha_id of Healthcareprovider
	 */
	private String aha_id;

	/**
	 * The aha_name of Healthcareprovider
	 */
	private String aha_name;

	/**
	 * The admin_title of Healthcareprovider
	 */
	private String admin_title;

	/**
	 * Get the id of Healthcareprovider
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Healthcareprovider
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Healthcareprovider
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Healthcareprovider
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the address_1 of Healthcareprovider
	 * @return String
	 */
	public String getAddress_1() {
		return address_1;
	}

	/**
	 * Set the address_1 of Healthcareprovider
	 * @param address_1 the address_1 to set
	 */
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	/**
	 * Get the address_2 of Healthcareprovider
	 * @return String
	 */
	public String getAddress_2() {
		return address_2;
	}

	/**
	 * Set the address_2 of Healthcareprovider
	 * @param address_2 the address_2 to set
	 */
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	/**
	 * Get the zip_code of Healthcareprovider
	 * @return String
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the zip_code of Healthcareprovider
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * Get the website of Healthcareprovider
	 * @return String
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Set the website of Healthcareprovider
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Get the contact_name of Healthcareprovider
	 * @return String
	 */
	public String getContactName() {
		return contact_name;
	}

	/**
	 * Set the contact_name of Healthcareprovider
	 * @param contact_name the contact_name to set
	 */
	public void setContactName(String contact_name) {
		this.contact_name = contact_name;
	}

	/**
	 * Get the phone_1 of Healthcareprovider
	 * @return String
	 */
	public String getPhone_1() {
		return phone_1;
	}

	/**
	 * Set the phone_1 of Healthcareprovider
	 * @param phone_1 the phone_1 to set
	 */
	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	/**
	 * Get the phone_2 of Healthcareprovider
	 * @return String
	 */
	public String getPhone_2() {
		return phone_2;
	}

	/**
	 * Set the phone_2 of Healthcareprovider
	 * @param phone_2 the phone_2 to set
	 */
	public void setPhone_2(String phone_2) {
		this.phone_2 = phone_2;
	}

	/**
	 * Get the email of Healthcareprovider
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of Healthcareprovider
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the fax of Healthcareprovider
	 * @return String
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Set the fax of Healthcareprovider
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Get the description of Healthcareprovider
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Healthcareprovider
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the established of Healthcareprovider
	 * @return String
	 */
	public String getEstablished() {
		return established;
	}

	/**
	 * Set the established of Healthcareprovider
	 * @param established the established to set
	 */
	public void setEstablished(String established) {
		if (established != "") {
			this.established = established;
		}
		else {
			this.established = null;
		}
	}

	/**
	 * Get the building_commissioned of Healthcareprovider
	 * @return String
	 */
	public String getBuildingCommissioned() {
		return building_commissioned;
	}

	/**
	 * Set the building_commissioned of Healthcareprovider
	 * @param building_commissioned the building_commissioned to set
	 */
	public void setBuildingCommissioned(String building_commissioned) {
		if (building_commissioned != "") {
			this.building_commissioned = building_commissioned;
		}
		else {
			this.building_commissioned = null;
		}
	}

	/**
	 * Get the renovated of Healthcareprovider
	 * @return String
	 */
	public String getRenovated() {
		return renovated;
	}

	/**
	 * Set the renovated of Healthcareprovider
	 * @param renovated the renovated to set
	 */
	public void setRenovated(String renovated) {
		if (renovated != "") {
			this.renovated = renovated;
		}
		else {
			this.renovated = null;
		}
	}

	/**
	 * Get the affiliation of Healthcareprovider
	 * @return String
	 */
	public String getAffiliation() {
		return affiliation;
	}

	/**
	 * Set the affiliation of Healthcareprovider
	 * @param affiliation the affiliation to set
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	/**
	 * Get the cms_certificate of Healthcareprovider
	 * @return String
	 */
	public String getCmsCertificate() {
		return cms_certificate;
	}

	/**
	 * Set the cms_certificate of Healthcareprovider
	 * @param cms_certificate the cms_certificate to set
	 */
	public void setCmsCertificate(String cms_certificate) {
		this.cms_certificate = cms_certificate;
	}

	/**
	 * Get the npi of Healthcareprovider
	 * @return String
	 */
	public String getNpi() {
		return npi;
	}

	/**
	 * Set the npi of Healthcareprovider
	 * @param npi the npi to set
	 */
	public void setNpi(String npi) {
		this.npi = npi;
	}

	/**
	 * Get the teaching_hospital of Healthcareprovider
	 * @return Boolean
	 */
	public Boolean getTeachingHospital() {
		return teaching_hospital;
	}

	/**
	 * Set the teaching_hospital of Healthcareprovider
	 * @param teaching_hospital the teaching_hospital to set
	 */
	public void setTeachingHospital(Boolean teaching_hospital) {
		this.teaching_hospital = teaching_hospital;
	}

	/**
	 * Get the readmission_rate of Healthcareprovider
	 * @return Integer
	 */
	public Integer getReadmissionRate() {
		return readmission_rate;
	}

	/**
	 * Set the readmission_rate of Healthcareprovider
	 * @param readmission_rate the readmission_rate to set
	 */
	public void setReadmissionRate(Integer readmission_rate) {
		this.readmission_rate = readmission_rate;
	}

	/**
	 * Get the mortality_rate of Healthcareprovider
	 * @return Integer
	 */
	public Integer getMortalityRate() {
		return mortality_rate;
	}

	/**
	 * Set the mortality_rate of Healthcareprovider
	 * @param mortality_rate the mortality_rate to set
	 */
	public void setMortalityRate(Integer mortality_rate) {
		this.mortality_rate = mortality_rate;
	}

	/**
	 * Get the infection_rate of Healthcareprovider
	 * @return Integer
	 */
	public Integer getInfectionRate() {
		return infection_rate;
	}

	/**
	 * Set the infection_rate of Healthcareprovider
	 * @param infection_rate the infection_rate to set
	 */
	public void setInfectionRate(Integer infection_rate) {
		this.infection_rate = infection_rate;
	}

	/**
	 * Get the medical_lawsuit of Healthcareprovider
	 * @return Boolean
	 */
	public Boolean getMedicalLawsuit() {
		return medical_lawsuit;
	}

	/**
	 * Set the medical_lawsuit of Healthcareprovider
	 * @param medical_lawsuit the medical_lawsuit to set
	 */
	public void setMedicalLawsuit(Boolean medical_lawsuit) {
		this.medical_lawsuit = medical_lawsuit;
	}

	/**
	 * Get the lat of Healthcareprovider
	 * @return Double
	 */
	public Double getLat() {
		return lat;
	}

	/**
	 * Set the lat of Healthcareprovider
	 * @param lat the lat to set
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}

	/**
	 * Get the lon of Healthcareprovider
	 * @return Double
	 */
	public Double getLon() {
		return lon;
	}

	/**
	 * Set the lon of Healthcareprovider
	 * @param lon the lon to set
	 */
	public void setLon(Double lon) {
		this.lon = lon;
	}

	/**
	 * Get the branch of Healthcareprovider
	 * @return BigInteger
	 */
	public BigInteger getBranch() {
		return branch;
	}

	/**
	 * Set the branch of Healthcareprovider
	 * @param branch the branch to set
	 */
	public void setBranch(BigInteger branch) {
		this.branch = branch;
	}

	/**
	 * Get the chain of Healthcareprovider
	 * @return BigInteger
	 */
	public BigInteger getChain() {
		return chain;
	}

	/**
	 * Set the chain of Healthcareprovider
	 * @param chain the chain to set
	 */
	public void setChain(BigInteger chain) {
		this.chain = chain;
	}

	/**
	 * Get the city of Healthcareprovider
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of Healthcareprovider
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * Get the type of Healthcareprovider
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of Healthcareprovider
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the currency of Healthcareprovider
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of Healthcareprovider
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the cc_email of Healthcareprovider
	 * @return Boolean
	 */
	public Boolean getCcEmail() {
		return cc_email;
	}

	/**
	 * Set the cc_email of Healthcareprovider
	 * @param cc_email the cc_email to set
	 */
	public void setCcEmail(Boolean cc_email) {
		this.cc_email = cc_email;
	}

	/**
	 * Get the insurance_cap of Healthcareprovider
	 * @return BigDecimal
	 */
	public BigDecimal getInsuranceCap() {
		return insurance_cap;
	}

	/**
	 * Set the insurance_cap of Healthcareprovider
	 * @param insurance_cap the insurance_cap to set
	 */
	public void setInsuranceCap(BigDecimal insurance_cap) {
		this.insurance_cap = insurance_cap;
	}

	/**
	 * Get the policy_file of Healthcareprovider
	 * @return String
	 */
	public String getPolicyFile() {
		return policy_file;
	}

	/**
	 * Set the policy_file of Healthcareprovider
	 * @param policy_file the policy_file to set
	 */
	public void setPolicyFile(String policy_file) {
		this.policy_file = policy_file;
	}

	/**
	 * Get the is_policy_covered_practitioners of Healthcareprovider
	 * @return Boolean
	 */
	public Boolean getIsPolicyCoveredPractitioners() {
		return is_policy_covered_practitioners;
	}

	/**
	 * Set the is_policy_covered_practitioners of Healthcareprovider
	 * @param is_policy_covered_practitioners the
	 * is_policy_covered_practitioners to set
	 */
	public void setIsPolicyCoveredPractitioners(
			Boolean is_policy_covered_practitioners) {
		this.is_policy_covered_practitioners = is_policy_covered_practitioners;
	}

	/**
	 * Get the insurance_carrier of Healthcareprovider
	 * @return String
	 */
	public String getInsuranceCarrier() {
		return insurance_carrier;
	}

	/**
	 * Set the insurance_carrier of Healthcareprovider
	 * @param insurance_carrier the insurance_carrier to set
	 */
	public void setInsuranceCarrier(String insurance_carrier) {
		this.insurance_carrier = insurance_carrier;
	}

	/**
	 * Get the policy_number of Healthcareprovider
	 * @return String
	 */
	public String getPolicyNumber() {
		return policy_number;
	}

	/**
	 * Set the policy_number of Healthcareprovider
	 * @param policy_number the policy_number to set
	 */
	public void setPolicyNumber(String policy_number) {
		this.policy_number = policy_number;
	}

	/**
	 * Get the per_case_insurance_cap of Healthcareprovider
	 * @return BigDecimal
	 */
	public BigDecimal getPerCaseInsuranceCap() {
		return per_case_insurance_cap;
	}

	/**
	 * Set the per_case_insurance_cap of Healthcareprovider
	 * @param per_case_insurance_cap the per_case_insurance_cap to set
	 */
	public void setPerCaseInsuranceCap(BigDecimal per_case_insurance_cap) {
		this.per_case_insurance_cap = per_case_insurance_cap;
	}

	/**
	 * Get the drg_id of Healthcareprovider
	 * @return String
	 */
	public String getDrgId() {
		return drg_id;
	}

	/**
	 * Set the drg_id of Healthcareprovider
	 * @param drg_id the drg_id to set
	 */
	public void setDrgId(String drg_id) {
		this.drg_id = drg_id;
	}

	/**
	 * Get the hrr_description of Healthcareprovider
	 * @return String
	 */
	public String getHrrDescription() {
		return hrr_description;
	}

	/**
	 * Set the hrr_description of Healthcareprovider
	 * @param hrr_description the hrr_description to set
	 */
	public void setHrrDescription(String hrr_description) {
		this.hrr_description = hrr_description;
	}

	/**
	 * Get the aha_id of Healthcareprovider
	 * @return String
	 */
	public String getAhaId() {
		return aha_id;
	}

	/**
	 * Set the aha_id of Healthcareprovider
	 * @param aha_id the aha_id to set
	 */
	public void setAhaId(String aha_id) {
		this.aha_id = aha_id;
	}

	/**
	 * Get the aha_name of Healthcareprovider
	 * @return String
	 */
	public String getAhaName() {
		return aha_name;
	}

	/**
	 * Set the aha_name of Healthcareprovider
	 * @param aha_name the aha_name to set
	 */
	public void setAhaName(String aha_name) {
		this.aha_name = aha_name;
	}

	/**
	 * Get the admin_title of Healthcareprovider
	 * @return String
	 */
	public String getAdminTitle() {
		return admin_title;
	}

	/**
	 * Set the admin_title of Healthcareprovider
	 * @param admin_title the admin_title to set
	 */
	public void setAdminTitle(String admin_title) {
		this.admin_title = admin_title;
	}	

}
