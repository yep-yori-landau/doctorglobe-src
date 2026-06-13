/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.TreatmentDocument;

/**
 * This class represent the mapping between TreatmentDocument model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TreatmentDocumentMapper implements RowMapper<TreatmentDocument> {
	/**
	 * This function map the TreatmentDocument model object fields to a database
	 * fields and return the TreatmentDocument model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return specialitytreatment
	 */
	public TreatmentDocument mapRow(ResultSet rs, int rows)
			throws SQLException {
		TreatmentDocument model = new TreatmentDocument();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		model.setDocument(rs.getBigDecimal("document").toBigInteger());
		return model;
	}
}
