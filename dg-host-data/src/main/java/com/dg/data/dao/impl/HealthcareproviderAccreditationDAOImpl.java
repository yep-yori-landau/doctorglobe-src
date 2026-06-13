/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderAccreditationDAO;
import com.dg.data.model.db.HealthcareproviderAccreditation;
import com.dg.data.model.db.mapper.HealthcareproviderAccreditationMapper;

/**
 * This class represent Implementation of HealthcareproviderAccreditationDAO
 * which can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderAccreditationDAOImpl
		extends GenericDAOImpl<HealthcareproviderAccreditation>
		implements HealthcareproviderAccreditationDAO {

	@Override
	public List<HealthcareproviderAccreditation> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderAccreditation> healthcareprovideraccreditationList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_accreditation where healthcareprovider = ?";
			healthcareprovideraccreditationList = this.getJdbcTemplate().query(
					query, new Object[] { healthcareprovider },
					new HealthcareproviderAccreditationMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareprovideraccreditationList;
	}
}
