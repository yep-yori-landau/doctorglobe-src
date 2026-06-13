/**
 * 
 */
package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.PractitionerDetail;

/**
 * This class represent the mapping between PractitionerDetail model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class PractitionerDetailMapper implements RowMapper<PractitionerDetail> {
	/**
	 * This function map the PractitionerDetail model object fields to a
	 * database fields and return the PractitionerDetail model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public PractitionerDetail mapRow(ResultSet rs, int rows)
			throws SQLException {
		PractitionerDetail practitionerDetail = new PractitionerDetail();
		practitionerDetail.setId(rs.getInt("id"));
		practitionerDetail.setTitle(rs.getString("title"));
		practitionerDetail.setName(rs.getString("name"));
		if (rs.getString("degree") != null) {
			practitionerDetail.setDegree(rs.getString("degree"));
		}
		practitionerDetail.setEmail(rs.getString("email"));
		practitionerDetail.setGender(rs.getString("gender"));
		practitionerDetail.setDescription(rs.getString("description"));
		practitionerDetail.setRating(rs.getString("rating"));
		practitionerDetail
				.setUsaCertification(rs.getString("usa_certification"));
		practitionerDetail.setUsaTraining(rs.getBoolean("usa_training"));
		practitionerDetail.setTreatmentName(rs.getString("treatment_name"));
		practitionerDetail.setLanguage(rs.getString("language"));
		practitionerDetail.setAvailableDays(rs.getInt("available_days"));
		practitionerDetail.setHcpstmp(rs.getInt("hcpstmp"));
		practitionerDetail.setCurrency(rs.getString("currency"));
		practitionerDetail.setEstimatedCost(rs.getDouble("estimated_cost"));
		practitionerDetail.setHealthcareproviderName(
				rs.getString("healthcareprovider_name"));
		practitionerDetail.setHealthcareproviderDescription(
				rs.getString("healthcareprovider_description"));
		practitionerDetail.setHealthcareproviderLocation(
				rs.getString("healthcareprovider_location"));
		practitionerDetail.setUnit(rs.getString("unit"));
		practitionerDetail
				.setPractitionerImage(rs.getString("practitioner_image"));
		practitionerDetail.setHealthcareproviderImage(
				rs.getString("healthcareprovider_image"));
		practitionerDetail.setFeature(rs.getString("feature"));
		practitionerDetail.setUnitDescription(rs.getString("unit_description"));
		practitionerDetail
				.setHealthcareproviderId(rs.getInt("healthcareprovider_id"));
		practitionerDetail.setHealthcareproviderCity(
				rs.getString("healthcareprovider_city"));
		practitionerDetail.setHealthcareproviderState(
				rs.getString("healthcareprovider_state"));
		practitionerDetail.setHealthcareproviderCountry(
				rs.getString("healthcareprovider_country"));
		practitionerDetail.setAmenity(rs.getString("amenity"));
		practitionerDetail.setIsDisplay(rs.getBoolean("is_display"));
		practitionerDetail.setEquipment(rs.getString("equipment"));
		practitionerDetail
				.setIsEquipmentDisplay(rs.getBoolean("is_equipment_display"));
		practitionerDetail.setLat(rs.getString("lat"));
		practitionerDetail.setLon(rs.getString("lon"));
		practitionerDetail.setIsPrimary(rs.getBoolean("is_primary"));
		practitionerDetail.setYearsPracticed(rs.getInt("years_practiced"));
		practitionerDetail.setNumberPerformedOverall(
				rs.getInt("number_performed_overall"));
		practitionerDetail.setNumberPerformedLastYear(
				rs.getInt("number_performed_last_year"));
		practitionerDetail
				.setCorrectionsLastYear(rs.getInt("corrections_last_year"));
		practitionerDetail.setInsuranceCap(rs.getDouble("insurance_cap"));
		practitionerDetail.setHealthcareproviderPractitionerName(
				rs.getString("healthcareprovider_practitioner_name"));
		practitionerDetail.setHealthcareproviderPractitionerTitle(
				rs.getString("healthcareprovider_practitioner_title"));
		practitionerDetail.setHealthcareproviderPractitionerDescription(
				rs.getString("healthcareprovider_practitioner_description"));
		return practitionerDetail;
	}
}
