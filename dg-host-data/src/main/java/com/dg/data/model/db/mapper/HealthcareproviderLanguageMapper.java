/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderLanguage;

/**
 * This class represent the mapping between HealthcareproviderLanguage model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderLanguageMapper
		implements RowMapper<HealthcareproviderLanguage> {
	/**
	 * This function map the HealthcareproviderLanguage model object fields to a
	 * database fields and return the HealthcareproviderLanguage model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderlanguage
	 */
	public HealthcareproviderLanguage mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderLanguage healthcareproviderlanguage = new HealthcareproviderLanguage();
		healthcareproviderlanguage.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderlanguage.setLanguage(rs.getString("language"));
		healthcareproviderlanguage.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		return healthcareproviderlanguage;
	}
}
