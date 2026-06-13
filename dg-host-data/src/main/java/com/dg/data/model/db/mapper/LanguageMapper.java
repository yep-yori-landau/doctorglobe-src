/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Language;

/**
 * This class represent the mapping between Language model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class LanguageMapper implements RowMapper<Language> {
	/**
	 * This function map the Language model object fields to a database fields
	 * and return the Language model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public Language mapRow(ResultSet rs, int rows) throws SQLException {
		Language language = new Language();
		language.setId(rs.getInt("id"));
		language.setCode(rs.getString("code"));
		language.setName(rs.getString("name"));

		return language;
	}
}
