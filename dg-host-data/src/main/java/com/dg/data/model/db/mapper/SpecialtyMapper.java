/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Specialty;

/**
 * This class represent the mapping between Specialty model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class SpecialtyMapper implements RowMapper<Specialty> {
	/**
	 * This function map the Specialty model object fields to a database fields
	 * and return the Specialty model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return speciality
	 */
	public Specialty mapRow(ResultSet rs, int rows) throws SQLException {
		Specialty specialty = new Specialty();
		specialty.setId(rs.getBigDecimal("id").toBigInteger());
		specialty.setName(rs.getString("name"));

		return specialty;
	}
}
