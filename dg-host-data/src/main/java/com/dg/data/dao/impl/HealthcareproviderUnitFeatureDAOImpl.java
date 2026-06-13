/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderUnitFeatureDAO;
import com.dg.data.model.db.HealthcareproviderUnitFeature;
import com.dg.data.model.db.mapper.HealthcareproviderUnitFeatureMapper;

/**
 * This class represent Implementation of HealthcareproviderUnitFeatureDAO which
 * can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderUnitFeatureDAOImpl
		extends GenericDAOImpl<HealthcareproviderUnitFeature>
		implements HealthcareproviderUnitFeatureDAO {

	@Override
	public List<HealthcareproviderUnitFeature> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderUnitFeature> healthcareproviderunitfeatureList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_unit_feature where healthcareprovider = ?";
			healthcareproviderunitfeatureList = this.getJdbcTemplate().query(
					query, new Object[] { healthcareprovider },
					new HealthcareproviderUnitFeatureMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderunitfeatureList;
	}
}
