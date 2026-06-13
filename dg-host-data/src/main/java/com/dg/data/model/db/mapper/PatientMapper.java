/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patient;

/**
 * This class represent the mapping between Patient model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientMapper implements RowMapper<Patient> {
	/**
	 * This function map the Patient model object fields to a database fields
	 * and return the Patient model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patient
	 */
	public Patient mapRow(ResultSet rs, int rows) throws SQLException {
		Patient patient = new Patient();
		patient.setId(rs.getBigDecimal("id").toBigInteger());
		patient.setTitle(rs.getString("title"));
		patient.setFirstName(rs.getString("first_name"));
		patient.setLastName(rs.getString("last_name"));
		patient.setDob(rs.getString("dob"));
		patient.setGender(rs.getString("gender"));
		patient.setMobile(rs.getString("mobile"));
		patient.setEmail(rs.getString("email"));
		patient.setPhone(rs.getString("phone"));
		patient.setPassword(rs.getString("password"));
		patient.setAddress(rs.getString("address"));
		patient.setZipCode(rs.getString("zip_code"));
		if (rs.getBigDecimal("city") != null) {
			patient.setCity(rs.getBigDecimal("city").toBigInteger());
		}
		patient.setPhoto(rs.getString("photo"));
		patient.setActive(rs.getBoolean("active"));
		patient.setLat(rs.getDouble("lat"));
		patient.setLon(rs.getDouble("lon"));
		patient.setUserAgreement(rs.getBoolean("user_agreement"));
		if (rs.getBigDecimal("dependent") != null) {
			patient.setDependent(rs.getBigDecimal("dependent").toBigInteger());
		}
		patient.setYtdOop(rs.getDouble("ytd_oop"));
		return patient;
	}
}
