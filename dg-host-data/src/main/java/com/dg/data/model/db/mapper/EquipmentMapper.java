/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Equipment;

/**
 * This class represent the mapping between Equipment model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class EquipmentMapper implements RowMapper<Equipment> {
	/**
	 * This function map the Equipment model object fields to a database fields
	 * and return the Equipment model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return equipment
	 */
	public Equipment mapRow(ResultSet rs, int rows) throws SQLException {
		Equipment equipment = new Equipment();
		equipment.setId(rs.getBigDecimal("id").toBigInteger());
		equipment.setName(rs.getString("name"));
		equipment.setRating(rs.getInt("rating"));
		equipment.setIsDisplay(rs.getInt("is_display"));
		return equipment;
	}
}
