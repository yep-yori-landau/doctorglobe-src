/**
 * 
 */
package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.HealthcareproviderPractitionerCountryModel;

/**
 * This class represent the mapping between
 * HealthcareproviderPractitionerCountryModel model object fields to a database
 * fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class HealthcareproviderPractitionerCountryModelMapper
		implements RowMapper<HealthcareproviderPractitionerCountryModel> {
	/**
	 * This function map the HealthcareproviderPractitionerCountryModel model
	 * object fields to a database fields and return the
	 * HealthcareproviderPractitionerCountryModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public HealthcareproviderPractitionerCountryModel mapRow(ResultSet rs,
			int rows) throws SQLException {
		HealthcareproviderPractitionerCountryModel model = new HealthcareproviderPractitionerCountryModel();

		if (rs.getString("country") != null) {
			model.setCountry(rs.getString("country"));
		}
		if (rs.getString("country_code") != null) {
			model.setCountryCode(rs.getString("country_code"));
		}
		if (rs.getString("city") != null) {
			model.setCity(rs.getString("city"));
		}
		if (rs.getString("state") != null) {
			model.setState(rs.getString("state"));
		}
		return model;
	}
}
