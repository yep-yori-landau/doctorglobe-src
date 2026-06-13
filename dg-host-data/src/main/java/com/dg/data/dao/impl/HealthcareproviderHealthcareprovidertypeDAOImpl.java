/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderHealthcareprovidertypeDAO;
import com.dg.data.model.db.HealthcareproviderHealthcareprovidertype;
import com.dg.data.model.db.mapper.HealthcareproviderHealthcareprovidertypeMapper;

/**
 * This class represent Implementation of
 * HealthcareproviderHealthcareprovidertypeDAO which can be extended to add more
 * specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderHealthcareprovidertypeDAOImpl
		extends GenericDAOImpl<HealthcareproviderHealthcareprovidertype>
		implements HealthcareproviderHealthcareprovidertypeDAO {

	/**
	 * 
	 */
	@Override
	public List<HealthcareproviderHealthcareprovidertype> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderHealthcareprovidertype> healthcareproviderHealthcareprovidertypeList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_healthcareprovidertype where healthcareprovider = ?";
			healthcareproviderHealthcareprovidertypeList = this
					.getJdbcTemplate().query(query,
							new Object[] { healthcareprovider },
							new HealthcareproviderHealthcareprovidertypeMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderHealthcareprovidertypeList;
	}
}
