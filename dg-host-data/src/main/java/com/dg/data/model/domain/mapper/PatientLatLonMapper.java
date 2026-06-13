package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.PatientLatLonModel;

/**
 * This class represent the mapping between PatientLatLonModel model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class PatientLatLonMapper implements RowMapper<PatientLatLonModel> {

	/**
	 * This function map the PatientLatLonModel model object fields to a
	 * database fields and return the PatientLatLonModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public PatientLatLonModel mapRow(ResultSet rs, int rows)
			throws SQLException {

		PatientLatLonModel model = new PatientLatLonModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		if (rs.getBigDecimal("country") != null) {
			model.setCountry(rs.getBigDecimal("country").toBigInteger());
		}
		if (rs.getBigDecimal("city") != null) {
			model.setCity(rs.getBigDecimal("city").toBigInteger());
		}
		model.setLat(rs.getDouble("lat"));
		model.setLon(rs.getDouble("lon"));
		model.setCityLat(rs.getDouble("city_lat"));
		model.setCityLon(rs.getDouble("city_lon"));
		model.setCityName(rs.getString("city_name"));
		if (rs.getBigDecimal("state") != null) {
			model.setCity(rs.getBigDecimal("state").toBigInteger());
		}
		model.setStateCode(rs.getString("state_code"));
		model.setStateName(rs.getString("state_name"));

		return model;
	}
}
