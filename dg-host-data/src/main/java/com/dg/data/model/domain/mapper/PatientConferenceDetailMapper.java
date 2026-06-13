package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dg.data.model.domain.PatientConferenceDetailModel;

/**
 * This class represent the mapping between PatientConferenceDetailModel model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author kkowlgi
 */
public class PatientConferenceDetailMapper
		implements RowMapper<PatientConferenceDetailModel> {
	/**
	 * This function map the PatientConferenceDetailModel model object fields to
	 * a database fields and return the PatientConferenceDetailModel model
	 * object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public PatientConferenceDetailModel mapRow(ResultSet rs, int rows)
			throws SQLException {
		PatientConferenceDetailModel model = new PatientConferenceDetailModel();
		model.setId(rs.getBigDecimal("id").toBigInteger());
		model.setConferenceDt(rs.getTimestamp("conference_dt"));
		model.setStatus(rs.getString("status"));
		model.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		model.setHealthcareproviderName(
				rs.getString("healthcareprovider_name"));
		model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
				.getBigDecimal(
						"healthcareprovider_specialty_treatment_method_practitioner")
				.toBigInteger());
		model.setHealthcareproviderSpecialtyTreatmentMethod(rs
				.getBigDecimal("healthcareprovider_specialty_treatment_method")
				.toBigInteger());
		model.setPatientCase(rs.getBigDecimal("patient_case").toBigInteger());
		model.setPractitioner(rs.getBigDecimal("practitioner").toBigInteger());
		model.setPractitionerName(rs.getString("practitioner_name"));
		model.setPractitionerEmail(rs.getString("practitioner_email"));
		if (rs.getString("practitioner_photo") != null) {
			model.setPractitionerPhoto(rs.getString("practitioner_photo"));
		}
		if (rs.getString("sender_type") != null) {
			model.setSenderType(rs.getString("sender_type"));
		}
		model.setSubject(rs.getString("subject"));
		if (rs.getString("message") != null) {
			model.setMessage(rs.getString("message")
					.replaceAll(System.getProperty("line.separator"), "<br/>"));
		}
		if (rs.getString("sent_dt") != null) {
			model.setSentDt(rs.getTimestamp("sent_dt"));
		}

		model.setSender(rs.getInt("sender"));
		model.setReceiver(rs.getInt("receiver"));

		if (rs.getString("message_id") != null) {
			model.setMessageId(rs.getBigDecimal("message_id").toBigInteger());
		}
		if (rs.getString("booking_id") != null) {
			model.setBookingId(rs.getBigDecimal("booking_id").toBigInteger());
		}
		if (rs.getString("booking_dt") != null) {
			model.setBookingDt(rs.getTimestamp("booking_dt"));
		}
		model.setBookingStatus(rs.getString("booking_status"));
		model.setConferenceTimezone(rs.getString("conference_timezone"));
		model.setBookingTimezone(rs.getString("booking_timezone"));
		return model;
	}
}