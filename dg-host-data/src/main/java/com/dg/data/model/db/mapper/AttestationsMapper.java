/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Attestations;

/**
 * This class represent the mapping between Attestations model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AttestationsMapper implements RowMapper<Attestations> {
	/**
	 * This function map the Attestations model object fields to a database
	 * fields and return the Attestations model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return attestations
	 */
	public Attestations mapRow(ResultSet rs, int rows) throws SQLException {
		Attestations attestations = new Attestations();
		attestations.setId(rs.getBigDecimal("id").toBigInteger());
		attestations.setName(rs.getString("name"));

		return attestations;
	}
}
