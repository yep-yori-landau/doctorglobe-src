/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Practitionertype;

/**
 * This class represent the mapping between Practitionertype model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class PractitionertypeMapper implements RowMapper<Practitionertype> {
	/**
	 * This function map the Practitionertype model object fields to a database
	 * fields and return the Practitionertype model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return practitionertype
	 */
	public Practitionertype mapRow(ResultSet rs, int rows) throws SQLException {
		Practitionertype practitionertype = new Practitionertype();
		practitionertype.setId(rs.getBigDecimal("id").toBigInteger());
		practitionertype.setName(rs.getString("name"));

		return practitionertype;
	}
}
