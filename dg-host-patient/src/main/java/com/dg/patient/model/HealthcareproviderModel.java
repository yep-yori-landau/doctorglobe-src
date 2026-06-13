/**
 * Facility Model
 */
package com.dg.patient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;
import java.util.Locale;
/**
 * @author DoctorGlobe
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthcareproviderModel extends Object {

	/**
	 * The id of HealthcareproviderModel
	 */
	private Integer id;

	/**
	 * The name of HealthcareproviderModel
	 */
	private String name;

	/**
	 * The description of HealthcareproviderModel
	 */
	private String description;

	/**
	 * The location of HealthcareproviderModel
	 */
	private String location;

	/**
	 * The rating of HealthcareproviderModel
	 */
	private Integer rating;

	/**
	 * The experts of HealthcareproviderModel
	 */
	private Integer experts;

	/**
	 * The treatment_name of HealthcareproviderModel
	 */
	private String treatment_name;

	/**
	 * The available_days of HealthcareproviderModel
	 */
	private Integer available_days;

	/**
	 * The estimated_cost of HealthcareproviderModel
	 */
	private Double estimated_cost;

	/**
	 * The region_name of HealthcareproviderModel
	 */
	private String region_name;

	/**
	 * The currency of HealthcareproviderModel
	 */
	private String currency;

	/**
	 * The amenity of HealthcareproviderModel
	 */
	private String amenity;

	/**
	 * The accreditation of HealthcareproviderModel
	 */
	private String accreditation;

	/**
	 * The unit of HealthcareproviderModel
	 */
	private String unit;

	/**
	 * The healthcareprovider_image of HealthcareproviderModel
	 */
	private String healthcareprovider_image;

	/**
	 * The image_type of HealthcareproviderModel
	 */
	private String image_type;

	/**
	 * The is_display of HealthcareproviderModel
	 */
	private boolean is_display;

	/**
	 * The equipment of HealthcareproviderModel
	 */
	private String equipment;

	/**
	 * The is_equipment_display of HealthcareproviderModel
	 */
	private boolean is_equipment_display;

	/**
	 * The feature of HealthcareproviderModel
	 */
	private String feature;

	/**
	 * The unit_description of HealthcareproviderModel
	 */
	private String unit_description;

	/**
	 * The is_primary of HealthcareproviderModel
	 */
	private boolean is_primary;

	/**
	 * The lat of HealthcareproviderModel
	 */
	private String lat;

	/**
	 * The lon of HealthcareproviderModel
	 */
	private String lon;

	/**
	 * The ranking of HealthcareproviderModel
	 */
	private Integer ranking;

	/**
	 * The you_get_up_to of HealthcareproviderModel
	 */
	private Double you_get_up_to;

	/**
	 * The you_pay_up_to of HealthcareproviderModel
	 */
	private Double you_pay_up_to;

	/**
	 * The is_available of HealthcareproviderModel
	 */
	private boolean is_available;

	/**
	 * The insurance_currency of HealthcareproviderModel
	 */
	private String insurance_currency;

	/**
	 * The city of HealthcareproviderModel
	 */
	private BigInteger city;

	/**
	 * The distance of HealthcareproviderModel
	 */
	private Double distance;

	/**
	 * The mortality_rate of HealthcareproviderModel
	 */
	private Integer mortality_rate;

	/**
	 * The per_case_insurance_cap of HealthcareproviderModel
	 */
	private BigDecimal per_case_insurance_cap;

	/**
	 * The affiliation of HealthcareproviderModel
	 */
	private String affiliation;

	/**
	 * The corporatecompany_insurance of HealthcareproviderModel
	 */
	private BigInteger corporatecompany_insurance;

	/**
	 * The number_performed_last_year of HealthcareproviderModel
	 */
	private Integer number_performed_last_year;

	/**
	 * The hcpstmp_id of HealthcareproviderModel
	 */
	private BigInteger hcpstmp_id;

	/**
	 * The rate of HealthcareproviderModel
	 */
	private Double rate;

	/**
	 * The city_lat of HealthcareproviderModel
	 */
	private Double city_lat;

	/**
	 * The city_lon of HealthcareproviderModel
	 */
	private Double city_lon;

	/**
	 * The website of HealthcareproviderModel
	 */
	private String website;

	/**
	 * The aha_id of HealthcareproviderModel
	 */
	private String aha_id;

	/**
	 * The usnews link to the doctor page of HealthcareproviderModel
	 */
	private String usnews_doctor_link;

	/**
	 * The usnews_name of HealthcareproviderModel
	 */
	private String usnews_name;

	/**
	 * The state_code of HealthcareproviderModel
	 */
	private String state_code;

	/**
	 * The doctors_url of HealthcareproviderModel
	 */
	private String doctors_url;

	/**
	 * The rating_url of HealthcareproviderModel
	 */
	private String rating_url;

	/**
	 * The practitioner of HealthcareproviderModel
	 */
	private BigInteger practitioner;

	/**
	 * The volume of HealthcareproviderModel
	 */
	private String volume;

	/**
	 * The is_disabled of HealthcareproviderModel
	 */
	private boolean is_disabled;

	/**
	 * The before_days of HealthcareproviderModel
	 */
	private Integer before_days;

	/**
	 * The after_days of HealthcareproviderModel
	 */
	private Integer after_days;

	/**
	 * The treatment_days of HealthcareproviderModel
	 */
	private Integer treatment_days;

	/**
	 * The daily_expense of HealthcareproviderModel
	 */
	private Double daily_expense;

	/**
	 * The country of HealthcareproviderModel
	 */
	private BigInteger country;

	/**
	 * The flighthours of HealthcareproviderModel
	 */
	private Double flighthours;

	/**
	 * The flighttime of HealthcareproviderModel
	 */
	private String flighttime;

	/**
	 * The hospitalFilterModel of HealthcareproviderModel
	 */
	private HospitalFilterModel hospitalFilterModel;

	/**
	 * The zip_code of HealthcareproviderModel
	 */
	private String zip_code;
	
	/**
	 * The address_1 of HealthcareproviderModel
	 */
	private String address_1;
	
	/**
	 * The address_1 of HealthcareproviderModel
	 */
	private String address_2;
	
	/**
	 * The city_name of HealthcareproviderModel
	 */
	private String city_name;
	
	/**
	 * The state_name of HealthcareproviderModel
	 */
	private String state_name;
	
	/**
	 * The country_name of HealthcareproviderModel
	 */
	private String country_name;
	
	/**
	 * The destination_cost of HealthcareproviderModel
	 */
	private Double destination_cost;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return the experts
	 */
	public Integer getExperts() {
		return experts;
	}

	/**
	 * @param experts the experts to set
	 */
	public void setExperts(Integer experts) {
		this.experts = experts;
	}

	/**
	 * @return the treatment_name
	 */
	public String getTreatmentName() {
		return treatment_name;
	}

	/**
	 * @param name the name to set
	 */
	public void setTreatmentName(String treatment_name) {
		this.treatment_name = treatment_name;
	}

	/**
	 * @return the available_days
	 */
	public Integer getAvailableDays() {
		return available_days;
	}

	/**
	 * @param available_days the available_days to set
	 */
	public void setAvailableDays(Integer available_days) {
		this.available_days = available_days;
	}

	/**
	 * @return the estimated cost
	 */
	public Double getEstimatedCost() {
		return estimated_cost;
	}

	/**
	 * @param estimated_cost the estimated_cost to set
	 */
	public void setEstimatedCost(Double estimated_cost) {
		this.estimated_cost = estimated_cost;
	}

	/**
	 * @return the region_name
	 */
	public String getRegionName() {
		return region_name;
	}

	/**
	 * @param region_name the region_name to set
	 */
	public void setRegionName(String region_name) {
		this.region_name = region_name;
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
	 * @return the amenity
	 */
	public String getAmenity() {
		return amenity;
	}

	/**
	 * @param amenity the amenity to set
	 */
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	/**
	 * @return the accreditation
	 */
	public String getAccreditation() {
		return accreditation;
	}

	/**
	 * @param accreditation the accreditation to set
	 */
	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the healthcareprovider_image
	 */
	public String getHealthcareproviderImage() {
		return healthcareprovider_image;
	}

	/**
	 * @param healthcareprovider_image the healthcareprovider_image to set
	 */
	public void setHealthcareproviderImage(String healthcareprovider_image) {
		this.healthcareprovider_image = healthcareprovider_image;
	}

	/**
	 * @return the image_type
	 */
	public String getImageType() {
		return image_type;
	}

	/**
	 * @param image_type the image_type to set
	 */
	public void setImageType(String image_type) {
		this.image_type = image_type;
	}

	/**
	 * @return the is_display
	 */
	public boolean getIsDisplay() {
		return is_display;
	}

	/**
	 * @param is_display the is_display to set
	 */
	public void setIsDisplay(boolean is_display) {
		this.is_display = is_display;
	}

	/**
	 * @return the currency code
	 */
	public String getCurrencyCode() {
		Currency curr = Currency.getInstance(currency);
		return curr.getSymbol(Locale.getDefault());
		// return "$";
	}

	/**
	 * @return the equipment
	 */
	public String getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the is_equipment_display
	 */
	public boolean getIsEquipmentDisplay() {
		return is_equipment_display;
	}

	/**
	 * @param is_equipment_display the is_equipment_display to set
	 */
	public void setIsEquipmentDisplay(boolean is_equipment_display) {
		this.is_equipment_display = is_equipment_display;
	}

	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * @return the unit_description
	 */
	public String getUnitDescription() {
		return unit_description;
	}

	/**
	 * @param unit_description the unit_description to set
	 */
	public void setUnitDescription(String unit_description) {
		this.unit_description = unit_description;
	}

	/**
	 * @return the is_primary
	 */
	public boolean getIsPrimary() {
		return is_primary;
	}

	/**
	 * @param is_primary the is_primary to set
	 */
	public void setIsPrimary(boolean is_primary) {
		this.is_primary = is_primary;
	}

	/**
	 * 
	 * @return the lan
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * 
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 * 
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}

	/**
	 * 
	 * @param ranking the ranking to set
	 */
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	/**
	 * 
	 * @return the ranking
	 */
	public Integer getRanking() {
		return ranking;
	}

	/**
	 * 
	 * @param you_get_up_to the to you_get_up_to set
	 */
	public void setYouGetUpTo(Double you_get_up_to) {
		if (you_get_up_to != null) {
			this.you_get_up_to = you_get_up_to;
		}
		else {
			this.you_get_up_to = 0.0;
		}
	}

	/**
	 * 
	 * @return the you_get_up_to
	 */
	public Double getYouGetUpTo() {
		return you_get_up_to;
	}

	/**
	 * 
	 * @param you_pay_up_to the to you_pay_up_to set
	 */
	public void setYouPayUpTo(Double you_pay_up_to) {
		if (you_pay_up_to != null) {
			this.you_pay_up_to = you_pay_up_to;
		}
		else {
			this.you_pay_up_to = 0.0;
		}
	}

	/**
	 * 
	 * @return the you_pay_up_to
	 */
	public Double getYouPayUpTo() {
		return you_pay_up_to;
	}

	/**
	 * @return the insurance_currency
	 */
	public String getInsuranceCurrency() {
		return insurance_currency;
	}

	/**
	 * @param insurance_currency the insurance_currency to set
	 */
	public void setInsuarnceCurrency(String insurance_currency) {
		this.insurance_currency = insurance_currency;
	}

	/**
	 * @return the is_available
	 */
	public boolean getIsAvailable() {
		return is_available;
	}

	/**
	 * @param is_available the is_available to set
	 */
	public void setIsAvailable(boolean is_available) {
		this.is_available = is_available;
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
	 * @return the distance
	 */
	public Double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
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
	public void setMortalityRate(Integer mortality_rate) {
		this.mortality_rate = mortality_rate;
	}

	/**
	 * @return the per_case_insurance_cap
	 */
	public BigDecimal getPerCaseInsuranceCap() {
		return per_case_insurance_cap;
	}

	/**
	 * @param per_case_insurance_cap the per_case_insurance_cap to set
	 */
	public void setPerCaseInsuranceCap(BigDecimal per_case_insurance_cap) {
		this.per_case_insurance_cap = per_case_insurance_cap;
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
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	/**
	 * @return the corporatecompany_insurance
	 */
	public BigInteger getCorporatecompanyInsurance() {
		return corporatecompany_insurance;
	}

	/**
	 * @param corporatecompany_insurance the corporatecompany_insurance to set
	 */
	public void setCorporatecompanyInsurance(
			BigInteger corporatecompany_insurance) {
		this.corporatecompany_insurance = corporatecompany_insurance;
	}

	/**
	 * @return the number_performed_last_year
	 */
	public Integer getNumberPerformedLastYear() {
		return number_performed_last_year;
	}

	/**
	 * @param mortality_rate the mortality_rate to set
	 */
	public void setNumberPerformedLastYear(Integer number_performed_last_year) {
		this.number_performed_last_year = number_performed_last_year;
	}

	/**
	 * @return the hcpstmpId
	 */
	public BigInteger getHcpstmpId() {
		return hcpstmp_id;
	}

	/**
	 * @param hcpstmp_id the hcpstmp_id to set
	 */
	public void setHcpstmpId(BigInteger hcpstmp_id) {
		this.hcpstmp_id = hcpstmp_id;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	/**
	 * @return the lat
	 */
	public Double getCityLat() {
		return city_lat;
	}

	/**
	 * @param lat the city_lat to set
	 */
	public void setCityLat(Double city_lat) {
		this.city_lat = city_lat;
	}

	/**
	 * @return the city_lon
	 */
	public Double getCityLon() {
		return city_lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setCityLon(Double city_lon) {
		this.city_lon = city_lon;
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
	 * @return the aha_id
	 */
	public String getAhaId() {
		return aha_id;
	}

	/**
	 * @param aha_id the aha_id to set
	 */
	public void setAhaId(String aha_id) {
		this.aha_id = aha_id;
	}

	/**
	 * Get the usnews_doctor_link of the HealthcareproviderModel
	 * @return String
	 */
	public String getUsnewsDoctorLink() {
		return usnews_doctor_link;
	}

	/**
	 * Set the usnews_doctor_link of HealthcareproviderModel
	 * @param usnews_doctor_link the usnews_doctor_link to set
	 */
	public void setUsnewsDoctorLink(String usnews_doctor_link) {
		this.usnews_doctor_link = usnews_doctor_link;
	}
	
	/**
	 * @return the usnews_name
	 */
	public String getUsnewsName() {
		return usnews_name;
	}

	/**
	 * @param usnews_name the usnews_name to set
	 */
	public void setUsnewsName(String usnews_name) {
		this.usnews_name = usnews_name;
	}

	/**
	 * @return the state_code
	 */
	public String getStateCode() {
		return state_code;
	}

	/**
	 * @param Set the string that represents the volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the volume string
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param state_code the state_code to set
	 */
	public void setStateCode(String state_code) {
		this.state_code = state_code;
	}

	/**
	 * @return the doctors_url
	 */
	public String getDoctorsUrl() {
		return doctors_url;
	}

	/**
	 * @param doctors_url the rating_url to set
	 */
	public void setDoctorsUrl(String doctors_url) {
		this.doctors_url = doctors_url;
	}

	/**
	 * @return the rating_url
	 */
	public String getRatingUrl() {
		return rating_url;
	}

	/**
	 * @param rating_url the rating_url to set
	 */
	public void setRatingUrl(String rating_url) {
		this.rating_url = rating_url;
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
	public void setPractitioner(BigInteger practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * @return the is_disabled
	 */
	public boolean getIsDisabled() {
		return is_disabled;
	}

	/**
	 * @param is_disabled the is_disabled to set
	 */
	public void setIsDisabled(boolean is_disabled) {
		this.is_disabled = is_disabled;
	}

	/**
	 * @return the before_days
	 */
	public Integer getBeforeDays() {
		return before_days;
	}

	/**
	 * @param before_days the before_days to set
	 */
	public void setBeforeDays(Integer before_days) {
		this.before_days = before_days;
	}

	/**
	 * @return the after_days
	 */
	public Integer getAfterDays() {
		return after_days;
	}

	/**
	 * @param after_days the after_days to set
	 */
	public void setAfterDays(Integer after_days) {
		this.after_days = after_days;
	}

	/**
	 * @return the treatment_days
	 */
	public Integer getTreatmentDays() {
		return treatment_days;
	}

	/**
	 * @param treatment_days the treatment_days to set
	 */
	public void setTreatmentDays(Integer treatment_days) {
		this.treatment_days = treatment_days;
	}

	/**
	 * 
	 * @return daily_expense
	 */
	public Double getDailyExpense() {
		return daily_expense;
	}

	/**
	 * 
	 * @param daily_expense
	 */
	public void setDailyExpense(Double daily_expense) {
		this.daily_expense = daily_expense;
	}

	/**
	 * @return the country
	 */
	public BigInteger getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(BigInteger country) {
		this.country = country;
	}

	/**
	 * @return the flighthours
	 */
	public Double getFlighthours() {
		return flighthours;
	}

	/**
	 * @param flighthours the flighthours to set
	 */
	public void setFlighthours(Double flighthours) {
		this.flighthours = flighthours;
	}

	/**
	 * @return the flighttime
	 */
	public String getFlighttime() {
		return flighttime;
	}

	/**
	 * @param flighttime the flighttime to set
	 */
	public void setFlighttime(String flighttime) {
		this.flighttime = flighttime;
	}

	/**
	 * @return the hospitalFilterModel
	 */
	public HospitalFilterModel getHospitalFilterModel() {
		return hospitalFilterModel;
	}

	/**
	 * @param hospitalFilterModel the hospitalFilterModel to set
	 */
	public void setHospitalFilterModel(
			HospitalFilterModel hospitalFilterModel) {
		this.hospitalFilterModel = hospitalFilterModel;
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
	
	/**
	 * 
	 * @return destination_cost
	 */
	public Double getDestinationCost() {
		return destination_cost;
	}

	/**
	 * 
	 * @param destination_cost
	 */
	public void setDestinationCost(Double destination_cost) {
		this.destination_cost = destination_cost;
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
				+ ",hcpstmp_id=" + hcpstmp_id + ",website=" + website
				+ ",aha_id=" + aha_id + ",usnews_doctor_link=" + usnews_doctor_link + ",usnews_name=" + usnews_name
//				+ ",aha_id=" + aha_id + ",usnews_name=" + usnews_name
				+ ",state_code=" + state_code + ",practitioner=" + practitioner
				+ ",volume=" + volume + ",flighthours=" + flighthours
				+ ",flighttime=" + flighttime + ",zip_code=" + zip_code 
				+ ",address_1=" + address_1 + ",address_2=" + address_2 
				+ ",city_name=" + city_name + ",state_name=" + state_name 
				+ ",country_name=" + country_name + "]";
	}

}
