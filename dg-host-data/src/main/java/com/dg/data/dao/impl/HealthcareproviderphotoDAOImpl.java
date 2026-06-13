/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderphotoDAO;
import com.dg.data.model.db.Healthcareproviderphoto;
import com.dg.data.model.db.mapper.HealthcareproviderphotoMapper;

/**
 * This class represent Implementation of HealthcareproviderphotoDAO which can
 * be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderphotoDAOImpl
		extends GenericDAOImpl<Healthcareproviderphoto>
		implements HealthcareproviderphotoDAO {

	/**
	 * 
	 */
	public Integer insert(Healthcareproviderphoto healthcareproviderphoto) {
		System.out.print(healthcareproviderphoto.getIsPrimary());
		Integer result = 0;
		try {
			if (healthcareproviderphoto.getIsPrimary().equals(1)) {
				String updateQuery = "UPDATE healthcareproviderphoto set is_primary = 0 where healthcareprovider = ?";
				this.getJdbcTemplate().update(updateQuery, new Object[] {
						healthcareproviderphoto.getHealthcareprovider() });
			}
			result = super.insert(healthcareproviderphoto);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(Healthcareproviderphoto healthcareproviderphoto,
			BigInteger user, String type) {
		Integer result = 0;
		try {
			if (healthcareproviderphoto.getIsPrimary().equals(1)) {
				String updateQuery = "UPDATE healthcareproviderphoto set is_primary = 0 where healthcareprovider = ?";
				this.getJdbcTemplate().update(updateQuery, new Object[] {
						healthcareproviderphoto.getHealthcareprovider() });
			}
			result = super.insert(healthcareproviderphoto, user, type);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Healthcareproviderphoto> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<Healthcareproviderphoto> healthcareproviderphotoList = null;
		try {
			String query = "SELECT *FROM healthcareproviderphoto where healthcareprovider = ?";
			healthcareproviderphotoList = this.getJdbcTemplate().query(query,
					new Object[] { healthcareprovider },
					new HealthcareproviderphotoMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderphotoList;
	}
}
