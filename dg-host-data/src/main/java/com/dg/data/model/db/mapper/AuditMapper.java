/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Audit;

/**
 * This class represent the mapping between Audit model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class AuditMapper implements RowMapper<Audit> {
	/**
	 * This function map the Audit model object fields to a database fields and
	 * return the Audit model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return audit
	 */
	public Audit mapRow(ResultSet rs, int rows) throws SQLException {
		Audit audit = new Audit();
		audit.setId(rs.getBigDecimal("id").toBigInteger());
		audit.setIpAddress(rs.getString("ip_address"));
		audit.setChangeTable(rs.getString("change_table"));
		audit.setChangeId(rs.getInt("change_id"));
		audit.setChangeField(rs.getString("change_field"));
		audit.setChangeFrom(rs.getString("change_from"));
		audit.setChangeTo(rs.getString("change_to"));
		audit.setChangeDt(rs.getString("change_dt"));
		audit.setUser(rs.getBigDecimal("user").toBigInteger());

		return audit;
	}
}
