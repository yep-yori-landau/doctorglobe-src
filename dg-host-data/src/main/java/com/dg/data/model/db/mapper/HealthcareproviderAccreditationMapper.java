/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderAccreditation;

/**
 * This class represent the mapping between HealthcareproviderAccreditation
 * model object fields to a database fields and back when the spring JDBC
 * generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderAccreditationMapper
		implements RowMapper<HealthcareproviderAccreditation> {
	/**
	 * This function map the HealthcareproviderAccreditation model object fields
	 * to a database fields and return the HealthcareproviderAccreditation model
	 * object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareprovideraccreditation
	 */
	public HealthcareproviderAccreditation mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderAccreditation healthcareprovideraccreditation = new HealthcareproviderAccreditation();
		healthcareprovideraccreditation
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareprovideraccreditation
				.setAccreditationDt(rs.getString("accreditation_dt"));
		healthcareprovideraccreditation.setAccreditation(
				rs.getBigDecimal("accreditation").toBigInteger());
		healthcareprovideraccreditation.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());

		return healthcareprovideraccreditation;
	}
}
