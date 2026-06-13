package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.HealthcareproviderPractitionerModel;

/**
 * This class represent the mapping between HealthcareproviderPractitionerModel
 * model object fields to a database fields and back when the spring JDBC
 * generic DAO call it
 * 
 * @author kkowlgi
 */
public class HealthcareproviderPractitionerMapper
		implements RowMapper<HealthcareproviderPractitionerModel> {

	/**
	 * This function map the HealthcareproviderPractitionerModel model object
	 * fields to a database fields and return the
	 * HealthcareproviderPractitionerModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	@Override
	public HealthcareproviderPractitionerModel mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		HealthcareproviderPractitionerModel model = new HealthcareproviderPractitionerModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setTitle(rs.getString("title"));
		model.setName(rs.getString("name"));
		model.setDegree(rs.getString("degree"));
		model.setEmail(rs.getString("email"));
		model.setSpecialtyId(rs.getBigDecimal("specialty_id").toBigInteger());
		model.setSpecialtyName(rs.getString("specialty_name"));
		model.setTreatmentId(rs.getBigDecimal("treatment_id").toBigInteger());
		model.setTreatmentName(rs.getString("treatment_name"));
		model.setMethodId(rs.getBigDecimal("method_id").toBigInteger());
		model.setMethodName(rs.getString("method_name"));
		model.setHstmp(rs.getBigDecimal("hstmp").toBigInteger());
		model.setHstm(rs.getBigDecimal("hstm").toBigInteger());
		model.setActive(rs.getBoolean("active"));
		return model;
	}

}