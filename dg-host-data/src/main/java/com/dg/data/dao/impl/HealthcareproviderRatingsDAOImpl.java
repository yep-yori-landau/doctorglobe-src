/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderRatingsDAO;
import com.dg.data.model.db.HealthcareproviderRatings;
import com.dg.data.model.db.mapper.HealthcareproviderRatingsMapper;

/**
 * This class represent Implementation of HealthcareproviderRatingsDAO which can
 * be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderRatingsDAOImpl
		extends GenericDAOImpl<HealthcareproviderRatings>
		implements HealthcareproviderRatingsDAO {

	/**
	 * @param healthcareprovider
	 * @return list of healthcareprovider_ratings
	 */
	@Override
	public List<HealthcareproviderRatings> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderRatings> healthcareproviderratingsList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_ratings where healthcareprovider = ?";
			healthcareproviderratingsList = this.getJdbcTemplate().query(query,
					new Object[] { healthcareprovider },
					new HealthcareproviderRatingsMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderratingsList;
	}
}
