/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderInsurance;

/**
 * This class represent the mapping between HealthcareproviderInsurance model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderInsuranceMapper
		implements RowMapper<HealthcareproviderInsurance> {
	/**
	 * This function map the HealthcareproviderInsurance model object fields to
	 * a database fields and return the HealthcareproviderInsurance model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderinsurance
	 */
	public HealthcareproviderInsurance mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderInsurance healthcareproviderinsurance = new HealthcareproviderInsurance();
		healthcareproviderinsurance
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderinsurance
				.setInsurance(rs.getBigDecimal("insurance").toBigInteger());
		healthcareproviderinsurance.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareproviderinsurance;
	}
}
