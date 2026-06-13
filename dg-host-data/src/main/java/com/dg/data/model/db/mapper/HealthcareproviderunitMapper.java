/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Healthcareproviderunit;

/**
 * This class represent the mapping between Healthcareproviderunit model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderunitMapper
		implements RowMapper<Healthcareproviderunit> {
	/**
	 * This function map the Healthcareproviderunit model object fields to a
	 * database fields and return the Healthcareproviderunit model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderunit
	 */
	public Healthcareproviderunit mapRow(ResultSet rs, int rows)
			throws SQLException {
		Healthcareproviderunit healthcareproviderunit = new Healthcareproviderunit();
		healthcareproviderunit.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderunit.setName(rs.getString("name"));

		return healthcareproviderunit;
	}
}
