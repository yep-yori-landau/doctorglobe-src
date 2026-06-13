/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Ratingcompanies;

/**
 * This class represent the mapping between Ratingcompanies model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class RatingcompaniesMapper implements RowMapper<Ratingcompanies> {
	/**
	 * This function map the Ratingcompanies model object fields to a database
	 * fields and return the Ratingcompanies model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return ratingcompanies
	 */
	public Ratingcompanies mapRow(ResultSet rs, int rows) throws SQLException {
		Ratingcompanies ratingcompanies = new Ratingcompanies();
		ratingcompanies.setId(rs.getBigDecimal("id").toBigInteger());
		ratingcompanies.setName(rs.getString("name"));
		ratingcompanies.setMaxScore(rs.getInt("max_score"));

		return ratingcompanies;
	}
}
