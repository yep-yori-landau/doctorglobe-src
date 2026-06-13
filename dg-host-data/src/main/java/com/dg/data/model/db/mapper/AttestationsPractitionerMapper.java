/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.AttestationsPractitioner;

/**
 * This class represent the mapping between AttestationsPractitioner model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class AttestationsPractitionerMapper
		implements RowMapper<AttestationsPractitioner> {
	/**
	 * This function map the AttestationsPractitioner model object fields to a
	 * database fields and return the AttestationsPractitioner model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return attestationspractitioner
	 */
	public AttestationsPractitioner mapRow(ResultSet rs, int rows)
			throws SQLException {
		AttestationsPractitioner attestationspractitioner = new AttestationsPractitioner();
		attestationspractitioner.setId(rs.getBigDecimal("id").toBigInteger());
		attestationspractitioner.setValue(rs.getBoolean("value"));
		attestationspractitioner
				.setAttestation(rs.getBigDecimal("attestation").toBigInteger());
		attestationspractitioner.setPractitioner(
				rs.getBigDecimal("practitioner").toBigInteger());

		return attestationspractitioner;
	}
}
