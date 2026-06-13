/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Stats;

/**
 * This class represent the mapping between Stats model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class StatsMapper implements RowMapper<Stats> {
	/**
	 * This function map the Stats model object fields to a database fields and
	 * return the Stats model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return stats
	 */
	public Stats mapRow(ResultSet rs, int rows) throws SQLException {
		Stats stats = new Stats();
		stats.setId(rs.getBigDecimal("id").toBigInteger());
		stats.setName(rs.getString("name"));
		stats.setDescription(rs.getString("description"));

		return stats;
	}
}
