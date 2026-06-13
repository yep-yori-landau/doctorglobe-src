/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientcasemessages;

/**
 * This class represent the mapping between Patientcasemessages model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcasemessagesMapper
		implements RowMapper<Patientcasemessages> {
	/**
	 * This function map the Patientcasemessages model object fields to a
	 * database fields and return the Patientcasemessages model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcasemessages
	 */
	public Patientcasemessages mapRow(ResultSet rs, int rows)
			throws SQLException {
		Patientcasemessages patientcasemessages = new Patientcasemessages();
		patientcasemessages.setId(rs.getBigDecimal("id").toBigInteger());
		patientcasemessages.setReference(rs.getString("reference"));
		patientcasemessages.setSenderType(rs.getString("sender_type"));
		patientcasemessages.setSender(rs.getInt("sender"));
		patientcasemessages.setReceiverType(rs.getString("receiver_type"));
		patientcasemessages.setReceiver(rs.getInt("receiver"));
		patientcasemessages.setSubject(rs.getString("subject"));
		patientcasemessages.setBody(rs.getString("body"));
		patientcasemessages.setSentDt(rs.getString("sent_dt"));
		patientcasemessages.setStatus(rs.getString("status"));
		patientcasemessages.setPatientCase(
				rs.getBigDecimal("patient_case").toBigInteger());

		return patientcasemessages;
	}
}
