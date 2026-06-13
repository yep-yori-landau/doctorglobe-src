/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.HealthcareproviderEquipment;

/**
 * This class represent the mapping between HealthcareproviderEquipment model
 * object fields to a database fields and back when the spring JDBC generic DAO
 * call it
 * 
 * @author DoctorGlobe
 */

public class HealthcareproviderEquipmentMapper
		implements RowMapper<HealthcareproviderEquipment> {
	/**
	 * This function map the HealthcareproviderEquipment model object fields to
	 * a database fields and return the HealthcareproviderEquipment model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareproviderequipment
	 */
	public HealthcareproviderEquipment mapRow(ResultSet rs, int rows)
			throws SQLException {
		HealthcareproviderEquipment healthcareproviderequipment = new HealthcareproviderEquipment();
		healthcareproviderequipment
				.setId(rs.getBigDecimal("id").toBigInteger());
		healthcareproviderequipment.setPurchaseDt(rs.getString("purchase_dt"));
		healthcareproviderequipment.setHoursUsed(rs.getInt("hours_used"));
		healthcareproviderequipment.setHealthcareprovider(
				rs.getBigDecimal("healthcareprovider").toBigInteger());
		healthcareproviderequipment
				.setEquipment(rs.getBigDecimal("equipment").toBigInteger());
		healthcareproviderequipment.setBrand(rs.getString("brand"));
		healthcareproviderequipment.setVersion(rs.getString("version"));

		return healthcareproviderequipment;
	}
}
