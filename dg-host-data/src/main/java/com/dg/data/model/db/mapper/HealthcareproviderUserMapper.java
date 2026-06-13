/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderUser;

/**
 * This class represent the mapping between HealthcareproviderUser model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderUserMapper
		implements RowMapper<HealthcareproviderUser> {
	/**
	 * This function map the HealthcareproviderUser model object fields to a
	 * database fields and return the HealthcareproviderUser model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareprovideruser
	 */
	public HealthcareproviderUser mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderUser healthcareprovideruser = new HealthcareproviderUser();
		healthcareprovideruser.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareprovideruser.setUser(rs.getBigDecimal("user").toBigInteger());
		healthcareprovideruser.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareprovideruser;
	}
}
