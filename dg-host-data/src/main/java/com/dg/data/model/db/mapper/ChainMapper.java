/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Chain;

/**
 * This class represent the mapping between Chain model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class ChainMapper implements RowMapper<Chain> {
	/**
	 * This function map the Chain model object fields to a database fields and
	 * return the Chain model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return chain
	 */
	public Chain mapRow(ResultSet rs, int rows) throws SQLException {
		Chain chain = new Chain();
		chain.setId(rs.getBigDecimal("id").toBigInteger());
		chain.setName(rs.getString("name"));

		return chain;
	}
}
