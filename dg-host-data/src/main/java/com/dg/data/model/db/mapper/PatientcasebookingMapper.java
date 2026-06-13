/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientcasebooking;

/**
 * This class represent the mapping between Patientcasebooking model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcasebookingMapper implements RowMapper<Patientcasebooking> {
	/**
	 * This function map the Patientcasebooking model object fields to a
	 * database fields and return the Patientcasebooking model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcasebooking
	 */
	public Patientcasebooking mapRow(ResultSet rs, int rows)
			throws SQLException {
		Patientcasebooking patientcasebooking = new Patientcasebooking();
		patientcasebooking.setId(rs.getBigDecimal("id").toBigInteger());
		patientcasebooking.setReference(rs.getString("reference"));
		patientcasebooking.setBookingDt(rs.getString("booking_dt"));
		patientcasebooking.setStatus(rs.getString("status"));
		patientcasebooking.setPatientCase(
				rs.getBigDecimal("patient_case").toBigInteger());
		patientcasebooking
				.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
						.getBigDecimal(
								"healthcareprovider_specialty_treatment_method_practitioner")
						.toBigInteger());

		return patientcasebooking;
	}
}
