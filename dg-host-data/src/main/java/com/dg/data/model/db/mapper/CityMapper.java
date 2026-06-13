/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.City;

/**
 * This class represent the mapping between City model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class CityMapper implements RowMapper<City> {
	/**
	 * This function map the City model object fields to a database fields and
	 * return the City model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return city
	 */
	public City mapRow(ResultSet rs, int rows) throws SQLException {
		City city = new City();
		city.setId(rs.getBigDecimal("id").toBigInteger());
		city.setName(rs.getString("name"));
		if (rs.getBigDecimal("state") != null) {
			city.setState(rs.getBigDecimal("state").toBigInteger());
		}
		city.setCountry(rs.getBigDecimal("country").toBigInteger());
		city.setLat(rs.getDouble("lat"));
		city.setLon(rs.getDouble("lon"));
		return city;
	}
}
