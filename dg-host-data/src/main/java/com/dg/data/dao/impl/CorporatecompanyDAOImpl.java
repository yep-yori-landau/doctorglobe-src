/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.CorporatecompanyDAO;
import com.dg.data.model.db.Corporatecompany;
import com.dg.data.model.db.mapper.CorporatecompanyMapper;

/**
 * This class represent Implementation of CorporatecompanyDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class CorporatecompanyDAOImpl extends GenericDAOImpl<Corporatecompany>
		implements CorporatecompanyDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CorporatecompanyDAOImpl.class);

	/**
	 * Find the Corporatecompany based on patient id
	 * @param id the unique id of patient
	 * @return Corporatecompany model
	 */
	@Override
	public Corporatecompany findByPatientId(BigInteger id) {
		Corporatecompany model = new Corporatecompany();
		try {
			String query = "select cc.* from employee_corporatecompany empcc "
					+ "	left outer join corporatecompany_insurance cci on empcc.corporatecompany_insurance = cci.id"
					+ "	left outer join corporatecompany cc on cci.corporate_company = cc.id"
					+ " where patient = ? limit 1";
			model = this.getJdbcTemplate().queryForObject(query,
					new Object[] { id }, new CorporatecompanyMapper());
		}
		catch (Exception ex) {
			logger.info("sql error found {}", ex.getMessage());
		}
		return model;
	}

	/**
	 * Find the Corporatecompany based on whitelable url
	 * @param url
	 * @return corporate companny model
	 */
	@Override
	public Corporatecompany findByWhitelabelUrl(String url) {
		Corporatecompany model = new Corporatecompany();
		try {
			logger.info("url {}", url);
			String query = "select *from corporatecompany where whitelabel_url = ? limit 1";
			model = this.getJdbcTemplate().queryForObject(query,
					new Object[] { url }, new CorporatecompanyMapper());
		}
		catch (Exception ex) {
			logger.info("sql error found {}", ex.getMessage());
		}
		return model;
	}

}
