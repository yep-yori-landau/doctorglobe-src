/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Translations;

/**
 * This class represent the mapping between Translations model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TranslationsMapper implements RowMapper<Translations> {
	/**
	 * This function map the Translations model object fields to a database
	 * fields and return the Translations model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return translations
	 */
	public Translations mapRow(ResultSet rs, int rows) throws SQLException {
		Translations translations = new Translations();
		translations.setId(rs.getBigDecimal("id").toBigInteger());
		translations.setLang(rs.getString("lang"));
		translations.setLabel(rs.getString("label"));
		translations.setText(rs.getString("text"));

		return translations;
	}
}
