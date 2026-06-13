/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.History;

/**
 * This class represent the mapping between History model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class HistoryMapper implements RowMapper<History> {
	/**
	 * This function map the History model object fields to a database fields
	 * and return the History model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return healthcareprovideruser
	 */
	public History mapRow(ResultSet rs, int rows) throws SQLException {
		History historyModel = new History();
		historyModel.setId(rs.getBigDecimal("id").toBigInteger());
		historyModel.setName(rs.getString("name"));
		historyModel.setOriginalData(rs.getString("original_data"));
		historyModel.setModifyData(rs.getString("modify_data"));
		historyModel.setModifyDate(rs.getString("modify_date"));
		historyModel.setUserType(rs.getString("user_type"));
		historyModel.setUser(rs.getBigDecimal("user").toBigInteger());
		return historyModel;
	}
}
