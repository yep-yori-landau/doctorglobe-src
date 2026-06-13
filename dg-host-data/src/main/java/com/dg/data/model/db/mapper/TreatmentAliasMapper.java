/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.TreatmentAlias;

/**
 * This class represent the mapping between TreatmentAlias model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TreatmentAliasMapper implements RowMapper<TreatmentAlias> {
	/**
	 * This function map the TreatmentAlias model object fields to a database
	 * fields and return the TreatmentAlias model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return treatmentalias
	 */
	public TreatmentAlias mapRow(ResultSet rs, int rows) throws SQLException {
		TreatmentAlias treatmentalias = new TreatmentAlias();
		treatmentalias.setId(rs.getBigDecimal("id").toBigInteger());
		treatmentalias.setName(rs.getString("name"));
		treatmentalias
				.setTreatment(rs.getBigDecimal("treatment").toBigInteger());

		return treatmentalias;
	}
}
