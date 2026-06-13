/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.HealthcareproviderLanguageDAO;
import com.dg.data.model.db.HealthcareproviderLanguage;
import com.dg.data.model.db.mapper.HealthcareproviderLanguageMapper;

/**
 * This class represent Implementation of HealthcareproviderLanguageDAO which
 * can be extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderLanguageDAOImpl
		extends GenericDAOImpl<HealthcareproviderLanguage>
		implements HealthcareproviderLanguageDAO {
	/**
	 * @param healthcareprovider
	 * @return healthcareprovider_language model list
	 */
	@Override
	public List<HealthcareproviderLanguage> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderLanguage> healthcareproviderlanguageList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_language where healthcareprovider = ?";
			healthcareproviderlanguageList = this.getJdbcTemplate().query(query,
					new Object[] { healthcareprovider },
					new HealthcareproviderLanguageMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderlanguageList;
	}
}
