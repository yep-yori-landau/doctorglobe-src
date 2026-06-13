/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.State;

/**
 * This class represent the mapping between State model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class StateMapper implements RowMapper<State> {
	/**
	 * This function map the State model object fields to a database fields and
	 * return the State model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return state
	 */
	public State mapRow(ResultSet rs, int rows) throws SQLException {
		State state = new State();
		state.setId(rs.getBigDecimal("id").toBigInteger());
		state.setCode(rs.getString("code"));
		state.setName(rs.getString("name"));
		state.setCountry(rs.getBigDecimal("country").toBigInteger());

		return state;
	}
}
