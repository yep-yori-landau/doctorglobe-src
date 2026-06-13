package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.CorporatecompanyPatientModel;

/**
 * This class represent the mapping between CorporatecompanyPatientModel model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author kkowlgi
 */
public class CorporatecompanyPatientMapper
		implements RowMapper<CorporatecompanyPatientModel> {

	/**
	 * This function map the CorporatecompanyPatientModel model object fields to
	 * a database fields and return the CorporatecompanyPatientModel model
	 * object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public CorporatecompanyPatientModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		CorporatecompanyPatientModel model = new CorporatecompanyPatientModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setCcName(rs.getString("cc_name"));
		if (rs.getBigDecimal("patient_id") != null) {
			model.setPatientId(rs.getBigDecimal("patient_id").toBigInteger());
		}
		model.setFirstName(rs.getString("first_name"));
		model.setLastName(rs.getString("last_name"));
		model.setEmail(rs.getString("email"));
		model.setCountry(rs.getString("country"));
		model.setCity(rs.getString("city"));
		model.setState(rs.getString("state"));
		model.setEmployeeId(rs.getString("employee_id"));
		return model;
	}
}