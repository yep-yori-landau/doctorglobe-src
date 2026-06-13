/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.PatientcaseTreatmentQuestionnaire;

/**
 * This class represent the mapping between PatientcaseTreatmentQuestionnaire
 * model object fields to a database fields and back when the spring JDBC
 * generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PatientcaseTreatmentQuestionnaireMapper
		implements RowMapper<PatientcaseTreatmentQuestionnaire> {
	/**
	 * This function map the PatientcaseTreatmentQuestionnaire model object
	 * fields to a database fields and return the
	 * PatientcaseTreatmentQuestionnaire model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public PatientcaseTreatmentQuestionnaire mapRow(ResultSet rs, int rows)
			throws SQLException {
		PatientcaseTreatmentQuestionnaire model = new PatientcaseTreatmentQuestionnaire();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setTreatmentQuestionnaire(
				rs.getBigDecimal("treatment_questionnaire").toBigInteger());
		model.setPatientcase(rs.getBigDecimal("patientcase").toBigInteger());
		model.setValue(rs.getString("value"));
		return model;
	}
}
