/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.CorporatecompanyInsurance;

/**
 * This class represent the mapping between CorporatecompanyInsurance model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class CorporatecompanyInsuranceMapper
		implements RowMapper<CorporatecompanyInsurance> {
	/**
	 * This function map the CorporatecompanyInsurance model object fields to a
	 * database fields and return the CorporatecompanyInsurance model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return insurance
	 */
	public CorporatecompanyInsurance mapRow(ResultSet rs, int rows)
			throws SQLException {
		CorporatecompanyInsurance model = new CorporatecompanyInsurance();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setProgramName(rs.getString("program_name"));
		model.setAnnualOop(rs.getDouble("annual_oop"));
		model.setDeductible(rs.getDouble("deductible"));
		model.setCoInsurance(rs.getInt("co_insurance"));
		model.setCorporateCompany(
				rs.getBigDecimal("corporate_company").toBigInteger());
		model.setType(rs.getString("type"));
		model.setHsaCompatible(rs.getBoolean("hsa_compatible"));
		return model;
	}
}
