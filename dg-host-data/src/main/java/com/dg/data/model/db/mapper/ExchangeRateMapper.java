/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.ExchangeRate;

/**
 * This class represent the mapping between ExchangeRate model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class ExchangeRateMapper implements RowMapper<ExchangeRate> {
	/**
	 * This function map the ExchangeRate model object fields to a database
	 * fields and return the ExchangeRate model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return exchangerate
	 */
	public ExchangeRate mapRow(ResultSet rs, int rows) throws SQLException {
		ExchangeRate exchangerate = new ExchangeRate();
		exchangerate.setId(rs.getBigDecimal("id").toBigInteger());
		exchangerate.setFromCur(rs.getString("from_cur"));
		exchangerate.setToCur(rs.getString("to_cur"));
		exchangerate.setRate(rs.getDouble("rate"));

		return exchangerate;
	}
}
