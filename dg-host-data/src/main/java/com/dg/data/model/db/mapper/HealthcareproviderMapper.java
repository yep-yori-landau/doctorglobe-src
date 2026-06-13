/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Healthcareprovider;

/**
 * This class represent the mapping between Healthcareprovider model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderMapper implements RowMapper<Healthcareprovider> {
	/**
	 * This function map the Healthcareprovider model object fields to a
	 * database fields and return the Healthcareprovider model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareprovider
	 */
	public Healthcareprovider mapRow(ResultSet rs, int rows)
			throws SQLException {
		Healthcareprovider healthcareprovider = new Healthcareprovider();
		healthcareprovider.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareprovider.setName(rs.getString("name"));
		healthcareprovider.setAddress_1(rs.getString("address_1"));
		healthcareprovider.setAddress_2(rs.getString("address_2"));
		healthcareprovider.setZipCode(rs.getString("zip_code"));
		healthcareprovider.setWebsite(rs.getString("website"));
		healthcareprovider.setContactName(rs.getString("contact_name"));
		healthcareprovider.setPhone_1(rs.getString("phone_1"));
		healthcareprovider.setPhone_2(rs.getString("phone_2"));
		healthcareprovider.setEmail(rs.getString("email"));
		healthcareprovider.setFax(rs.getString("fax"));
		healthcareprovider.setDescription(rs.getString("description"));
		healthcareprovider.setEstablished(rs.getString("established"));
		healthcareprovider
				.setBuildingCommissioned(rs.getString("building_commissioned"));
		healthcareprovider.setRenovated(rs.getString("renovated"));
		healthcareprovider.setAffiliation(rs.getString("affiliation"));
		healthcareprovider.setCmsCertificate(rs.getString("cms_certificate"));
		healthcareprovider.setNpi(rs.getString("npi"));
		healthcareprovider
				.setTeachingHospital(rs.getBoolean("teaching_hospital"));
		healthcareprovider.setReadmissionRate(rs.getInt("readmission_rate"));
		healthcareprovider.setMortalityRate(rs.getInt("mortality_rate"));
		healthcareprovider.setInfectionRate(rs.getInt("infection_rate"));
		healthcareprovider.setMedicalLawsuit(rs.getBoolean("medical_lawsuit"));
		healthcareprovider.setLat(rs.getDouble("lat"));
		healthcareprovider.setLon(rs.getDouble("lon"));
		if (rs.getBigDecimal("branch") != null) {
			healthcareprovider
					.setBranch(rs.getBigDecimal("branch").toBigInteger());
		}
		if (rs.getBigDecimal("chain") != null) {
			healthcareprovider
					.setChain(rs.getBigDecimal("chain").toBigInteger());
		}
		if (rs.getBigDecimal("city") != null) {
			healthcareprovider.setCity(rs.getBigDecimal("city").toBigInteger());
		}
		healthcareprovider.setType(rs.getString("type"));
		healthcareprovider.setCurrency(rs.getString("currency"));
		healthcareprovider.setCcEmail(rs.getBoolean("cc_email"));
		healthcareprovider.setInsuranceCap(rs.getBigDecimal("insurance_cap"));
		healthcareprovider.setPolicyFile(rs.getString("policy_file"));
		healthcareprovider.setIsPolicyCoveredPractitioners(
				rs.getBoolean("is_policy_covered_practitioners"));
		healthcareprovider
				.setInsuranceCarrier(rs.getString("insurance_carrier"));
		healthcareprovider.setPolicyNumber(rs.getString("policy_number"));
		healthcareprovider.setPerCaseInsuranceCap(
				rs.getBigDecimal("per_case_insurance_cap"));
		healthcareprovider.setDrgId(rs.getString("drg_id"));
		healthcareprovider.setHrrDescription(rs.getString("hrr_description"));
		healthcareprovider.setAhaId(rs.getString("aha_id"));
		healthcareprovider.setAhaName(rs.getString("aha_name"));
		healthcareprovider.setAdminTitle(rs.getString("admin_title"));
		return healthcareprovider;
	}
}
