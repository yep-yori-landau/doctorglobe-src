/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderInsuranceDAO;
import com.dg.data.model.db.HealthcareproviderInsurance;
import com.dg.data.model.db.mapper.HealthcareproviderInsuranceMapper;

/**
 * This class represent Implementation of HealthcareproviderInsuranceDAO which
 * can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderInsuranceDAOImpl
		extends GenericDAOImpl<HealthcareproviderInsurance>
		implements HealthcareproviderInsuranceDAO {
	@Override
	public List<HealthcareproviderInsurance> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderInsurance> healthcareproviderinsuranceList = null;
		if (healthcareprovider != null) {
			try {
				String query = "SELECT *FROM healthcareprovider_insurance WHERE healthcareprovider_insurance.healthcareprovider = ?";
				healthcareproviderinsuranceList = this.getJdbcTemplate().query(
						query, new Object[] { healthcareprovider },
						new HealthcareproviderInsuranceMapper());
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return healthcareproviderinsuranceList;
	}

	@Override
	public Boolean deleteByHealthcareprovider(BigInteger healthcareprovider) {
		Integer result = 0;
		if (healthcareprovider != null) {
			try {
				String query = "DELETE FROM healthcareprovider_insurance WHERE healthcareprovider = ?";
				result = this.getJdbcTemplate().update(query,
						new Object[] { healthcareprovider });
				if (result > 0) {
					return true;
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}
}
