/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.PatientcasePrice;

/**
 * This class represent the mapping between PatientcasePrice model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcasePriceMapper implements RowMapper<PatientcasePrice> {
	/**
	 * This function map the PatientcasePrice model object fields to a database
	 * fields and return the PatientcasePrice model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return modelPrice
	 */
	public PatientcasePrice mapRow(ResultSet rs, int rows) throws SQLException {
		PatientcasePrice model = new PatientcasePrice();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setListPrice(rs.getDouble("list_price"));
		model.setYoupayListPrice(rs.getDouble("youpay_list_price"));
		model.setBonusListPrice(rs.getDouble("bonus_list_price"));
		model.setQuotePrice(rs.getDouble("quote_price"));
		model.setYoupayQuotePrice(rs.getDouble("youpay_quote_price"));
		model.setBonusQuotePrice(rs.getDouble("bonus_quote_price"));
		model.setBilledPrice(rs.getDouble("billed_price"));
		model.setYoupayBilledPrice(rs.getDouble("youpay_billed_price"));
		model.setBonusBilledPrice(rs.getDouble("bonus_billed_price"));
		model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
				.getBigDecimal(
						"healthcareprovider_specialty_treatment_method_practitioner")
				.toBigInteger());
		model.setPatientCase(rs.getBigDecimal("patient_case").toBigInteger());
		return model;
	}
}
