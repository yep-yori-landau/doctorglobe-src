/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientcaseaudit;

/**
 * This class represent the mapping between Patientcaseaudit model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcaseauditMapper implements RowMapper<Patientcaseaudit> {
	/**
	 * This function map the Patientcaseaudit model object fields to a database
	 * fields and return the Patientcaseaudit model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public Patientcaseaudit mapRow(ResultSet rs, int rows) throws SQLException {
		Patientcaseaudit patientcaseaudit = new Patientcaseaudit();
		patientcaseaudit.setId(rs.getBigDecimal("id").toBigInteger());
		patientcaseaudit.setChangeType(rs.getString("change_type"));
		patientcaseaudit.setChangeDt(rs.getString("change_dt"));
		patientcaseaudit.setStatusFrom(rs.getString("status_from"));
		patientcaseaudit.setStatusTo(rs.getString("status_to"));
		patientcaseaudit.setDescription(rs.getString("description"));
		patientcaseaudit.setPatientCase(
				rs.getBigDecimal("patient_case").toBigInteger());

		return patientcaseaudit;
	}
}
