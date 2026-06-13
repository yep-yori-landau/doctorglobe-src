/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Region;

/**
 * This class represent the mapping between Region model object fields to a
 * database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class RegionMapper implements RowMapper<Region> {
	/**
	 * This function map the Region model object fields to a database fields and
	 * return the Region model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return region
	 */
	public Region mapRow(ResultSet rs, int rows) throws SQLException {
		Region region = new Region();
		region.setId(rs.getBigDecimal("id").toBigInteger());
		region.setName(rs.getString("name"));

		return region;
	}
}
