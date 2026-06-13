/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Method;

/**
 * This class represent the mapping between Method model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class MethodMapper implements RowMapper<Method> {
	/**
	 * This function map the Method model object fields to a database fields and
	 * return the Method model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return method
	 */
	public Method mapRow(ResultSet rs, int rows) throws SQLException {
		Method method = new Method();
		method.setId(rs.getBigDecimal("id").toBigInteger());
		method.setName(rs.getString("name"));

		return method;
	}
}
