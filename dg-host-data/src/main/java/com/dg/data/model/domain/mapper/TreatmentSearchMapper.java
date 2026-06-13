package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.TreatmentSearchModel;

/**
 * This class represent the mapping between TreatmentSearchMapper model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class TreatmentSearchMapper implements RowMapper<TreatmentSearchModel> {

	/**
	 * This function map the TreatmentSearchMapper model object fields to a
	 * database fields and return the TreatmentSearchMapper model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public TreatmentSearchModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		TreatmentSearchModel model = new TreatmentSearchModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setName(rs.getString("name"));
		model.setAliasName(rs.getString("alias_name"));
		return model;
	}
}