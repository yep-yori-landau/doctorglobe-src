/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Practitioner;

/**
 * This class represent the mapping between Practitioner model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PractitionerMapper implements RowMapper<Practitioner> {
	/**
	 * This function map the Practitioner model object fields to a database
	 * fields and return the Practitioner model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return practitioner
	 */
	public Practitioner mapRow(ResultSet rs, int rows) throws SQLException {
		Practitioner practitioner = new Practitioner();
		practitioner.setId(rs.getBigDecimal("id").toBigInteger());
		practitioner.setTitle(rs.getString("title"));
		practitioner.setFirstName(rs.getString("first_name"));
		practitioner.setLastName(rs.getString("last_name"));
		practitioner.setDob(rs.getString("dob"));
		practitioner.setGender(rs.getString("gender"));
		practitioner.setMobile(rs.getString("mobile"));
		practitioner.setEmail(rs.getString("email"));
		practitioner.setPhone(rs.getString("phone"));
		practitioner.setAddress_1(rs.getString("address_1"));
		practitioner.setAddress_2(rs.getString("address_2"));
		practitioner.setZipCode(rs.getString("zip_code"));
		practitioner.setPhoto(rs.getString("photo"));
		practitioner.setDescription(rs.getString("description"));
		practitioner.setPassword(rs.getString("password"));
		practitioner.setUsaCertification(rs.getString("usa_certification"));
		practitioner.setUsaTraining(rs.getBoolean("usa_training"));
		if (rs.getString("graduation_dt") != null) {
			practitioner.setGraduationDt(rs.getString("graduation_dt"));
		}
		practitioner.setGraduationInstitution(
				rs.getString("graduation_institution"));
		if (rs.getString("specialty_dt") != null) {
			practitioner.setSpecialtyDt(rs.getString("specialty_dt"));
		}
		practitioner
				.setSpecialtyInstitution(rs.getString("specialty_institution"));
		practitioner.setType(rs.getBigDecimal("type").toBigInteger());
		practitioner.setRole(rs.getBigDecimal("role").toBigInteger());
		practitioner.setDegree(rs.getString("degree"));
		practitioner.setMedicalLicense(rs.getString("medical_license"));
		practitioner.setCity(rs.getBigDecimal("city").toBigInteger());

		return practitioner;
	}
}
