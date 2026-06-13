package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.PatientCountryModel;

/**
 * This class represent the mapping between PatientCountryModel model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class PatientCountryModelMapper
		implements RowMapper<PatientCountryModel> {

	/**
	 * This function map the PatientCountryModel model object fields to a
	 * database fields and return the PatientCountryModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public PatientCountryModel mapRow(ResultSet rs, int rows)
			throws SQLException {

		PatientCountryModel model = new PatientCountryModel();

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
