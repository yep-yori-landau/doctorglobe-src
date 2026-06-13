/**
 * 
 */
package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.HospitalPractitionerModel;

/**
 * This class represent the mapping between HealthcareproviderUserDetailMapper
 * model object fields to a database fields and back when the spring JDBC
 * generic DAO call it
 * 
 * @author kkowlgi
 */
public class HospitalPractitionerMapper
		implements RowMapper<HospitalPractitionerModel> {
	/**
	 * This function map the HospitalPractitionerModel model object fields to a
	 * database fields and return the HospitalPractitionerModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public HospitalPractitionerModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		HospitalPractitionerModel model = new HospitalPractitionerModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setPractitioner(rs.getBigDecimal("practitioner").toBigInteger());
		model.setPractitionerName(rs.getString("practitioner_name"));
		return model;
	}
}
