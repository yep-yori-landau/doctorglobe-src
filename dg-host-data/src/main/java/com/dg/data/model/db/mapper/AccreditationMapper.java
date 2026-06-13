/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Accreditation;

/**
 * This class represent the mapping between Accreditation model object fields to
 * a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AccreditationMapper implements RowMapper<Accreditation> {
	/**
	 * This function map the Accreditation model object fields to a database
	 * fields and return the Accreditation model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return accreditation
	 */
	public Accreditation mapRow(ResultSet rs, int rows) throws SQLException {
		Accreditation accreditation = new Accreditation();
		accreditation.setId(rs.getBigDecimal("id").toBigInteger());
		accreditation.setName(rs.getString("name"));

		return accreditation;
	}
}
