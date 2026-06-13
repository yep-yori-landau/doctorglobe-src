/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.TreatmentPrice;

/**
 * This class represent the mapping between TreatmentPrice model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TreatmentPriceMapper implements RowMapper<TreatmentPrice> {
	/**
	 * This function map the TreatmentPrice model object fields to a database
	 * fields and return the TreatmentPrice model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public TreatmentPrice mapRow(ResultSet rs, int rows) throws SQLException {
		TreatmentPrice treatmentPrice = new TreatmentPrice();
		treatmentPrice.setId(rs.getBigDecimal("id").toBigInteger());
		treatmentPrice.setPrice(rs.getDouble("price"));
		treatmentPrice.setCurrency(rs.getString("currency"));
		treatmentPrice.setCity(rs.getBigDecimal("city").toBigInteger());
		treatmentPrice
				.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		return treatmentPrice;
	}
}
