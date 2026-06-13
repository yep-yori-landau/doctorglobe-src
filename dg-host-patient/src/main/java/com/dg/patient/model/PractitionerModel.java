/**
 * Practitioner Model
 */
package com.dg.patient.model;

import java.util.Currency;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author DoctorGlobe
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PractitionerModel {

	/**
	 * The id of PractitionerModel
	 */
	private Integer id;

	/**
	 * The title of PractitionerModel
	 */
	private String title;

	/**
	 * The name of PractitionerModel
	 */
	private String name;

	/**
	 * The degree of PractitionerModel
	 */
	private String degree;

	/**
	 * The gender of PractitionerModel
	 */
	private String gender;

	/**
	 * The description of PractitionerModel
	 */
	private String description;

	/**
	 * The email of PractitionerModel
	 */
	private String email;

	/**
	 * The rating of PractitionerModel
	 */
	private String rating;

	/**
	 * The language of PractitionerModel
	 */
	private String language;

	/**
	 * The usa_certification of PractitionerModel
	 */
	private String usa_certification;

	/**
	 * The usa_training of PractitionerModel
	 */
	private Boolean usa_training;

	/**
	 * The treatment_name of PractitionerModel
	 */
	private String treatment_name;

	/**
	 * The hcpstmp of PractitionerModel
	 */
	private Integer hcpstmp;

	/**
	 * The available_days of PractitionerModel
	 */
	private Integer available_days;

	/**
	 * The estimated_cost of PractitionerModel
	 */
	private Double estimated_cost;

	/**
	 * The healthcareprovider_id of PractitionerModel
	 */
	private Integer healthcareprovider_id;

	/**
	 * The healthcareprovider_name of PractitionerModel
	 */
	private String healthcareprovider_name;

	/**
	 * The healthcareprovider_location of PractitionerModel
	 */
	private String healthcareprovider_location;

	/**
	 * The healthcareprovider_city of PractitionerModel
	 */
	private String healthcareprovider_city;

	/**
	 * The healthcareprovider_state of PractitionerModel
	 */
	private String healthcareprovider_state;

	/**
	 * The healthcareprovider_country of PractitionerModel
	 */
	private String healthcareprovider_country;

	/**
	 * The healthcareprovider_description of PractitionerModel
	 */
	private String healthcareprovider_description;

	/**
	 * The currency of PractitionerModel
	 */
	private String currency;

	/**
	 * The usa_certification_class of PractitionerModel
	 */
	private String usa_certification_class;

	/**
	 * The usa_training_class of PractitionerModel
	 */
	private String usa_training_class;

	/**
	 * The available_days_class of PractitionerModel
	 */
	private String available_days_class;

	/**
	 * The unit of PractitionerModel
	 */
	private String unit;

	/**
	 * The practitioner_image of PractitionerModel
	 */
	private String practitioner_image;

	/**
	 * The healthcareprovider_image of PractitionerModel
	 */
	private String healthcareprovider_image;

	/**
	 * The feature of PractitionerModel
	 */
	private String feature;

	/**
	 * The unit_description of PractitionerModel
	 */
	private String unit_description;

	/**
	 * The amenity of PractitionerModel
	 */
	private String amenity;

	/**
	 * The is_display of PractitionerModel
	 */
	private boolean is_display;

	/**
	 * The equipment of PractitionerModel
	 */
	private String equipment;

	/**
	 * The is_equipment_display of PractitionerModel
	 */
	private boolean is_equipment_display;

	/**
	 * The lat of PractitionerModel
	 */
	private String lat;

	/**
	 * The lon of PractitionerModel
	 */
	private String lon;

	/**
	 * The is_disabled of PractitionerModel
	 */
	private boolean is_disabled;

	/**
	 * The ranking of PractitionerModel
	 */
	private Integer ranking;

	/**
	 * The is_primary of PractitionerModel
	 */
	private boolean is_primary;

	/**
	 * The you_get_up_to of PractitionerModel
	 */
	private Double you_get_up_to;

	/**
	 * The you_pay_up_to of PractitionerModel
	 */
	private Double you_pay_up_to;

	/**
	 * The is_available of PractitionerModel
	 */
	private boolean is_available;

	/**
	 * The insurance_currency of PractitionerModel
	 */
	private String insurance_currency;

	/**
	 * The years_practiced of PractitionerModel
	 */
	private Integer years_practiced;

	/**
	 * The number_performed_overall of PractitionerModel
	 */
	private Integer number_performed_overall;

	/**
	 * The number_performed_last_year of PractitionerModel
	 */
	private Integer number_performed_last_year;

	/**
	 * The corrections_last_year of PractitionerModel
	 */
	private Integer corrections_last_year;

	/**
	 * The insurance_cap of PractitionerModel
	 */
	private Double insurance_cap;

	/**
	 * The healthcareprovider_practitioner_name of PractitionerModel
	 */
	private String healthcareprovider_practitioner_name;

	/**
	 * The healthcareprovider_practitioner_description of PractitionerModel
	 */
	private String healthcareprovider_practitioner_description;

	/**
	 * The healthcareprovider_practitioner_title of PractitionerModel
	 */
	private String healthcareprovider_practitioner_title;

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
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	public boolean getUsaTraining() {
		return usa_training;
	}

	/**
	 * @param usa_training the usa_training to set
	 */
	public void setUsaTraining(boolean usa_training) {
		this.usa_training = usa_training;
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
	 * @return the hcpstmp
	 */
	public Integer getHcpstmp() {
		return hcpstmp;
	}

	/**
	 * @param fstmp the fstmp to set
	 */
	public void setHcpstmp(Integer hcpstmp) {
		this.hcpstmp = hcpstmp;
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
	 * @return the healthcareprovider name
	 */
	public String getHealthcareproviderName() {
		return healthcareprovider_name;
	}

	/**
	 * @param healthcareprovider_location the healthcareprovider_location to set
	 */
	public void setHealthcareproviderLocation(
			String healthcareprovider_location) {
		this.healthcareprovider_location = healthcareprovider_location;
	}

	/**
	 * @return the healthcareprovider location
	 */
	public String getHealthcareproviderLocation() {
		return healthcareprovider_location;
	}

	/**
	 * @param healthcareprovider_city the healthcareprovider_city to set
	 */
	public void setHealthcareproviderCity(String healthcareprovider_city) {
		this.healthcareprovider_city = healthcareprovider_city;
	}

	/**
	 * @return the healthcareprovider city
	 */
	public String getHealthcareproviderCity() {
		return healthcareprovider_city;
	}

	/**
	 * @param healthcareprovider_state the healthcareprovider_state to set
	 */
	public void setHealthcareproviderState(String healthcareprovider_state) {
		this.healthcareprovider_state = healthcareprovider_state;
	}

	/**
	 * @return the healthcareprovider state
	 */
	public String getHealthcareproviderState() {
		return healthcareprovider_state;
	}

	/**
	 * @param healthcareprovider_country the healthcareprovider_country to set
	 */
	public void setHealthcareproviderCountry(
			String healthcareprovider_country) {
		this.healthcareprovider_country = healthcareprovider_country;
	}

	/**
	 * @return the healthcareprovider country
	 */
	public String getHealthcareproviderCountry() {
		return healthcareprovider_country;
	}

	/**
	 * @param healthcareprovider_name the healthcareprovider_name to set
	 */
	public void setHealthcareproviderName(String healthcareprovider_name) {
		this.healthcareprovider_name = healthcareprovider_name;
	}

	/**
	 * @return the healthcareprovider description
	 */
	public String getHealthcareproviderDescription() {
		return healthcareprovider_description;
	}

	/**
	 * @param healthcareprovider_description the healthcareprovider_description
	 * to set
	 */
	public void setHealthcareproviderDescription(
			String healthcareprovider_description) {
		this.healthcareprovider_description = healthcareprovider_description;
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
	 * @return the usa certification class
	 */
	public String getUsaCertificationClass() {
		return usa_certification_class;
	}

	/**
	 * @param usa_certification_class the usa_certification_class to set
	 */
	public void setUsaCertificationClass(String usa_certification_class) {
		this.usa_certification_class = usa_certification_class;
	}

	/**
	 * @return the usa training class
	 */
	public String getUsaTrainingClass() {
		return usa_training_class;
	}

	/**
	 * @param usa_certification_class the usa_certification_class to set
	 */
	public void setUsaTrainingClass(String usa_training_class) {
		this.usa_training_class = usa_training_class;
	}

	/**
	 * @return the available_days_class
	 */
	public String getAvailableDaysClass() {
		return available_days_class;
	}

	/**
	 * @param available_days_class the available_days_class to set
	 */
	public void setAvailableDaysClass(String available_days_class) {
		this.available_days_class = available_days_class;
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
	 * @return the practitioner image
	 */
	public String getPractitionerImage() {
		return practitioner_image;
	}

	/**
	 * @param practitioner_image the practitioner_image to set
	 */
	public void setPractitionerImage(String practitioner_image) {
		this.practitioner_image = practitioner_image;
	}

	/**
	 * @return the healthcareprovider image
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
	 * @return the currency code
	 */
	public String getCurrencyCode() {
		Currency curr = Currency.getInstance(currency);
		return curr.getSymbol(Locale.getDefault());
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
	 * @return the healthcareprovider_id
	 */
	public Integer getHealthcareproviderId() {
		return healthcareprovider_id;
	}

	/**
	 * @param healthcareprovider_id the healthcareprovider_id to set
	 */
	public void setHealthcareproviderId(Integer healthcareprovider_id) {
		this.healthcareprovider_id = healthcareprovider_id;
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
	 * 
	 * @param lon the lon to set
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
	 * @return the years_practiced
	 */
	public Integer getYearsPracticed() {
		return years_practiced;
	}

	/**
	 * @param years_practiced the years_practiced to set
	 */
	public void setYearsPracticed(Integer years_practiced) {
		this.years_practiced = years_practiced;
	}

	/**
	 * @return the number_performed_overall
	 */
	public Integer getNumberPerformedOverall() {
		return number_performed_overall;
	}

	/**
	 * @param number_performed_overall the number_performed_overall to set
	 */
	public void setNumberPerformedOverall(Integer number_performed_overall) {
		this.number_performed_overall = number_performed_overall;
	}

	/**
	 * @return the number_performed_last_year
	 */
	public Integer getNumberPerformedLastYear() {
		return number_performed_last_year;
	}

	/**
	 * @param number_performed_last_year the number_performed_last_year to set
	 */
	public void setNumberPerformedLastYear(Integer number_performed_last_year) {
		this.number_performed_last_year = number_performed_last_year;
	}

	/**
	 * @return the corrections_last_year
	 */
	public Integer getCorrectionsLastYear() {
		return corrections_last_year;
	}

	/**
	 * @param corrections_last_year the corrections_last_year to set
	 */
	public void setCorrectionsLastYear(Integer corrections_last_year) {
		this.corrections_last_year = corrections_last_year;
	}

	/**
	 * @return the insurance cap
	 */
	public Double getInsuranceCap() {
		return insurance_cap;
	}

	/**
	 * @param insurance_cap the insurance_cap to set
	 */
	public void setInsuranceCap(Double insurance_cap) {
		this.insurance_cap = insurance_cap;
	}

	/**
	 * @param healthcareprovider_practitioner_name the
	 * healthcareprovider_practitioner_name to set
	 */
	public void setHealthcareproviderPractitionerName(
			String healthcareprovider_practitioner_name) {
		this.healthcareprovider_practitioner_name = healthcareprovider_practitioner_name;
	}

	/**
	 * @return the healthcareprovider_practitioner_name
	 */
	public String getHealthcareproviderPractitionerName() {
		return healthcareprovider_practitioner_name;
	}

	/**
	 * @param healthcareprovider_practitioner_description the
	 * healthcareprovider_practitioner_description to set
	 */
	public void setHealthcareproviderPractitionerDescription(
			String healthcareprovider_practitioner_description) {
		this.healthcareprovider_practitioner_description = healthcareprovider_practitioner_description;
	}

	/**
	 * @return the healthcareprovider_practitioner_description
	 */
	public String getHealthcareproviderPractitionerDescription() {
		return healthcareprovider_practitioner_description;
	}

	/**
	 * @param healthcareprovider_practitioner_title the
	 * healthcareprovider_practitioner_titlel to set
	 */
	public void setHealthcareproviderPractitionerTitle(
			String healthcareprovider_practitioner_title) {
		this.healthcareprovider_practitioner_title = healthcareprovider_practitioner_title;
	}

	/**
	 * @return the healthcareprovider_practitioner_title
	 */
	public String getHealthcareproviderPractitionerTitle() {
		return healthcareprovider_practitioner_title;
	}
}