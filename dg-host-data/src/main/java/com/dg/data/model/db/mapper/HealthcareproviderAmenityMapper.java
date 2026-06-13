/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderAmenity;

/**
 * This class represent the mapping between HealthcareproviderAmenity model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderAmenityMapper
		implements RowMapper<HealthcareproviderAmenity> {
	/**
	 * This function map the HealthcareproviderAmenity model object fields to a
	 * database fields and return the HealthcareproviderAmenity model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareprovideramenity
	 */
	public HealthcareproviderAmenity mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderAmenity healthcareprovideramenity = new HealthcareproviderAmenity();
		healthcareprovideramenity.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareprovideramenity.setCurrency(rs.getString("currency"));
		healthcareprovideramenity.setPrice(rs.getDouble("price"));
		healthcareprovideramenity.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		healthcareprovideramenity
				.setAmenity(rs.getBigDecimal("amenity").toBigInteger());

		return healthcareprovideramenity;
	}
}
