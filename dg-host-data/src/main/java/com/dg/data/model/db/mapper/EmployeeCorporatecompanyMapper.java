/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.EmployeeCorporatecompany;

/**
 * This class represent the mapping between EmployeeCorporatecompany model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class EmployeeCorporatecompanyMapper
		implements RowMapper<EmployeeCorporatecompany> {
	/**
	 * This function map the EmployeeCorporatecompany model object fields to a
	 * database fields and return the EmployeeCorporatecompany model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return insurance
	 */
	public EmployeeCorporatecompany mapRow(ResultSet rs, int rows)
			throws SQLException {
		EmployeeCorporatecompany model = new EmployeeCorporatecompany();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		if (rs.getBigDecimal("corporatecompany_insurance")
				.toBigInteger() != null) {
			model.setCorporatecompanyInsurance(
					rs.getBigDecimal("corporatecompany_insurance")
							.toBigInteger());
		}
		model.setPatient(rs.getBigDecimal("patient").toBigInteger());
		model.setEmployeeId(rs.getString("employee_id"));
		model.setPolicyId(rs.getString("policy_id"));
		model.setEmail(rs.getString("email"));
		return model;
	}
}
