/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.HealthcareproviderAmenityDAO;
import com.dg.data.model.db.HealthcareproviderAmenity;
import com.dg.data.model.db.mapper.HealthcareproviderAmenityMapper;

/**
 * This class represent Implementation of HealthcareproviderAmenityDAO which can
 * be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderAmenityDAOImpl
		extends GenericDAOImpl<HealthcareproviderAmenity>
		implements HealthcareproviderAmenityDAO {
	@Override
	public List<HealthcareproviderAmenity> findByHealthacareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderAmenity> healthcareprovideramenityList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_amenity where healthcareprovider = ?";
			healthcareprovideramenityList = this.getJdbcTemplate().query(query,
					new Object[] { healthcareprovider },
					new HealthcareproviderAmenityMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareprovideramenityList;
	}
}
