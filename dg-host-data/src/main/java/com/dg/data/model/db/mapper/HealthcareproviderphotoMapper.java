/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Healthcareproviderphoto;

/**
 * This class represent the mapping between Healthcareproviderphoto model object
 * fields to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderphotoMapper
		implements RowMapper<Healthcareproviderphoto> {
	/**
	 * This function map the Healthcareproviderphoto model object fields to a
	 * database fields and return the Healthcareproviderphoto model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderphoto
	 */
	public Healthcareproviderphoto mapRow(ResultSet rs, int rows)
			throws SQLException {
		Healthcareproviderphoto healthcareproviderphoto = new Healthcareproviderphoto();
		healthcareproviderphoto.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderphoto.setPath(rs.getString("path"));
		healthcareproviderphoto.setType(rs.getString("type"));
		healthcareproviderphoto.setDescription(rs.getString("description"));
		healthcareproviderphoto.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		healthcareproviderphoto.setIsPrimary(rs.getInt("is_primary"));
		healthcareproviderphoto.setName(rs.getString("name"));
		return healthcareproviderphoto;
	}
}
