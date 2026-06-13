/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Associate;

/**
 * This class represent the mapping between Associate model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AssociateMapper implements RowMapper<Associate> {
	/**
	 * This function map the Associate model object fields to a database fields
	 * and return the Associate model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return associate
	 */
	public Associate mapRow(ResultSet rs, int rows) throws SQLException {
		Associate associate = new Associate();
		associate.setId(rs.getBigDecimal("id").toBigInteger());
		associate.setTitle(rs.getString("title"));
		associate.setFirstName(rs.getString("first_name"));
		associate.setLastName(rs.getString("last_name"));
		associate.setEmail(rs.getString("email"));
		associate.setPassword(rs.getString("password"));
		associate.setActive(rs.getBoolean("active"));
		if (rs.getBigDecimal("association") != null) {
			associate.setAssociation(
					rs.getBigDecimal("association").toBigInteger());
		}
		associate.setPhone_1(rs.getString("phone_1"));
		associate.setMobilephone_1(rs.getString("mobilephone_1"));
		return associate;
	}
}
