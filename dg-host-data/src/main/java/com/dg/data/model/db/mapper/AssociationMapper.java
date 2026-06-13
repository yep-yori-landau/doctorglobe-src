/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Association;

/**
 * This class represent the mapping between Association model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AssociationMapper implements RowMapper<Association> {
	/**
	 * This function map the Association model object fields to a database
	 * fields and return the Association model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return associatoin model
	 */
	public Association mapRow(ResultSet rs, int rows) throws SQLException {
		Association association = new Association();
		association.setId(rs.getBigDecimal("id").toBigInteger());
		association.setName(rs.getString("name"));
		association.setWhitelabelUrl(rs.getString("whitelabel_url"));
		association.setTheme(rs.getString("theme"));
		return association;
	}
}
