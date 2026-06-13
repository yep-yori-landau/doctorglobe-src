/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;

/**
 * This class represent the mapping between
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper
		implements
		RowMapper<HealthcareproviderSpecialtyTreatmentMethodPractitioner> {
	/**
	 * This function map the
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner model object
	 * fields to a database fields and return the
	 * HealthcareproviderSpecialtyTreatmentMethodPractitioner model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return
	 * healthcareproviderSpecialtyTreatmentMethodPractitioner
	 */
	public HealthcareproviderSpecialtyTreatmentMethodPractitioner mapRow(
			ResultSet rs, int rows) throws SQLException {
		HealthcareproviderSpecialtyTreatmentMethodPractitioner healthcareproviderSpecialtyTreatmentMethodPractitioner = new HealthcareproviderSpecialtyTreatmentMethodPractitioner();
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setYearsPracticed(rs.getInt("years_practiced"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setNumberPerformedOverall(
						rs.getInt("number_performed_overall"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setNumberPerformedLastYear(
						rs.getInt("number_performed_last_year"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setCorrectionsLastYear(rs.getInt("corrections_last_year"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setAvailabilityDays(rs.getInt("availability_days"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setCurrency(rs.getString("currency"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setHealthcareproviderPrice(
						rs.getDouble("healthcareprovider_price"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setPractitionerPrice(rs.getDouble("practitioner_price"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setAnesthesiaPrice(rs.getDouble("anesthesia_price"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setActive(rs.getBoolean("active"));
		healthcareproviderSpecialtyTreatmentMethodPractitioner.setPractitioner(
				rs.getBigDecimal("practitioner").toBigInteger());
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setHealthcareproviderSpecialtyTreatmentMethod(rs
						.getBigDecimal(
								"healthcareprovider_specialty_treatment_method")
						.toBigInteger());
		if (rs.getBigDecimal("corporatecompany_insurance") != null) {
			healthcareproviderSpecialtyTreatmentMethodPractitioner
					.setCorporatecompanyInsurance(
							rs.getBigDecimal("corporatecompany_insurance")
									.toBigInteger());
		}
		healthcareproviderSpecialtyTreatmentMethodPractitioner
				.setVerified(rs.getBoolean("verified"));
		return healthcareproviderSpecialtyTreatmentMethodPractitioner;
	}
}
