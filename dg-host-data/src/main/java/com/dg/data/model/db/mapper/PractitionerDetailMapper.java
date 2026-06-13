/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.PractitionerDetail;

/**
 * This class represent the mapping between PractitionerDetail model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PractitionerDetailMapper implements RowMapper<PractitionerDetail> {
	/**
	 * This function map the PractitionerDetail model object fields to a
	 * database fields and return the PractitionerDetail model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return patientcaseaudit
	 */
	public PractitionerDetail mapRow(ResultSet rs, int rows)
			throws SQLException {
		PractitionerDetail practitionerDetail = new PractitionerDetail();
		practitionerDetail.setId(rs.getInt("id"));
		practitionerDetail.setTitle(rs.getString("title"));
		practitionerDetail.setName(rs.getString("name"));
		practitionerDetail.setGender(rs.getString("gender"));
		practitionerDetail.setDescription(rs.getString("description"));
		practitionerDetail.setRating(rs.getString("rating"));
		practitionerDetail.setMethod(rs.getString("method"));
		practitionerDetail.setFstmp(rs.getInt("fstmp"));

		return practitionerDetail;
	}
}
