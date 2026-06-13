/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dg.data.dao.PractitionerLanguageDAO;
import com.dg.data.model.db.PractitionerLanguage;
import com.dg.data.model.db.mapper.PractitionerLanguageMapper;

/**
 * @author DoctorGlobe
 * 
 */

public class PractitionerLanguageDAOImpl extends
		GenericDAOImpl<PractitionerLanguage>implements PractitionerLanguageDAO {

	@Override
	public List<PractitionerLanguage> findByPractitioner(
			BigInteger practitioner) {
		List<PractitionerLanguage> practitionerlanguageList = null;
		try {
			String query = "SELECT *FROM practitioner_language where practitioner =?";
			practitionerlanguageList = this.getJdbcTemplate().query(query,
					new Object[] { practitioner },
					new PractitionerLanguageMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return practitionerlanguageList;
	}
}
