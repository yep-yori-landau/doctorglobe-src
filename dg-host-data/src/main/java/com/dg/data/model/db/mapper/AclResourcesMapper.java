/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.AclResources;

/**
 * This class represent the mapping between AclResources model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AclResourcesMapper implements RowMapper<AclResources> {
	/**
	 * This function map the AclResources model object fields to a database
	 * fields and return the AclResources model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return aclresources
	 */
	public AclResources mapRow(ResultSet rs, int rows) throws SQLException {
		AclResources aclresources = new AclResources();
		aclresources.setId(rs.getBigDecimal("id").toBigInteger());
		aclresources.setResource(rs.getString("resource"));

		return aclresources;
	}
}
