/**
 * 
 */
package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.TreatmentQuestionnaireModel;

/**
 * This class represent the mapping between TreatmentQuestionnaireModel model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author kkowlgi
 */
public class TreatmentQuestionnaireModelMapper
		implements RowMapper<TreatmentQuestionnaireModel> {
	/**
	 * This function map the TreatmentQuestionnaireModel model object fields to
	 * a database fields and return the TreatmentQuestionnaireModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public TreatmentQuestionnaireModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		TreatmentQuestionnaireModel treatmentquestioneer = new TreatmentQuestionnaireModel();
		treatmentquestioneer.setId(rs.getBigDecimal("id").toBigInteger());
		treatmentquestioneer.setQuestionnaire(
				rs.getBigDecimal("questionnaire").toBigInteger());
		treatmentquestioneer
				.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		treatmentquestioneer.setName(rs.getString("name"));
		treatmentquestioneer.setType(rs.getString("type"));
		treatmentquestioneer.setValue(rs.getString("value"));
		return treatmentquestioneer;
	}
}
