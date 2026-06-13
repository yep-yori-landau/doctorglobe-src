/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.DailyExpense;

/**
 * This class represent the mapping between DailyExpense model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class DailyExpenseMapper implements RowMapper<DailyExpense> {

	/**
	 * This function map the DailyExpense model object fields to a database
	 * fields and return the DailyExpense model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return insurance
	 */
	public DailyExpense mapRow(ResultSet rs, int rows) throws SQLException {
		DailyExpense model = new DailyExpense();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setCountry(rs.getBigDecimal("country").toBigInteger());
		model.setAmount(rs.getDouble("amount"));
		model.setCurrency(rs.getString("currency"));
		return model;
	}
}
