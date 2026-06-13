package com.dg.data.model.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.domain.PatientDetailModel;

/**
 * This class represent the mapping between PatientDetailModel model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author kkowlgi
 */

public class PatientDetailMapper implements RowMapper<PatientDetailModel> {

	/**
	 * This function map the PatientDetailModel model object fields to a
	 * database fields and return the PatientDetailModel model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields
	 */
	public PatientDetailModel mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		PatientDetailModel model = new PatientDetailModel();
		try {
			model.setId(rs.getBigDecimal("id").toBigInteger());
			model.setName(rs.getString("name"));
			model.setAge(rs.getString("age"));
			model.setEmail(rs.getString("email"));
			model.setGender(rs.getString("gender"));
			model.setPhone(rs.getString("phone"));
			model.setAddress(rs.getString("address"));
			model.setZipCode(rs.getString("zip_code"));
			if (rs.getString("photo") != null) {
				model.setPhoto(rs.getString("photo"));
			}
			model.setCity(rs.getString("city"));
			model.setCountry(rs.getString("country"));
			model.setCountryCode(rs.getString("country_code"));
			if (rs.getString("patientcase_id") != null) {
				model.setPatientcaseId(
						rs.getBigDecimal("patientcase_id").toBigInteger());
			}
			model.setDescription(rs.getString("description"));
			model.setStatus(rs.getString("status"));
			model.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
			if (rs.getString("patientcasefile_id") != null) {
				model.setPatientcasefileId(
						rs.getBigDecimal("patientcasefile_id").toBigInteger());
			}
			model.setFileDescription(rs.getString("file_description"));
			model.setFileType(rs.getString("file_type"));
			model.setFileName(rs.getString("file_name"));
			if (rs.getString("file_dt") != null) {
				model.setFileDt(rs.getTimestamp("file_dt"));
			}
			model.setDocName(rs.getString("doc_name"));
			model.setPatientconferenceId(
					rs.getBigDecimal("patientconference_id").toBigInteger());
			if (rs.getString("conference_dt") != null) {
				model.setConferenceDt(rs.getTimestamp("conference_dt"));
			}
			model.setPatientconferenceStatus(
					rs.getString("patientconference_status"));
			model.setHealthcareproviderSpecialtyTreatmentMethodPractitioner(rs
					.getBigDecimal(
							"healthcareprovider_specialty_treatment_method_practitioner")
					.toBigInteger());
			model.setWeekCall(rs.getInt("week_call"));
			model.setTreatmentName(rs.getString("treatment_name"));
			if (rs.getString("pcm_id") != null) {
				model.setPcmId(rs.getBigDecimal("pcm_id").toBigInteger());
			}
			model.setSender(rs.getInt("sender"));
			model.setReceiver(rs.getInt("receiver"));
			model.setPcmStatus(rs.getString("pcm_status"));
			model.setSubject(rs.getString("subject"));
			if (rs.getString("message") != null) {
				model.setMessage(rs.getString("message").replaceAll(
						System.getProperty("line.separator"), "<br/>"));
			}
			model.setSenderType(rs.getString("sender_type"));
			if (rs.getString("sent_dt") != null) {
				model.setSentDt(rs.getTimestamp("sent_dt"));
			}
			if (rs.getString("booking_id") != null) {
				model.setBookingId(
						rs.getBigDecimal("booking_id").toBigInteger());
			}
			if (rs.getString("booking_dt") != null) {
				model.setBookingDt(rs.getTimestamp("booking_dt"));
			}
			model.setBookingStatus(rs.getString("booking_status"));
			model.setPractitioner(
					rs.getBigDecimal("practitioner").toBigInteger());
			model.setConferenceTimezone(rs.getString("conference_timezone"));
			model.setBookingTimezone(rs.getString("booking_timezone"));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return model;
	}

}