/**
 * 
 */
package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.HealthcareproviderDetail;

/**
 * This class represent the mapping between HealthcareproviderDetail model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author kkowlgi
 */

public class HealthcareproviderDetailMapper
		implements RowMapper<HealthcareproviderDetail> {
	/**
	 * This function map the HealthcareproviderDetail model object fields to a
	 * database fields and return the HealthcareproviderDetail model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public HealthcareproviderDetail mapRow(ResultSet rs, int rows)
			throws SQLException {
		String location = "";
		HealthcareproviderDetail healthcareproviderDetail = new HealthcareproviderDetail();
		healthcareproviderDetail.setId(rs.getInt("id"));
		healthcareproviderDetail.setName(rs.getString("name"));
		if (rs.getString("state") != null) {
			location += ", " + rs.getString("state");
		}
		/*
		 * if(rs.getString("country_name") != null){ location += ", "
		 * +rs.getString("country_name"); }
		 */
		if (rs.getString("zip_code") != null) {
			location += ", " + rs.getString("zip_code");
		}
		healthcareproviderDetail.setLocation(rs.getString("location") + location);
		healthcareproviderDetail.setDescription(rs.getString("description"));
		healthcareproviderDetail.setExperts(rs.getInt("experts"));
		healthcareproviderDetail.setRating(rs.getInt("rating"));
		healthcareproviderDetail.setTreatmentName(rs.getString("treatment_name"));
		healthcareproviderDetail.setAvailableDays(rs.getInt("available_days"));
		healthcareproviderDetail.setEstimatedCost(rs.getDouble("estimated_cost"));
		healthcareproviderDetail.setRegionName(rs.getString("region_name"));
		healthcareproviderDetail.setCurrency(rs.getString("currency"));
		healthcareproviderDetail.setAmenity(rs.getString("amenity"));
		healthcareproviderDetail.setAccreditation(rs.getString("accreditation"));
		healthcareproviderDetail.setUnit(rs.getString("unit"));
		healthcareproviderDetail.setHealthcareproviderImage(rs.getString("healthcareprovider_image"));
		healthcareproviderDetail.setImageType(rs.getString("image_type"));
		healthcareproviderDetail.setIsDisplay(rs.getBoolean("is_display"));
		healthcareproviderDetail.setEquipment(rs.getString("equipment"));
		healthcareproviderDetail.setIsEquipmentDisplay(rs.getBoolean("is_equipment_display"));
		healthcareproviderDetail.setFeature(rs.getString("feature"));
		healthcareproviderDetail.setUnitDescription(rs.getString("unit_description"));
		healthcareproviderDetail.setIsPrimary(rs.getBoolean("is_primary"));
		healthcareproviderDetail.setLat(rs.getString("lat"));
		healthcareproviderDetail.setLon(rs.getString("lon"));
		healthcareproviderDetail.setRanking(0);
		healthcareproviderDetail.setCity(rs.getBigDecimal("city").toBigInteger());
		healthcareproviderDetail.setMortalityRate(rs.getInt("mortality_rate"));
		healthcareproviderDetail.setPerCaseInsuranceCap(rs.getBigDecimal("per_case_insurance_cap"));

		if (rs.getString("affiliation") != null || rs.getString("affiliation") != "") {
			healthcareproviderDetail.setAffiliation(rs.getString("affiliation"));
		}
		if (rs.getBigDecimal("corporatecompany_insurance") != null) {
			healthcareproviderDetail.setCorporatecompanyInsurance(rs.getBigDecimal("corporatecompany_insurance").toBigInteger());
		}
		healthcareproviderDetail.setNumberPerformedLastYear(rs.getInt("number_performed_last_year"));
		healthcareproviderDetail.setHcpstmpId(rs.getBigDecimal("hcpstmp_id").toBigInteger());
		healthcareproviderDetail.setRate(rs.getDouble("rate"));
		healthcareproviderDetail.setCityLat(rs.getDouble("city_lat"));
		healthcareproviderDetail.setCityLon(rs.getDouble("city_lon"));
		if (rs.getString("website") != null) {
			healthcareproviderDetail.setWebsite(rs.getString("website"));
		}
		if (rs.getString("aha_id") != null) {
			healthcareproviderDetail.setAhaId(rs.getString("aha_id"));
		}
		healthcareproviderDetail.setUsnewsDoctorLink(rs.getString("usnews_doctor_link"));
		healthcareproviderDetail.setUsnewsName(rs.getString("usnews_name"));
		healthcareproviderDetail.setStateCode(rs.getString("state_code"));
		healthcareproviderDetail.setPractitioner(rs.getBigDecimal("practitioner").toBigInteger());
		healthcareproviderDetail.setBeforeDays(rs.getInt("before_days"));
		healthcareproviderDetail.setAfterDays(rs.getInt("after_days"));
		healthcareproviderDetail.setTreatmentDays(rs.getInt("treatment_days"));
		healthcareproviderDetail.setDailyExpense(rs.getDouble("daily_expense"));
		healthcareproviderDetail.setCountry(rs.getBigDecimal("country").toBigInteger());
		healthcareproviderDetail.setZipCode(rs.getString("zip_code"));
		if(rs.getString("address_1") != null){
			healthcareproviderDetail.setAddress_1(rs.getString("address_1"));
		}
		if(rs.getString("address_2") != null){
			healthcareproviderDetail.setAddress_2(rs.getString("address_2"));
		}
		if(rs.getString("location") != null){
			healthcareproviderDetail.setCityName(rs.getString("location"));
		}
		if(rs.getString("state") != null){
			healthcareproviderDetail.setStateName(rs.getString("state"));
		}
		if(rs.getString("country_name") != null){
			healthcareproviderDetail.setCountryName(rs.getString("country_name"));
		}
		return healthcareproviderDetail;
	}
}
