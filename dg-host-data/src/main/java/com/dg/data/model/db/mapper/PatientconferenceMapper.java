/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientconference;

/**
 * This class represent the mapping between Patientconference model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientconferenceMapper implements RowMapper<Patientconference> {
	/**
	 * This function map the Patientconference model object fields to a database
	 * fields and return the Patientconference model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientconference
	 */
	public Patientconference mapRow(ResultSet rs, int rows)
			throws SQLException {
		Patientconference patientconference = new Patientconference();
		patientconference.setId(rs.getBigDecimal("id").toBigInteger());
		patientconference
				.setConferenceDt(rs.getTimestamp("conference_dt").toString());
		patientconference.setStatus(rs.getString("status"));
		patientconference
				.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
						.getBigDecimal(
								"healthcareprovider_specialty_treatment_method_practitioner")
						.toBigInteger());
		patientconference.setPatientCase(
				rs.getBigDecimal("patient_case").toBigInteger());
		patientconference.setTimezone(rs.getString("timezone"));
		return patientconference;
	}
}
