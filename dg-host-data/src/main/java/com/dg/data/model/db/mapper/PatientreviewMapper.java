/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientreview;

/**
 * This class represent the mapping between Patientreview model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientreviewMapper implements RowMapper<Patientreview> {
	/**
	 * This function map the Patientreview model object fields to a database
	 * fields and return the Patientreview model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientreview
	 */
	public Patientreview mapRow(ResultSet rs, int rows) throws SQLException {
		Patientreview patientreview = new Patientreview();
		patientreview.setId(rs.getBigDecimal("id").toBigInteger());
		patientreview.setDescription(rs.getString("description"));
		patientreview.setPatient(rs.getBigDecimal("patient").toBigInteger());
		patientreview
				.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
						.getBigDecimal(
								"healthcareprovider_specialty_treatment_method_practitioner")
						.toBigInteger());
		return patientreview;
	}
}
