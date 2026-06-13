/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;

/**
 * This class represent the mapping between
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyTreatmentMethodPractitionerStatMapper
		implements
		RowMapper<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> {
	/**
	 * This function map the
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat model object
	 * fields to a database fields and return the
	 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStat model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return
	 * healthcareproviderspecialtytreatmentmethodpractitionerstat
	 */
	public HealthcareproviderSpecialtyTreatmentMethodPractitionerStat mapRow(
			ResultSet rs, int rows) throws SQLException {
		HealthcareproviderSpecialtyTreatmentMethodPractitionerStat healthcareproviderspecialtytreatmentmethodpractitionerstat = new HealthcareproviderSpecialtyTreatmentMethodPractitionerStat();
		healthcareproviderspecialtytreatmentmethodpractitionerstat
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderspecialtytreatmentmethodpractitionerstat
				.setDescription(rs.getString("description"));
		healthcareproviderspecialtytreatmentmethodpractitionerstat
				.setStat(rs.getBigDecimal("stat").toBigInteger());
		healthcareproviderspecialtytreatmentmethodpractitionerstat
				.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
						.getBigDecimal(
								"healthcareprovider_specialty_treatment_method_practitioner")
						.toBigInteger());

		return healthcareproviderspecialtytreatmentmethodpractitionerstat;
	}
}
