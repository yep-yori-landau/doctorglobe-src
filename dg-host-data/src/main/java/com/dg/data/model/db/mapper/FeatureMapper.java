/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Feature;

/**
 * This class represent the mapping between Feature model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class FeatureMapper implements RowMapper<Feature> {
	/**
	 * This function map the Feature model object fields to a database fields
	 * and return the Feature model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return feature
	 */
	public Feature mapRow(ResultSet rs, int rows) throws SQLException {
		Feature feature = new Feature();
		feature.setId(rs.getBigDecimal("id").toBigInteger());
		feature.setName(rs.getString("name"));

		return feature;
	}
}
