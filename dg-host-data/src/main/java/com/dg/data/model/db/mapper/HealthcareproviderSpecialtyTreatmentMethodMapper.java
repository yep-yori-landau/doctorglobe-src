/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;

/**
 * This class represent the mapping between
 * HealthcareproviderSpecialtyTreatmentMethod model object fields to a database
 * fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyTreatmentMethodMapper
		implements RowMapper<HealthcareproviderSpecialtyTreatmentMethod> {
	/**
	 * This function map the HealthcareproviderSpecialtyTreatmentMethod model
	 * object fields to a database fields and return the
	 * HealthcareproviderSpecialtyTreatmentMethod model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderspecialitytreatmentmethod
	 */
	public HealthcareproviderSpecialtyTreatmentMethod mapRow(ResultSet rs,
			int rows) throws SQLException {
		HealthcareproviderSpecialtyTreatmentMethod healthcareproviderspecialtytreatmentmethod = new HealthcareproviderSpecialtyTreatmentMethod();
		healthcareproviderspecialtytreatmentmethod
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderspecialtytreatmentmethod
				.setActive(rs.getBoolean("active"));
		healthcareproviderspecialtytreatmentmethod
				.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		healthcareproviderspecialtytreatmentmethod
				.setMethod(rs.getBigDecimal("method").toBigInteger());
		healthcareproviderspecialtytreatmentmethod
				.setHealthcareproviderSpecialty(
						rs.getBigDecimal("healthcareprovider_specialty")
								.toBigInteger());
		healthcareproviderspecialtytreatmentmethod.setHealthcareproviderPrice(
				rs.getDouble("healthcareprovider_price"));
		return healthcareproviderspecialtytreatmentmethod;
	}
}
