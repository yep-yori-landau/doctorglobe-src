/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.TreatmentQuestionnaire;

/**
 * This class represent the mapping between TreatmentQuestionnaire model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class TreatmentQuestionnaireMapper
		implements RowMapper<TreatmentQuestionnaire> {
	/**
	 * This function map the TreatmentQuestionnaire model object fields to a
	 * database fields and return the TreatmentQuestionnaire model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public TreatmentQuestionnaire mapRow(ResultSet rs, int rows)
			throws SQLException {
		TreatmentQuestionnaire treatmentQuestionnaire = new TreatmentQuestionnaire();
		treatmentQuestionnaire.setId(rs.getBigDecimal("id").toBigInteger());
		treatmentQuestionnaire.setQuestionnaire(
				rs.getBigDecimal("Questionnaire").toBigInteger());
		treatmentQuestionnaire
				.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		return treatmentQuestionnaire;
	}
}
