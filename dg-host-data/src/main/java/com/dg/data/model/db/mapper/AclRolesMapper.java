/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.AclRoles;

/**
 * This class represent the mapping between AclRoles model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AclRolesMapper implements RowMapper<AclRoles> {
	/**
	 * This function map the AclRoles model object fields to a database fields
	 * and return the AclRoles model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return aclroles
	 */
	public AclRoles mapRow(ResultSet rs, int rows) throws SQLException {
		AclRoles aclroles = new AclRoles();
		aclroles.setId(rs.getBigDecimal("id").toBigInteger());
		aclroles.setRole(rs.getString("role"));

		return aclroles;
	}
}
