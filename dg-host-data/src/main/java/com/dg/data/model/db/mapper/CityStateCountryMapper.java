/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.City;
import com.dg.data.model.domain.CityStateCountryModel;

/**
 * This class represent the mapping between CityStateCountryModel model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class CityStateCountryMapper
		implements RowMapper<CityStateCountryModel> {
	/**
	 * This function map the CityStateCountryModel model object fields to a
	 * database fields and return the CityStateCountryModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return city
	 */
	public CityStateCountryModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		CityStateCountryModel model = new CityStateCountryModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setCity(rs.getString("city"));
		model.setCountry(rs.getString("country"));
		model.setState(rs.getString("state"));
		return model;
	}
}
