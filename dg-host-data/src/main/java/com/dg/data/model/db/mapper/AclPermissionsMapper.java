/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.AclPermissions;

/**
 * This class represent the mapping between AclPermissions model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AclPermissionsMapper implements RowMapper<AclPermissions> {
	/**
	 * This function map the AclPermissions model object fields to a database
	 * fields and return the AclPermissions model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return aclpermissions
	 */
	public AclPermissions mapRow(ResultSet rs, int rows) throws SQLException {
		AclPermissions aclpermissions = new AclPermissions();
		aclpermissions.setId(rs.getBigDecimal("id").toBigInteger());
		aclpermissions.setRole(rs.getBigDecimal("role").toBigInteger());
		aclpermissions.setResource(rs.getBigDecimal("resource").toBigInteger());
		aclpermissions.setPermission(rs.getString("permission"));

		return aclpermissions;
	}
}
