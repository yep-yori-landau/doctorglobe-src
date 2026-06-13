/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderSpecialty;

/**
 * This class represent the mapping between HealthcareproviderSpecialty model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyMapper
		implements RowMapper<HealthcareproviderSpecialty> {
	/**
	 * This function map the HealthcareproviderSpecialty model object fields to
	 * a database fields and return the HealthcareproviderSpecialty model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderspeciality
	 */
	public HealthcareproviderSpecialty mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderSpecialty healthcareproviderSpecialty = new HealthcareproviderSpecialty();
		try {
			healthcareproviderSpecialty
					.setId(rs.getBigDecimal("id").toBigInteger());
			healthcareproviderSpecialty.setName(rs.getString("name"));
			if (rs.getString("built") != null) {
				healthcareproviderSpecialty.setBuilt(rs.getString("built"));
			}
			if (rs.getString("renovated") != null) {
				healthcareproviderSpecialty
						.setRenovated(rs.getString("renovated"));
			}
			healthcareproviderSpecialty
					.setSpecialty(rs.getBigDecimal("specialty").toBigInteger());
			healthcareproviderSpecialty.setHealthcareprovider(
					rs.getBigDecimal("healthcareprovider").toBigInteger());
			healthcareproviderSpecialty.setActive(rs.getBoolean("active"));

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return healthcareproviderSpecialty;
	}
}
