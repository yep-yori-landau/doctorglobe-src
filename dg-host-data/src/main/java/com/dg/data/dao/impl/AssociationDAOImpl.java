/**
 * 
 */
package com.dg.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.AssociationDAO;
import com.dg.data.model.db.Association;
import com.dg.data.model.db.mapper.AssociationMapper;

/**
 * This class represent Implementation of AssociationDAO which can be extended
 * to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class AssociationDAOImpl extends GenericDAOImpl<Association>
		implements AssociationDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AssociationDAOImpl.class);

	@Override
	public Association findByWhitelableUrl(String url) {
		Association model = new Association();
		try {
			String query = "select *from association where whitelabel_url = ? limit 1";
			model = this.getJdbcTemplate().queryForObject(query,
					new Object[] { url }, new AssociationMapper());
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		return model;
	}
}
