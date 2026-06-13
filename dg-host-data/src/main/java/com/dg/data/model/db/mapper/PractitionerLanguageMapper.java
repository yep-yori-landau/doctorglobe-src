/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.PractitionerLanguage;

/**
 * This class represent the mapping between PractitionerLanguage model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PractitionerLanguageMapper
		implements RowMapper<PractitionerLanguage> {
	/**
	 * This function map the PractitionerLanguage model object fields to a
	 * database fields and return the PractitionerLanguage model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return practitionerlanguage
	 */
	public PractitionerLanguage mapRow(ResultSet rs, int rows)
			throws SQLException {
		PractitionerLanguage practitionerlanguage = new PractitionerLanguage();
		practitionerlanguage.setId(rs.getBigDecimal("id").toBigInteger());
		practitionerlanguage.setLanguage(rs.getString("language"));
		practitionerlanguage.setPractitioner(
				rs.getBigDecimal("practitioner").toBigInteger());

		return practitionerlanguage;
	}
}
