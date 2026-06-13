package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.EmployeeCorporatecompanyDetail;

/**
 * This class represent the mapping between EmployeeCorporatecompanyDetail model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author kkowlgi
 */
public class EmployeeCorporatecompanyDetailMapper
		implements RowMapper<EmployeeCorporatecompanyDetail> {
	/**
	 * This function map the EmployeeCorporatecompanyDetail model object fields
	 * to a database fields and return the EmployeeCorporatecompanyDetail model
	 * object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public EmployeeCorporatecompanyDetail mapRow(ResultSet rs, int rows)
			throws SQLException {
		EmployeeCorporatecompanyDetail model = new EmployeeCorporatecompanyDetail();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setYtdOop(rs.getDouble("ytd_oop"));
		model.setWorkerIncentive(rs.getInt("worker_incentive"));
		if (rs.getBigDecimal("corporatecompany_insurance")
				.toBigInteger() != null) {
			model.setCorporatecompanyInsurance(
					rs.getBigDecimal("corporatecompany_insurance")
							.toBigInteger());
		}
		model.setPatient(rs.getBigDecimal("patient").toBigInteger());
		model.setProgramName(rs.getString("program_name"));
		model.setCorporatecompanyAnnualOop(
				rs.getDouble("corporatecompany_annual_oop"));
		model.setCorporatecompanyDeductible(
				rs.getDouble("corporatecompany_deductible"));
		model.setCorporatecompanyCoInsurance(
				rs.getInt("corporatecompany_co_insurance"));
		model.setMinimumAmountSpread(rs.getDouble("minimum_amount_spread"));
		model.setMinimumPercentageSpread(
				rs.getDouble("minimum_percentage_spread"));
		model.setCurrency(rs.getString("currency"));
		model.setDgCommission(rs.getInt("dg_commission"));
		model.setCorporateCompany(
				rs.getBigDecimal("corporate_company").toBigInteger());
		model.setCity(rs.getBigDecimal("city").toBigInteger());
		model.setCountry(rs.getBigDecimal("country").toBigInteger());
		model.setCityLat(rs.getDouble("city_lat"));
		model.setCityLon(rs.getDouble("city_lon"));
		model.setEmail(rs.getString("email"));
		return model;
	}
}