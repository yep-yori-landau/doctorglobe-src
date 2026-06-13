/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.HealthcareproviderSpecialtyDAO;
import com.dg.data.model.db.HealthcareproviderSpecialty;
import com.dg.data.model.db.mapper.HealthcareproviderSpecialtyMapper;

/**
 * This class represent Implementation of HealthcareproviderSpecialtyDAO which
 * can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyDAOImpl
		extends GenericDAOImpl<HealthcareproviderSpecialty>
		implements HealthcareproviderSpecialtyDAO {

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(
			HealthcareproviderSpecialty healthcareproviderSpecialty) {
		Integer result = 0;
		try {
			// String sql = "INSERT INTO healthcareprovider_specialty
			// (id,name,built,renovated,specialty,healthcareprovider,active)
			// VALUES (? ,? ,? ,? ,? ,? ,? ) ON DUPLICATE KEY UPDATE name =
			// ?,built = ?,renovated = ?,specialty = ?,healthcareprovider =
			// ?,active = ?";
			int row = super.insert(healthcareproviderSpecialty);// this.getJdbcTemplate().update(sql,
																// new Object[]
																// {
																// healthcareproviderSpecialty.getId(),healthcareproviderSpecialty.getName(),healthcareproviderSpecialty.getBuilt(),healthcareproviderSpecialty.getRenovated(),healthcareproviderSpecialty.getSpecialty(),healthcareproviderSpecialty.getHealthcareprovider(),healthcareproviderSpecialty.getActive()
																// ,healthcareproviderSpecialty.getName(),healthcareproviderSpecialty.getBuilt(),healthcareproviderSpecialty.getRenovated(),healthcareproviderSpecialty.getSpecialty(),healthcareproviderSpecialty.getHealthcareprovider(),healthcareproviderSpecialty.getActive()
																// });
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from healthcareprovider_specialty where specialty = ? and healthcareprovider = ?",
						new Object[] {
								healthcareproviderSpecialty.getSpecialty(),
								healthcareproviderSpecialty
										.getHealthcareprovider() },
						Integer.class);
			}
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
	public Integer insert(
			HealthcareproviderSpecialty healthcareproviderSpecialty,
			BigInteger user, String type) {
		Integer result = 0;
		try {
			int row = super.insert(healthcareproviderSpecialty, user, type);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from healthcareprovider_specialty where specialty = ? and healthcareprovider = ?",
						new Object[] {
								healthcareproviderSpecialty.getSpecialty(),
								healthcareproviderSpecialty
										.getHealthcareprovider() },
						Integer.class);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * param healthcareprovider return list of helathcareprovider specialty
	 */
	@Override
	public List<HealthcareproviderSpecialty> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderSpecialty> healthcareproviderSpecialtyList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_specialty where healthcareprovider = ?";
			healthcareproviderSpecialtyList = this.getJdbcTemplate().query(
					query, new Object[] { healthcareprovider },
					new HealthcareproviderSpecialtyMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderSpecialtyList;
	}
}
