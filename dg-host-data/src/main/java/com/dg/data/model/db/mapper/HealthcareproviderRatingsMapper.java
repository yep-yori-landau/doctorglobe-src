/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderRatings;

/**
 * This class represent the mapping between HealthcareproviderRatings model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderRatingsMapper
		implements RowMapper<HealthcareproviderRatings> {
	/**
	 * This function map the HealthcareproviderRatings model object fields to a
	 * database fields and return the HealthcareproviderRatings model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderratings
	 */
	public HealthcareproviderRatings mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderRatings healthcareproviderratings = new HealthcareproviderRatings();
		healthcareproviderratings.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderratings.setScore(rs.getInt("score"));
		healthcareproviderratings.setRatingcompany(
				rs.getBigDecimal("ratingcompany").toBigInteger());
		healthcareproviderratings.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareproviderratings;
	}
}
