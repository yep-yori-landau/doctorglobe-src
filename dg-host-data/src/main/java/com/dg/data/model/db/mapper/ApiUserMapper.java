/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.ApiUser;

/**
 * This class represent the mapping between ApiUser model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class ApiUserMapper implements RowMapper<ApiUser> {
	/**
	 * This function map the ApiUser model object fields to a database fields and
	 * return the ApiUser model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return user
	 */
	public ApiUser mapRow(ResultSet rs, int rows) throws SQLException {
		ApiUser user = new ApiUser();
		user.setId(rs.getBigDecimal("id").toBigInteger());
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setActive(rs.getBoolean("active"));
		return user;
	}
}
