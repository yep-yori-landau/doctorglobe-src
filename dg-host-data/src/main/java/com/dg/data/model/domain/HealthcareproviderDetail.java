package com.dg.data.model.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * HealthcareproviderDetail Domain Model
 * @author DoctorGlobe
 *
 */

public class HealthcareproviderDetail {

	/**
	 * The id of HealthcareproviderDetail
	 */
	private Integer id;

	/**
	 * The name of HealthcareproviderDetail
	 */
	private String name;

	/**
	 * The description of HealthcareproviderDetail
	 */
	private String description;

	/**
	 * The location of HealthcareproviderDetail
	 */
	private String location;

	/**
	 * The rating of HealthcareproviderDetail
	 */
	private Integer rating;

	/**
	 * The experts of HealthcareproviderDetail
	 */
	private Integer experts;

	/**
	 * The treatment_name of HealthcareproviderDetail
	 */
	private String treatment_name;

	/**
	 * The available_days of HealthcareproviderDetail
	 */
	private Integer available_days;

	/**
	 * The estimated_cost of HealthcareproviderDetail
	 */
	private Double estimated_cost;

	/**
	 * The region_name of HealthcareproviderDetail
	 */
	private String region_name;

	/**
	 * The currency of HealthcareproviderDetail
	 */
	private String currency;

	/**
	 * The amenity of HealthcareproviderDetail
	 */
	private String amenity;

	/**
	 * The accreditation of HealthcareproviderDetail
	 */
	private String accreditation;

	/**
	 * The unit of HealthcareproviderDetail
	 */
	private String unit;

	/**
	 * The healthcareprovider_image of HealthcareproviderDetail
	 */
	private String healthcareprovider_image;

	/**
	 * The image_type of HealthcareproviderDetail
	 */
	private String image_type;

	/**
	 * The is_display of HealthcareproviderDetail
	 */
	private boolean is_display;

	/**
	 * The equipment of HealthcareproviderDetail
	 */
	private String equipment;

	/**
	 * The is_equipment_display of HealthcareproviderDetail
	 */
	private boolean is_equipment_display;

	/**
	 * The feature of HealthcareproviderDetail
	 */
	private String feature;

	/**
	 * The unit_description of HealthcareproviderDetail
	 */
	private String unit_description;

	/**
	 * The is_primary of HealthcareproviderDetail
	 */
	private boolean is_primary;

	/**
	 * The lat of HealthcareproviderDetail
	 */
	private String lat;

	/**
	 * The lon of HealthcareproviderDetail
	 */
	private String lon;

	/**
	 * The ranking of HealthcareproviderDetail
	 */
	private Integer ranking;

	/**
	 * The city of HealthcareproviderDetail
	 */
	private BigInteger city;

	/**
	 * The mortality_rate of HealthcareproviderDetail
	 */
	private Integer mortality_rate;

	/**
	 * The per_case_insurance_cap of HealthcareproviderDetail
	 */
	private BigDecimal per_case_insurance_cap;

	/**
	 * The affiliation of HealthcareproviderDetail
	 */
	private String affiliation;

	/**
	 * The corporatecompany_insurance of HealthcareproviderDetail
	 */
	private BigInteger corporatecompany_insurance;

	/**
	 * The number_performed_last_year of HealthcareproviderDetail
	 */
	private Integer number_performed_last_year;

	/**
	 * The hcpstmp_id of HealthcareproviderDetail
	 */
	private BigInteger hcpstmp_id;

	/**
	 * The rate of HealthcareproviderDetail
	 */
	private Double rate;

	/**
	 * The city_lat of HealthcareproviderDetail
	 */
	private Double city_lat;

	/**
	 * The city_lon of HealthcareproviderDetail
	 */
	private Double city_lon;

	/**
	 * The distance of HealthcareproviderDetail
	 */
	private Double distance;

	/**
	 * The website of HealthcareproviderDetail
	 */
	private String website;

	/**
	 * The aha_id of HealthcareproviderDetail
	 */
	private String aha_id;


	/**
	 * The usnews link to the doctor page
	 */
	private String usnews_doctor_link;
	
	/**
	 * The usnews_name of HealthcareproviderDetail
	 */
	private String usnews_name;

	/**
	 * The state_code of HealthcareproviderDetail
	 */
	private String state_code;

	/**
	 * The practitioner of HealthcareproviderDetail
	 */
	private BigInteger practitioner;

	/**
	 * The volume of HealthcareproviderDetail
	 */
	private String volume;

	/**
	 * The before_days of HealthcareproviderDetail
	 */
	private Integer before_days;

	/**
	 * The after_days of HealthcareproviderDetail
	 */
	private Integer after_days;

	/**
	 * The treatment_days of HealthcareproviderDetail
	 */
	private Integer treatment_days;

	/**
	 * The daily_expense of HealthcareproviderDetail
	 */
	private Double daily_expense;

	/**
	 * The country of HealthcareproviderDetail
	 */
	private BigInteger country;

	/**
	 * The flighthours of HealthcareproviderDetail
	 */
	private Double flighthours;

	/**
	 * The flighttime of HealthcareproviderDetail
	 */
	private String flighttime;

	/**
	 * The zip_code of HealthcareproviderDetail
	 */
	private String zip_code;
	
	/**
	 * The address_1 of HealthcareproviderDetail
	 */
	private String address_1;
	
	/**
	 * The address_1 of HealthcareproviderDetail
	 */
	private String address_2;
	
	/**
	 * The city_name of HealthcareproviderDetail
	 */
	private String city_name;
	
	/**
	 * The state_name of HealthcareproviderDetail
	 */
	private String state_name;
	
	/**
	 * The country_name of HealthcareproviderDetail
	 */
	private String country_name;

	/**
	 * Get the id of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id of HealthcareproviderDetail
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the name of HealthcareproviderDetail
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of HealthcareproviderDetail
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the description of HealthcareproviderDetail
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of HealthcareproviderDetail
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the location of HealthcareproviderDetail
	 * @return String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Set the location of HealthcareproviderDetail
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Get the rating of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Set the rating of HealthcareproviderDetail
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * Get the experts of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getExperts() {
		return experts;
	}

	/**
	 * Set the experts of HealthcareproviderDetail
	 * @param experts the experts to set
	 */
	public void setExperts(Integer experts) {
		this.experts = experts;
	}

	/**
	 * Get the treatment_name of HealthcareproviderDetail
	 * @return String
	 */
	public String getTreatmentName() {
		return treatment_name;
	}

	/**
	 * Set the treatment_name of HealthcareproviderDetail
	 * @param treatment_name the treatment_name to set
	 */
	public void setTreatmentName(String treatment_name) {
		this.treatment_name = treatment_name;
	}

	/**
	 * Get the available_days of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getAvailableDays() {
		return available_days;
	}

	/**
	 * Set the available_days of HealthcareproviderDetail
	 * @param available_days the available_days to set
	 */
	public void setAvailableDays(Integer available_days) {
		this.available_days = available_days;
	}

	/**
	 * Get the estimated_cost of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getEstimatedCost() {
		return estimated_cost;
	}

	/**
	 * Set the estimated_cost of HealthcareproviderDetail
	 * @param estimated_cost the estimated_cost to set
	 */
	public void setEstimatedCost(Double estimated_cost) {
		this.estimated_cost = estimated_cost;
	}

	/**
	 * Get the region_name of HealthcareproviderDetail
	 * @return String
	 */
	public String getRegionName() {
		return region_name;
	}

	/**
	 * Set the region_name of HealthcareproviderDetail
	 * @param region_name the region_name to set
	 */
	public void setRegionName(String region_name) {
		this.region_name = region_name;
	}

	/**
	 * Get the currency of HealthcareproviderDetail
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Set the currency of HealthcareproviderDetail
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Get the amenity of HealthcareproviderDetail
	 * @return String
	 */
	public String getAmenity() {
		return amenity;
	}

	/**
	 * Set the amenity of HealthcareproviderDetail
	 * @param amenity the amenity to set
	 */
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	/**
	 * Get the accreditation of HealthcareproviderDetail
	 * @return String
	 */
	public String getAccreditation() {
		return accreditation;
	}

	/**
	 * Set the accreditation of HealthcareproviderDetail
	 * @param accreditation the accreditation to set
	 */
	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}

	/**
	 * Get the unit of HealthcareproviderDetail
	 * @return String
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Set the unit of HealthcareproviderDetail
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Get the healthcareprovider_image of HealthcareproviderDetail
	 * @return String
	 */
	public String getHealthcareproviderImage() {
		return healthcareprovider_image;
	}

	/**
	 * Set the healthcareprovider_image of HealthcareproviderDetail
	 * @param healthcareprovider_image the healthcareprovider_image to set
	 */
	public void setHealthcareproviderImage(String healthcareprovider_image) {
		this.healthcareprovider_image = healthcareprovider_image;
	}

	/**
	 * Get the image_type of HealthcareproviderDetail
	 * @return String
	 */
	public String getImageType() {
		return image_type;
	}

	/**
	 * Set the image_type of HealthcareproviderDetail
	 * @param image_type the image_type to set
	 */
	public void setImageType(String image_type) {
		this.image_type = image_type;
	}

	/**
	 * Get the is_display of HealthcareproviderDetail
	 * @return boolean
	 */
	public boolean getIsDisplay() {
		return is_display;
	}

	/**
	 * Set the is_display of HealthcareproviderDetail
	 * @param is_display the is_display to set
	 */
	public void setIsDisplay(boolean is_display) {
		this.is_display = is_display;
	}

	/**
	 * Get the equipment of HealthcareproviderDetail
	 * @return String
	 */
	public String getEquipment() {
		return equipment;
	}

	/**
	 * Set the equipment of HealthcareproviderDetail
	 * @param equipment the equipment to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	/**
	 * Get the is_equipment_display of HealthcareproviderDetail
	 * @return boolean
	 */
	public boolean getIsEquipment_display() {
		return is_equipment_display;
	}

	/**
	 * Set the is_equipment_display of HealthcareproviderDetail
	 * @param is_equipment_display the is_equipment_display to set
	 */
	public void setIsEquipmentDisplay(boolean is_equipment_display) {
		this.is_equipment_display = is_equipment_display;
	}

	/**
	 * Get the feature of HealthcareproviderDetail
	 * @return String
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * Set the feature of HealthcareproviderDetail
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * Get the unit_description of HealthcareproviderDetail
	 * @return String
	 */
	public String getUnitDescription() {
		return unit_description;
	}

	/**
	 * Set the unit_description of HealthcareproviderDetail
	 * @param unit_description the unit_description to set
	 */
	public void setUnitDescription(String unit_description) {
		this.unit_description = unit_description;
	}

	/**
	 * Get the is_primary of HealthcareproviderDetail
	 * @return boolean
	 */
	public boolean getIsPrimary() {
		return is_primary;
	}

	/**
	 * Set the is_primary of HealthcareproviderDetail
	 * @param is_primary the is_primary to set
	 */
	public void setIsPrimary(boolean is_primary) {
		this.is_primary = is_primary;
	}

	/**
	 * Get the lat of HealthcareproviderDetail
	 * @return String
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * Set the lat of HealthcareproviderDetail
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * Get the lon of HealthcareproviderDetail
	 * @return String
	 */
	public String getLon() {
		return lon;
	}

	/**
	 * Set the lon of HealthcareproviderDetail
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 * Get the ranking of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getRanking() {
		return ranking;
	}

	/**
	 * Set the ranking of HealthcareproviderDetail
	 * @param ranking the ranking to set
	 */
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	/**
	 * Get the city of HealthcareproviderDetail
	 * @return BigInteger
	 */
	public BigInteger getCity() {
		return city;
	}

	/**
	 * Set the city of HealthcareproviderDetail
	 * @param city the city to set
	 */
	public void setCity(BigInteger city) {
		this.city = city;
	}

	/**
	 * Get the mortality_rate of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getMortalityRate() {
		return mortality_rate;
	}

	/**
	 * Set the mortality_rate of HealthcareproviderDetail
	 * @param mortality_rate the mortality_rate to set
	 */
	public void setMortalityRate(Integer mortality_rate) {
		this.mortality_rate = mortality_rate;
	}

	/**
	 * Get the per_case_insurance_cap of HealthcareproviderDetail
	 * @return BigDecimal
	 */
	public BigDecimal getPerCaseInsuranceCap() {
		return per_case_insurance_cap;
	}

	/**
	 * Set the per_case_insurance_cap of HealthcareproviderDetail
	 * @param per_case_insurance_cap the per_case_insurance_cap to set
	 */
	public void setPerCaseInsuranceCap(BigDecimal per_case_insurance_cap) {
		this.per_case_insurance_cap = per_case_insurance_cap;
	}

	/**
	 * Get the affiliation of HealthcareproviderDetail
	 * @return String
	 */
	public String getAffiliation() {
		return affiliation;
	}

	/**
	 * Set the affiliation of HealthcareproviderDetail
	 * @param affiliation the affiliation to set
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	/**
	 * Get the corporatecompany_insurance of HealthcareproviderDetail
	 * @return BigInteger
	 */
	public BigInteger getCorporatecompanyInsurance() {
		return corporatecompany_insurance;
	}

	/**
	 * Set the corporatecompany_insurance of HealthcareproviderDetail
	 * @param corporatecompany_insurance the corporatecompany_insurance to set
	 */
	public void setCorporatecompanyInsurance(
			BigInteger corporatecompany_insurance) {
		this.corporatecompany_insurance = corporatecompany_insurance;
	}

	/**
	 * Get the number_performed_last_year of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getNumberPerformedLastYear() {
		return number_performed_last_year;
	}

	/**
	 * Set the number_performed_last_year of HealthcareproviderDetail
	 * @param number_performed_last_year the number_performed_last_year to set
	 */
	public void setNumberPerformedLastYear(Integer number_performed_last_year) {
		this.number_performed_last_year = number_performed_last_year;
	}

	/**
	 * Get the hcpstmp_id of HealthcareproviderDetail
	 * @return BigInteger
	 */
	public BigInteger getHcpstmpId() {
		return hcpstmp_id;
	}

	/**
	 * Set the hcpstmp_id of HealthcareproviderDetail
	 * @param hcpstmp_id the hcpstmp_id to set
	 */
	public void setHcpstmpId(BigInteger hcpstmp_id) {
		this.hcpstmp_id = hcpstmp_id;
	}

	/**
	 * Get the rate of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getRate() {
		return rate;
	}

	/**
	 * Set the rate of HealthcareproviderDetail
	 * @param rate the rate to set
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}

	/**
	 * Get the city_lat of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getCityLat() {
		return city_lat;
	}

	/**
	 * Set the city_lat of HealthcareproviderDetail
	 * @param city_lat the city_lat to set
	 */
	public void setCityLat(Double city_lat) {
		this.city_lat = city_lat;
	}

	/**
	 * Get the city_lon of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getCityLon() {
		return city_lon;
	}

	/**
	 * Set the city_lon of HealthcareproviderDetail
	 * @param city_lon the city_lon to set
	 */
	public void setCityLon(Double city_lon) {
		this.city_lon = city_lon;
	}

	/**
	 * Get the distance of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getDistance() {
		return distance;
	}

	/**
	 * Set the distance of HealthcareproviderDetail
	 * @param distance the distance to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	/**
	 * Get the website of HealthcareproviderDetail
	 * @return String
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Set the website of HealthcareproviderDetail
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Get the aha_id of HealthcareproviderDetail
	 * @return String
	 */
	public String getAhaId() {
		return aha_id;
	}

	/**
	 * Set the aha_id of HealthcareproviderDetail
	 * @param aha_id the aha_id to set
	 */
	public void setAhaId(String aha_id) {
		this.aha_id = aha_id;
	}

	/**
	 * Get the usnews_doctor_link of the HealthcareproviderDetail
	 * @return String
	 */
	public String getUsnewsDoctorLink() {
		return usnews_doctor_link;
	}

	/**
	 * Set the usnews_doctor_link of HealthcareproviderDetail
	 * @param usnews_doctor_link the usnews_doctor_link to set
	 */
	public void setUsnewsDoctorLink(String usnews_doctor_link) {
		this.usnews_doctor_link = usnews_doctor_link;
	}
	
	/**
	 * Get the usnews_name of HealthcareproviderDetail
	 * @return String
	 */
	public String getUsnewsName() {
		return usnews_name;
	}

	/**
	 * Set the usnews_name of HealthcareproviderDetail
	 * @param usnews_name the usnews_name to set
	 */
	public void setUsnewsName(String usnews_name) {
		this.usnews_name = usnews_name;
	}

	/**
	 * Get the state_code of HealthcareproviderDetail
	 * @return String
	 */
	public String getStateCode() {
		return state_code;
	}

	/**
	 * Set the state_code of HealthcareproviderDetail
	 * @param state_code the state_code to set
	 */
	public void setStateCode(String state_code) {
		this.state_code = state_code;
	}

	/**
	 * Get the practitioner of HealthcareproviderDetail
	 * @return BigInteger
	 */
	public BigInteger getPractitioner() {
		return practitioner;
	}

	/**
	 * Set the practitioner of HealthcareproviderDetail
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * Get the volume of HealthcareproviderDetail
	 * @return String
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * Set the volume of HealthcareproviderDetail
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * Get the before_days of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getBeforeDays() {
		return before_days;
	}

	/**
	 * Set the before_days of HealthcareproviderDetail
	 * @param before_days the before_days to set
	 */
	public void setBeforeDays(Integer before_days) {
		this.before_days = before_days;
	}

	/**
	 * Get the after_days of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getAfterDays() {
		return after_days;
	}

	/**
	 * Set the after_days of HealthcareproviderDetail
	 * @param after_days the after_days to set
	 */
	public void setAfterDays(Integer after_days) {
		this.after_days = after_days;
	}

	/**
	 * Get the treatment_days of HealthcareproviderDetail
	 * @return Integer
	 */
	public Integer getTreatmentDays() {
		return treatment_days;
	}

	/**
	 * Set the treatment_days of HealthcareproviderDetail
	 * @param treatment_days the treatment_days to set
	 */
	public void setTreatmentDays(Integer treatment_days) {
		this.treatment_days = treatment_days;
	}

	/**
	 * Get the daily_expense of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getDailyExpense() {
		return daily_expense;
	}

	/**
	 * Set the daily_expense of HealthcareproviderDetail
	 * @param daily_expense the daily_expense to set
	 */
	public void setDailyExpense(Double daily_expense) {
		this.daily_expense = daily_expense;
	}

	/**
	 * Get the country of HealthcareproviderDetail
	 * @return BigInteger
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * Set the country of HealthcareproviderDetail
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * Get the flighthours of HealthcareproviderDetail
	 * @return Double
	 */
	public Double getFlighthours() {
		return flighthours;
	}

	/**
	 * Set the flighthours of HealthcareproviderDetail
	 * @param flighthours the flighthours to set
	 */
	public void setFlighthours(Double flighthours) {
		this.flighthours = flighthours;
	}

	/**
	 * Get the flighttime of HealthcareproviderDetail
	 * @return String
	 */
	public String getFlighttime() {
		return flighttime;
	}

	/**
	 * Set the flighttime of HealthcareproviderDetail
	 * @param flighttime the flighttime to set
	 */
	public void setFlighttime(String flighttime) {
		this.flighttime = flighttime;
	}

	/**
	 * Get the zip_code of HealthcareproviderDetail
	 * @return String
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the zip_code of HealthcareproviderDetail
	 * @param zip_code the zip_code to set
	 */
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
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
	 * @return the city_name
	 */
	public String getCityName() {
		return city_name;
	}
	
	/**
	 * @param city_name the city_name to set
	 */
	public void setCityName(String city_name) {
		this.city_name = city_name;
	}
	
	/**
	 * @return the state_name
	 */
	public String getStateName() {
		return state_name;
	}
	
	/**
	 * @param state_name the state_name to set
	 */
	public void setStateName(String state_name) {
		this.state_name = state_name;
	}
	
	/**
	 * @return the country_name
	 */
	public String getCountryName() {
		return country_name;
	}
	
	/**
	 * @param country_name the country_name to set
	 */
	public void setCountryName(String country_name) {
		this.country_name = country_name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HealthcareproviderModel [id=" + id + ", name=" + name
				+ ", description=" + description + ", location=" + location
				+ ", rating=" + rating + ", experts=" + experts
				+ ", treatment_name=" + treatment_name + ", available_days="
				+ available_days + ",estimated_cost=" + estimated_cost
				+ ",region_name=" + region_name + ",currency=" + currency
				+ ",amenity=" + amenity + ",accreditation=" + accreditation
				+ ",unit=" + unit + ",healthcareprovider_image="
				+ healthcareprovider_image + ",is_display=" + is_display
				+ ",equipment=" + equipment + ",is_equipment_display="
				+ is_equipment_display + ",feature=" + feature
				+ ",unit_description=" + unit_description + ",ranking="
				+ ranking + ",city=" + city + ",mortality_rate="
				+ mortality_rate + ",affiliation=" + affiliation
				+ ",per_case_insurance_cap=" + per_case_insurance_cap
				+ ",corporatecompany_insurance=" + corporatecompany_insurance
				+ ",number_performed_last_year=" + number_performed_last_year
				+ ",hcpstmp_id=" + hcpstmp_id + ",rate=" + rate + ",distance="
				+ distance + ",website=" + website + ",aha_id=" + aha_id
//				+ ",usnews_doctor_link=" + usnews_doctor_link
				+ ",usnews_name=" + usnews_name + ",state_code=" + state_code
				+ ",practitioner=" + practitioner + ",volume=" + volume
				+ ",lat=" + lat + ",lon=" + lon + ",before_days=" + before_days
				+ ",after_days=" + after_days + ",treatment_days="
				+ treatment_days + ",daily_expense=" + daily_expense
				+ ",flighthours=" + flighthours + ",flighttime=" + flighttime
				+ ",zip_code=" + zip_code 
				+ ",address_1=" + address_1 + ",address_2=" + address_2 
				+ ",city_name=" + city_name + ",state_name=" + state_name 
				+ ",country_name=" + country_name + "]";
	}

}