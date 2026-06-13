package com.dg.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.HistoryDAO;
import com.dg.data.model.db.History;

/**
 * This class represent Implementation of HistoryDAO which can be extended to
 * add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */
public class HistoryDAOImpl extends GenericDAOImpl<History>
		implements HistoryDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(HistoryDAOImpl.class);

	@Override
	public Integer insert(History history) {
		Integer result = 0;
		try {
			String sql = "INSERT INTO history (id,name,original_data,modify_data,modify_date,user_type,user) VALUES (? ,? ,? ,? ,? ,? ,?)";
			result = this.getJdbcTemplate().update(sql,
					new Object[] { history.getId(), history.getName(),
							history.getOriginalData(), history.getModifyData(),
							history.getModifyDate(), history.getUserType(),
							history.getUser(), });
		}
		catch (Exception ex) {
			logger.info("sql error found ={}", ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}

}