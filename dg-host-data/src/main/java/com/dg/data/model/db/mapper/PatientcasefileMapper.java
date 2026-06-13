/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Patientcasefile;

/**
 * This class represent the mapping between Patientcasefile model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcasefileMapper implements RowMapper<Patientcasefile> {
	/**
	 * This function map the Patientcasefile model object fields to a database
	 * fields and return the Patientcasefile model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcasefile
	 */
	public Patientcasefile mapRow(ResultSet rs, int rows) throws SQLException {
		Patientcasefile patientcasefile = new Patientcasefile();
		patientcasefile.setId(rs.getBigDecimal("id").toBigInteger());
		patientcasefile.setDescription(rs.getString("description"));
		patientcasefile.setFileType(rs.getString("file_type"));
		patientcasefile.setFileName(rs.getString("file_name"));
		patientcasefile.setFileDt(rs.getString("file_dt"));
		patientcasefile.setPatientCase(
				rs.getBigDecimal("patient_case").toBigInteger());
		patientcasefile.setName(rs.getString("name"));
		patientcasefile
				.setDocument(rs.getBigDecimal("document").toBigInteger());
		return patientcasefile;
	}
}
