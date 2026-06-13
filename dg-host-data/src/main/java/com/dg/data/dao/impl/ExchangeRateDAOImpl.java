/**
 * 
 */
package com.dg.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dg.data.dao.ExchangeRateDAO;
import com.dg.data.model.db.ExchangeRate;
import com.dg.data.model.db.mapper.ExchangeRateMapper;

/**
 * This class represent Implementation of ExchangeRateDAO which can be extended
 * to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class ExchangeRateDAOImpl extends GenericDAOImpl<ExchangeRate>
		implements ExchangeRateDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ExchangeRateDAOImpl.class);

	/**
	 * @param id
	 * @return region
	 */
	@Override
	public ExchangeRate findByFromToCurrency(String from, String to) {
		ExchangeRate exchangerate = new ExchangeRate();
		if (from != null && to != null) {
			try {
				String query = "SELECT *FROM exchange_rate WHERE from_cur = ? and to_cur = ? limit 1";
				exchangerate = this.getJdbcTemplate().queryForObject(query,
						new Object[] { from, to }, new ExchangeRateMapper());
			}
			catch (Exception ex) {
				logger.info("sql error found {}", ex.getMessage());
				ex.printStackTrace();
			}
		}
		return exchangerate;
	}
}
