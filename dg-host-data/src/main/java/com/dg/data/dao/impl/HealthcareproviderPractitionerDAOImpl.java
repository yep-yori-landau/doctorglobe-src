package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.HealthcareproviderPractitionerDAO;
import com.dg.data.model.db.HealthcareproviderPractitioner;
import com.dg.data.model.db.mapper.HealthcareproviderPractitionerMapper;

/**
 * This class represent Implementation of HealthcareproviderPractitionerDAO
 * which can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */
public class HealthcareproviderPractitionerDAOImpl
		extends GenericDAOImpl<HealthcareproviderPractitioner>
		implements HealthcareproviderPractitionerDAO {

	@Override
	public List<HealthcareproviderPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderPractitioner> healthcareproviderPractitionerList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_practitioner where healthcareprovider = ?";
			healthcareproviderPractitionerList = this.getJdbcTemplate().query(
					query, new Object[] { healthcareprovider },
					new HealthcareproviderPractitionerMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderPractitionerList;
	}

}