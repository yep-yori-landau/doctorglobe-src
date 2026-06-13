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
public class Corporatecompany {

	/**
	 * The id of Corporatecompany
	 */
	private BigInteger id;

	/**
	 * The name of Corporatecompany
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	/**
	 * The address_1 of Corporatecompany
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String address_1;

	/**
	 * The address_2 of Corporatecompany
	 */
	@Size(min = 1, max = 255)
	private String address_2;

	/**
	 * The zip_code of Corporatecompany
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String zip_code;

	/**
	 * The website of Corporatecompany
	 */
	private String website;

	/**
	 * The phone_1 of Corporatecompany
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String phone_1;

	/**
	 * The phone_2 of Corporatecompany
	 */
	private String phone_2;

	/**
	 * The email of Corporatecompany
	 */
	@NotNull
	@Size(min = 1, max = 255)
	@Email
	private String email;

	/**
	 * The description of Corporatecompany
	 */
	private String description;

	/**
	 * The whitelabel_url of Corporatecompany
	 */
	private String whitelabel_url;

	/**
	 * The minimum_amount_spread of Corporatecompany
	 */
	private Double minimum_amount_spread;

	/**
	 * The minimum_percentage_spread of Corporatecompany
	 */
	private Double minimum_percentage_spread;

	/**
	 * The currency of Corporatecompany
	 */
	@NotNull
	@Size(min = 3, max = 3)
	private String currency;

	/**
	 * The dg_commission of Corporatecompany
	 */
	private Integer dg_commission;

	/**
	 * The worker_incentive of Corporatecompany
	 */
	private Integer worker_incentive;

	/**
	 * The city of Corporatecompany
	 */
	@NotNull
	private BigInteger city;

	/**
	 * The association of Corporatecompany
	 */
	private BigInteger association;

	/**
	 * The theme of Corporatecompany
	 */
	@NotNull
	@Size(min = 1, max = 255)
	private String theme;

	/**
	 * The ein of Corporatecompany
	 */
	@Size(min = 0, max = 255)
	private String ein;

	/**
	 * The first_name of Corporatecompany
	 */
	@Size(min = 0, max = 255)
	private String first_name;

	/**
	 * The last_name of Corporatecompany
	 */
	@Size(min = 0, max = 255)
	private String last_name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the phone_1
	 */
	public String getPhone_1() {
		return phone_1;
	}

	/**
	 * @param phone_1 the phone_1 to set
	 */
	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	/**
	 * @return the phone_2
	 */
	public String getPhone_2() {
		return phone_2;
	}

	/**
	 * @param phone_2 the phone_2 to set
	 */
	public void setPhone_2(String phone_2) {
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
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the whitelabel_url
	 */
	public String getWhitelabelUrl() {
		return whitelabel_url;
	}

	/**
	 * @param whitelabel_url the whitelabel_url to set
	 */
	public void setWhitelabelUrl(String whitelabel_url) {
		this.whitelabel_url = whitelabel_url;
	}

	/**
	 * @return the minimum_amount_spread
	 */
	public Double getMinimumAmountSpread() {
		return minimum_amount_spread;
	}

	/**
	 * @param minimum_amount_spread the minimum_amount_spread to set
	 */
	public void setMinimumAmountSpread(Double minimum_amount_spread) {
		this.minimum_amount_spread = minimum_amount_spread;
	}

	/**
	 * @return the minimum_percentage_spread
	 */
	public Double getMinimumPercentageSpread() {
		return minimum_percentage_spread;
	}

	/**
	 * @param minimum_percentage_spread the minimum_percentage_spread to set
	 */
	public void setMinimumPercentageSpread(Double minimum_percentage_spread) {
		this.minimum_percentage_spread = minimum_percentage_spread;
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
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the corporate_company_dg_commission
	 */
	public Integer getDgCommission() {
		return dg_commission;
	}

	/**
	 * @param dg_commission the dg_commission to set
	 */
	public void setDgCommission(Integer dg_commission) {
		this.dg_commission = dg_commission;
	}

	/**
	 * @return the worker_incentive
	 */
	public Integer getWorkerIncentive() {
		return worker_incentive;
	}

	/**
	 * @param worker_incentive the worker_incentive to set
	 */
	public void setWorkerIncentive(Integer worker_incentive) {
		this.worker_incentive = worker_incentive;
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
	 * @return the association
	 */
	public BigInteger getAssociation() {
		return association;
	}

	/**
	 * @param association the association to set
	 */
	public void setAssociation(BigInteger association) {
		this.association = association;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the ein
	 */
	public String getEin() {
		return ein;
	}

	/**
	 * @param ein the ein to set
	 */
	public void setEin(String ein) {
		this.ein = ein;
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

}
