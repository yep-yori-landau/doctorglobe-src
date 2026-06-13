/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Amenity;

/**
 * This class represent the mapping between Amenity model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AmenityMapper implements RowMapper<Amenity> {
	/**
	 * This function map the Amenity model object fields to a database fields
	 * and return the Amenity model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return amenity
	 */
	public Amenity mapRow(ResultSet rs, int rows) throws SQLException {
		Amenity amenity = new Amenity();
		amenity.setId(rs.getBigDecimal("id").toBigInteger());
		amenity.setName(rs.getString("name"));
		amenity.setIsDisplay(rs.getInt("is_display"));

		return amenity;
	}
}
