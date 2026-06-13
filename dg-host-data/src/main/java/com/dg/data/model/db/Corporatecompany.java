/**
 * 
 */
package com.dg.data.model.db;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Corporatecompany DB Model
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
	@NotNull
	@Size(min = 1, max = 255)
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
	 * Get the id of Corporatecompany
	 * @return BigInteger
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * Set the id of Corporatecompany
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * Get the name of Corporatecompany
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of Corporatecompany
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the address_1 of Corporatecompany
	 * @return String
	 */
	public String getAddress_1() {
		return address_1;
	}

	/**
	 * Set the address_1 of Corporatecompany
	 * @param address_1 the address_1 to set
	 */
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	/**
	 * Get the address_2 of Corporatecompany
	 * @return String
	 */
	public String getAddress_2() {
		return address_2;
	}

	/**
	 * Set the address_2 of Corporatecompany
	 * @param address_2 the address_2 to set
	 */
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	/**
	 * Get the zip_code of Corporatecompany
	 * @return String
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the zip_code of Corporatecompany
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	/**
	 * Get the website of Corporatecompany
	 * @return String
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Set the website of Corporatecompany
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Get the phone_1 of Corporatecompany
	 * @return String
	 */
	public String getPhone_1() {
		return phone_1;
	}

	/**
	 * Set the phone_1 of Corporatecompany
	 * @param phone_1 the phone_1 to set
	 */
	public void setPhone_1(String phone_1) {
		this.phone_1 = phone_1;
	}

	/**
	 * Get the phone_2 of Corporatecompany
	 * @return String
	 */
	public String getPhone_2() {
		return phone_2;
	}

	/**
	 * Set the phone_2 of Corporatecompany
	 * @param phone_2 the phone_2 to set
	 */
	public void setPhone_2(String phone_2) {
		this.phone_2 = phone_2;
	}

	/**
	 * Get the email of Corporatecompany
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of Corporatecompany
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the description of Corporatecompany
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of Corporatecompany
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the whitelabel_url of Corporatecompany
	 * @return String
	 */
	public String getWhitelabelUrl() {
		return whitelabel_url;
	}

	/**
	 * Set the whitelabel_url of Corporatecompany
	 * @param whitelabel_url the whitelabel_url to set
	 */
	public void setWhitelabelUrl(String whitelabel_url) {
		this.whitelabel_url = whitelabel_url;
	}

	/**
	 * Get the minimum_amount_spread of Corporatecompany
	 * @return Double
	 */
	public Double getMinimumAmountSpread() {
		return minimum_amount_spread;
	}

	/**
	 * Set the minimum_amount_spread of Corporatecompany
	 * @param minimum_amount_spread the minimum_amount_spread to set
	 */
	public void setMinimumAmountSpread(Double minimum_amount_spread) {
		this.minimum_amount_spread = minimum_amount_spread;
	}

	/**
	 * Get the minimum_percentage_spread of Corporatecompany
	 * @return Double
	 */
	public Double getMinimumPercentageSpread() {
		return minimum_percentage_spread;
	}

	/**
	 * Set the minimum_percentage_spread of Corporatecompany
	 * @param minimum_percentage_spread the minimum_percentage_spread to set
	 */
	public void setMinimumPercentageSpread(Double minimum_percentage_spread) {
		this.minimum_percentage_spread = minimum_percentage_spread;
	}

	/**
	 * Get the currency of Corporatecompany
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of Corporatecompany
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the dg_commission of Corporatecompany
	 * @return Integer
	 */
	public Integer getDgCommission() {
		return dg_commission;
	}

	/**
	 * Set the dg_commission of Corporatecompany
	 * @param dg_commission the dg_commission to set
	 */
	public void setDgCommission(Integer dg_commission) {
		this.dg_commission = dg_commission;
	}

	/**
	 * Get the worker_incentive of Corporatecompany
	 * @return Integer
	 */
	public Integer getWorkerIncentive() {
		return worker_incentive;
	}

	/**
	 * Set the worker_incentive of Corporatecompany
	 * @param worker_incentive the worker_incentive to set
	 */
	public void setWorkerIncentive(Integer worker_incentive) {
		this.worker_incentive = worker_incentive;
	}

	/**
	 * Get the city of Corporatecompany
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of Corporatecompany
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * Get the association of Corporatecompany
	 * @return BigInteger
	 */
	public BigInteger getAssociation() {
		return association;
	}

	/**
	 * Set the association of Corporatecompany
	 * @param association the association to set
	 */
	public void setAssociation(BigInteger association) {
		this.association = association;
	}

	/**
	 * Get the theme of Corporatecompany
	 * @return String
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * Set the theme of Corporatecompany
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * Get the ein of Corporatecompany
	 * @return String
	 */
	public String getEin() {
		return ein;
	}

	/**
	 * Set the ein of Corporatecompany
	 * @param ein the ein to set
	 */
	public void setEin(String ein) {
		this.ein = ein;
	}

	/**
	 * Get the first_name of Corporatecompany
	 * @return String
	 */
	public String getFirstName() {
		return first_name;
	}

	/**
	 * Set the first_name of Corporatecompany
	 * @param first_name the first_name to set
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Get the last_name of Corporatecompany
	 * @return String
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * Set the last_name of Corporatecompany
	 * @param last_name the last_name to set
	 */
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

}
