/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.SpecialtyTreatment;

/**
 * This class represent the mapping between SpecialtyTreatment model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class SpecialtyTreatmentMapper implements RowMapper<SpecialtyTreatment> {
	/**
	 * This function map the SpecialtyTreatment model object fields to a
	 * database fields and return the SpecialtyTreatment model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return specialitytreatment
	 */
	public SpecialtyTreatment mapRow(ResultSet rs, int rows)
			throws SQLException {
		SpecialtyTreatment specialtytreatment = new SpecialtyTreatment();
		specialtytreatment.setId(rs.getBigDecimal("id").toBigInteger());
		specialtytreatment
				.setTreatment(rs.getBigDecimal("treatment").toBigInteger());
		specialtytreatment
				.setSpecialty(rs.getBigDecimal("specialty").toBigInteger());

		return specialtytreatment;
	}
}
