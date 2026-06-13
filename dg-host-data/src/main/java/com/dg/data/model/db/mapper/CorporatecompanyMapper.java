/**
 * 
 */
package com.dg.data.model.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.dg.data.model.db.Corporatecompany;

/**
 * This class represent the mapping between Corporatecompany model object fields
 * to a database fields and back when the spring JDBC generic DAO call it
 * 
 * @author DoctorGlobe
 */

public class CorporatecompanyMapper implements RowMapper<Corporatecompany> {
	/**
	 * This function map the Corporatecompany model object fields to a database
	 * fields and return the Corporatecompany model object
	 * @throws SQLException if the object fields can not map to the database
	 * fields ResultSet,Rows return corporatecompany
	 */
	public Corporatecompany mapRow(ResultSet rs, int rows) throws SQLException {
		Corporatecompany corporatecompany = new Corporatecompany();
		corporatecompany.setId(rs.getBigDecimal("id").toBigInteger());
		corporatecompany.setName(rs.getString("name"));
		corporatecompany.setAddress_1(rs.getString("address_1"));
		corporatecompany.setAddress_2(rs.getString("address_2"));
		corporatecompany.setZipCode(rs.getString("zip_code"));
		corporatecompany.setWebsite(rs.getString("website"));
		corporatecompany.setPhone_1(rs.getString("phone_1"));
		corporatecompany.setPhone_2(rs.getString("phone_2"));
		corporatecompany.setEmail(rs.getString("email"));
		corporatecompany.setDescription(rs.getString("description"));
		corporatecompany.setWhitelabelUrl(rs.getString("whitelabel_url"));
		corporatecompany
				.setMinimumAmountSpread(rs.getDouble("minimum_amount_spread"));
		corporatecompany.setMinimumPercentageSpread(
				rs.getDouble("minimum_percentage_spread"));
		corporatecompany.setCurrency(rs.getString("currency"));
		corporatecompany.setDgCommission(rs.getInt("dg_commission"));
		corporatecompany.setWorkerIncentive(rs.getInt("worker_incentive"));
		corporatecompany.setCity(rs.getBigDecimal("city").toBigInteger());
		if (rs.getBigDecimal("association") != null) {
			corporatecompany.setAssociation(
					rs.getBigDecimal("association").toBigInteger());
		}
		corporatecompany.setTheme(rs.getString("theme"));
		corporatecompany.setEin(rs.getString("ein"));
		corporatecompany.setFirstName(rs.getString("first_name"));
		corporatecompany.setLastName(rs.getString("last_name"));
		return corporatecompany;
	}
}
