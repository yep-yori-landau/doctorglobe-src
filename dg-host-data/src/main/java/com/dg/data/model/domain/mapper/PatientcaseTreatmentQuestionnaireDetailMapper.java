/**
 * 
 */
package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.PatientcaseTreatmentQuestionnaireDetailModel;

/**
 * This class represent the mapping between
 * PatientcaseTreatmentQuestionnaireDetailModel model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */
public class PatientcaseTreatmentQuestionnaireDetailMapper
		implements RowMapper<PatientcaseTreatmentQuestionnaireDetailModel> {
	/**
	 * This function map the PatientcaseTreatmentQuestionnaireDetailModel model
	 * object fields to a database fields and return the
	 * PatientcaseTreatmentQuestionnaireDetailModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public PatientcaseTreatmentQuestionnaireDetailModel mapRow(ResultSet rs,
			int rows) throws SQLException {
		PatientcaseTreatmentQuestionnaireDetailModel model = new PatientcaseTreatmentQuestionnaireDetailModel();
		model.setName(rs.getString("name"));
		model.setValue(rs.getString("value"));
		return model;
	}
}
