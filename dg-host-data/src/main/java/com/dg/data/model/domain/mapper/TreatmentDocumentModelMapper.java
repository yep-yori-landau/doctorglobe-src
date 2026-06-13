package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.TreatmentDocumentModel;

/**
 * This class represent the mapping between TreatmentDocumentModel model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class TreatmentDocumentModelMapper
		implements RowMapper<TreatmentDocumentModel> {

	/**
	 * This function map the TreatmentDocumentModel model object fields to a
	 * database fields and return the TreatmentDocumentModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public TreatmentDocumentModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		TreatmentDocumentModel model = new TreatmentDocumentModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		model.setDocument(rs.getBigDecimal("document").toBigInteger());
		model.setName(rs.getString("name"));
		return model;
	}
}