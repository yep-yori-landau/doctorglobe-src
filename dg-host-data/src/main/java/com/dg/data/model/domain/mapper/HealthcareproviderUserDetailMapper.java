package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.HealthcareproviderUserDetailModel;

/**
 * This class represent the mapping between HealthcareproviderUserDetailMapper
 * model object fields to a database fields and back when the spring JDBC
 * generic DAO call it
 * 
 * @author kkowlgi
 */
public class HealthcareproviderUserDetailMapper
		implements RowMapper<HealthcareproviderUserDetailModel> {

	/**
	 * This function map the HealthcareproviderUserDetailModel model object
	 * fields to a database fields and return the
	 * HealthcareproviderUserDetailModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	@Override
	public HealthcareproviderUserDetailModel mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		HealthcareproviderUserDetailModel model = new HealthcareproviderUserDetailModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setFirstName(rs.getString("first_name"));
		model.setLastName(rs.getString("last_name"));
		model.setEmail(rs.getString("email"));
		model.setPassword(rs.getString("password"));
		model.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		return model;
	}

}