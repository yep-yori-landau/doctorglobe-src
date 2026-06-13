/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderUnitFeature;

/**
 * This class represent the mapping between HealthcareproviderUnitFeature model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderUnitFeatureMapper
		implements RowMapper<HealthcareproviderUnitFeature> {
	/**
	 * This function map the HealthcareproviderUnitFeature model object fields
	 * to a database fields and return the HealthcareproviderUnitFeature model
	 * object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderunitfeature
	 */
	public HealthcareproviderUnitFeature mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderUnitFeature healthcareproviderunitfeature = new HealthcareproviderUnitFeature();
		healthcareproviderunitfeature
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderunitfeature
				.setDescription(rs.getString("description"));
		healthcareproviderunitfeature
				.setFeature(rs.getBigDecimal("feature").toBigInteger());
		healthcareproviderunitfeature.setHealthcareproviderunit(
				rs.getBigDecimal("healthcareproviderunit").toBigInteger());
		healthcareproviderunitfeature.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareproviderunitfeature;
	}
}
