/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Insurance;

/**
 * This class represent the mapping between Insurance model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class InsuranceMapper implements RowMapper<Insurance> {
	/**
	 * This function map the Insurance model object fields to a database fields
	 * and return the Insurance model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return insurance
	 */
	public Insurance mapRow(ResultSet rs, int rows) throws SQLException {
		Insurance insurance = new Insurance();
		insurance.setId(rs.getBigDecimal("id").toBigInteger());
		insurance.setName(rs.getString("name"));

		return insurance;
	}
}
