/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Country;

/**
 * This class represent the mapping between Country model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class CountryMapper implements RowMapper<Country> {
	/**
	 * This function map the Country model object fields to a database fields
	 * and return the Country model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return country
	 */
	public Country mapRow(ResultSet rs, int rows) throws SQLException {
		Country country = new Country();
		country.setId(rs.getBigDecimal("id").toBigInteger());
		country.setCode(rs.getString("code"));
		country.setName(rs.getString("name"));
		country.setRegion(rs.getBigDecimal("region").toBigInteger());

		return country;
	}
}
