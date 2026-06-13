/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientreviewratings;

/**
 * This class represent the mapping between Patientreviewratings model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientreviewratingsMapper
		implements RowMapper<Patientreviewratings> {
	/**
	 * This function map the Patientreviewratings model object fields to a
	 * database fields and return the Patientreviewratings model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientreviewratings
	 */
	public Patientreviewratings mapRow(ResultSet rs, int rows)
			throws SQLException {
		Patientreviewratings patientreviewratings = new Patientreviewratings();
		patientreviewratings.setId(rs.getBigDecimal("id").toBigInteger());
		patientreviewratings.setRatingType(rs.getString("rating_type"));
		patientreviewratings.setRating(rs.getInt("rating"));
		patientreviewratings.setPatientReview(
				rs.getBigDecimal("patient_review").toBigInteger());

		return patientreviewratings;
	}
}
