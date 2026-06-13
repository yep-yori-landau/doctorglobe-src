/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Treatment;

/**
 * This class represent the mapping between Treatment model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TreatmentMapper implements RowMapper<Treatment> {
	/**
	 * This function map the Treatment model object fields to a database fields
	 * and return the Treatment model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return treatment
	 */
	public Treatment mapRow(ResultSet rs, int rows) throws SQLException {
		Treatment treatment = new Treatment();
		treatment.setId(rs.getBigDecimal("id").toBigInteger());
		treatment.setName(rs.getString("name"));
		treatment.setDrgDefinition(rs.getString("drg_definition"));
		treatment.setDrgCode(rs.getString("drg_code"));
		treatment.setUsnewsName(rs.getString("usnews_name"));
		return treatment;
	}
}
