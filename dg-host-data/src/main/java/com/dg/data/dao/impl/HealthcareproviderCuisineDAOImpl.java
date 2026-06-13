/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderCuisineDAO;
import com.dg.data.model.db.HealthcareproviderCuisine;
import com.dg.data.model.db.mapper.HealthcareproviderCuisineMapper;

/**
 * This class represent Implementation of HealthcareproviderCuisineDAO which can
 * be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderCuisineDAOImpl
		extends GenericDAOImpl<HealthcareproviderCuisine>
		implements HealthcareproviderCuisineDAO {

	@Override
	public List<HealthcareproviderCuisine> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderCuisine> healthcareproviderCuisineList = null;
		try {
			if (healthcareprovider != null) {
				String query = "SELECT *FROM healthcareprovider_cuisine WHERE healthcareprovider = ?";
				healthcareproviderCuisineList = this.getJdbcTemplate().query(
						query, new Object[] { healthcareprovider },
						new HealthcareproviderCuisineMapper());
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderCuisineList;
	}
}
