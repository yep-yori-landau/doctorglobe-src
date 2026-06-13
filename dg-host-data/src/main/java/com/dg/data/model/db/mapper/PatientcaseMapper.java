/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientcase;

/**
 * This class represent the mapping between Patientcase model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcaseMapper implements RowMapper<Patientcase> {
	/**
	 * This function map the Patientcase model object fields to a database
	 * fields and return the Patientcase model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcase
	 */
	public Patientcase mapRow(ResultSet rs, int rows) throws SQLException {
		Patientcase patientcase = new Patientcase();
		patientcase.setId(rs.getBigDecimal("id").toBigInteger());
		patientcase.setDescription(rs.getString("description"));
		patientcase.setStatus(rs.getString("status"));
		patientcase.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		patientcase.setPatient(rs.getBigDecimal("patient").toBigInteger());
		return patientcase;
	}
}
