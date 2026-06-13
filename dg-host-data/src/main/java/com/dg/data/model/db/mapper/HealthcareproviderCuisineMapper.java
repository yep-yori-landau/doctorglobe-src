/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderCuisine;

/**
 * This class represent the mapping between HealthcareproviderCuisine model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderCuisineMapper
		implements RowMapper<HealthcareproviderCuisine> {
	/**
	 * This function map the HealthcareproviderCuisine model object fields to a
	 * database fields and return the HealthcareproviderCuisine model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareprovidercuisine
	 */
	public HealthcareproviderCuisine mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderCuisine healthcareprovidercuisine = new HealthcareproviderCuisine();
		healthcareprovidercuisine.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareprovidercuisine
				.setCuisine(rs.getBigDecimal("cuisine").toBigInteger());
		healthcareprovidercuisine.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareprovidercuisine;
	}
}
