/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Cuisine;

/**
 * This class represent the mapping between Cuisine model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class CuisineMapper implements RowMapper<Cuisine> {
	/**
	 * This function map the Cuisine model object fields to a database fields
	 * and return the Cuisine model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return cuisine
	 */
	public Cuisine mapRow(ResultSet rs, int rows) throws SQLException {
		Cuisine cuisine = new Cuisine();
		cuisine.setId(rs.getBigDecimal("id").toBigInteger());
		cuisine.setName(rs.getString("name"));

		return cuisine;
	}
}
