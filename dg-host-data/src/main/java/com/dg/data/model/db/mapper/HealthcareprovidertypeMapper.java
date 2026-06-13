/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Healthcareprovidertype;

/**
 * This class represent the mapping between Healthcareprovidertype model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareprovidertypeMapper
		implements RowMapper<Healthcareprovidertype> {
	/**
	 * This function map the Healthcareprovidertype model object fields to a
	 * database fields and return the Healthcareprovidertype model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return facilitytype
	 */
	public Healthcareprovidertype mapRow(ResultSet rs, int rows)
			throws SQLException {
		Healthcareprovidertype facilitytype = new Healthcareprovidertype();
		facilitytype.setId(rs.getBigDecimal("id").toBigInteger());
		facilitytype.setName(rs.getString("name"));

		return facilitytype;
	}
}
