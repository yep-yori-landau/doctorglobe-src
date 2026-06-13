/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Treatmentdays;

/**
 * This class represent the mapping between Treatmentdays model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TreatmentdaysMapper implements RowMapper<Treatmentdays> {
	/**
	 * This function map the Treatmentdays model object fields to a database
	 * fields and return the Treatmentdays model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public Treatmentdays mapRow(ResultSet rs, int rows) throws SQLException {
		Treatmentdays model = new Treatmentdays();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		model.setBeforeDays(rs.getInt("before_days"));
		model.setAfterDays(rs.getInt("after_days"));
		model.setTreatmentDays(rs.getInt("treatment_days"));
		model.setCountry(rs.getBigDecimal("country").toBigInteger());
		return model;
	}
}
