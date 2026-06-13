/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Fromtoflightcost;

/**
 * This class represent the mapping between Fromtoflightcost model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class FromtoflightcostMapper implements RowMapper<Fromtoflightcost> {
	/**
	 * This function map the Fromtoflightcost model object fields to a database
	 * fields and return the Fromtoflightcost model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return insurance
	 */
	public Fromtoflightcost mapRow(ResultSet rs, int rows) throws SQLException {
		Fromtoflightcost model = new Fromtoflightcost();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setFromCity(rs.getBigDecimal("from_city").toBigInteger());
		model.setToCity(rs.getBigDecimal("to_city").toBigInteger());
		model.setAmount(rs.getDouble("amount"));
		model.setCurrency(rs.getString("currency"));
		return model;
	}
}
