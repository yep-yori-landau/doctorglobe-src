package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.db.HealthcareproviderPractitioner;

public class HealthcareproviderPractitionerMapper
		implements RowMapper<HealthcareproviderPractitioner> {

	@Override
	public HealthcareproviderPractitioner mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		HealthcareproviderPractitioner model = new HealthcareproviderPractitioner();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setTitle(rs.getString("title"));
		model.setFirstName(rs.getString("first_name"));
		model.setLastName(rs.getString("last_name"));
		model.setEmail(rs.getString("email"));
		model.setMobile(rs.getString("mobile"));
		model.setDescription(rs.getString("mobile"));
		model.setInsuranceCap(rs.getBigDecimal("insurance_cap"));
		model.setCurrency(rs.getString("currency"));
		model.setPolicyFile(rs.getString("policy_file"));
		model.setPractitioner(rs.getBigDecimal("practitioner").toBigInteger());
		model.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		model.setType(rs.getBigDecimal("type").toBigInteger());
		return model;
	}

}