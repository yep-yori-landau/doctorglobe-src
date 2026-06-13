/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderSpecialtyPractitioner;

/**
 * This class represent the mapping between
 * HealthcareproviderSpecialtyPractitioner model object fields to a database
 * fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyPractitionerMapper
		implements RowMapper<HealthcareproviderSpecialtyPractitioner> {
	/**
	 * This function map the HealthcareproviderSpecialtyPractitioner model
	 * object fields to a database fields and return the
	 * HealthcareproviderSpecialtyPractitioner model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderspecialtypractitioner
	 */
	public HealthcareproviderSpecialtyPractitioner mapRow(ResultSet rs,
			int rows) throws SQLException {
		HealthcareproviderSpecialtyPractitioner healthcareproviderspecialtypractitioner = new HealthcareproviderSpecialtyPractitioner();
		healthcareproviderspecialtypractitioner
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderspecialtypractitioner
				.setPractitionerEmail(rs.getString("practitioner_email"));
		healthcareproviderspecialtypractitioner
				.setActive(rs.getBoolean("active"));
		healthcareproviderspecialtypractitioner.setHealthcareproviderSpecialty(
				rs.getBigDecimal("healthcareprovider_specialty")
						.toBigInteger());

		return healthcareproviderspecialtypractitioner;
	}
}
