/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.User;

/**
 * This class represent the mapping between User model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class UserMapper implements RowMapper<User> {
	/**
	 * This function map the User model object fields to a database fields and
	 * return the User model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return user
	 */
	public User mapRow(ResultSet rs, int rows) throws SQLException {
		User user = new User();
		user.setId(rs.getBigDecimal("id").toBigInteger());
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setMobile(rs.getString("mobile"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setActive(rs.getBoolean("active"));
		user.setRole(rs.getBigDecimal("role").toBigInteger());

		return user;
	}
}
