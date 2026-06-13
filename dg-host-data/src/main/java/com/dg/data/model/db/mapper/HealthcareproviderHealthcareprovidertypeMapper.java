/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;

/**
 * This class represent the mapping between
 * HealthcareproviderHealthcareprovidertype model object fields to a database
 * fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderHealthcareprovidertypeMapper
		implements RowMapper<HealthcareproviderHealthcareprovidertype> {
	/**
	 * This function map the HealthcareproviderHealthcareprovidertype model
	 * object fields to a database fields and return the
	 * HealthcareproviderHealthcareprovidertype model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderhealthcareprovidertype
	 */
	public HealthcareproviderHealthcareprovidertype mapRow(ResultSet rs,
			int rows) throws SQLException {
		HealthcareproviderHealthcareprovidertype healthcareproviderHealthcareprovidertype = new HealthcareproviderHealthcareprovidertype();
		healthcareproviderHealthcareprovidertype
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderHealthcareprovidertype.setHealthcareprovidertype(
				rs.getBigDecimal("healthcareprovidertype").toBigInteger());
		healthcareproviderHealthcareprovidertype.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareproviderHealthcareprovidertype;
	}
}
