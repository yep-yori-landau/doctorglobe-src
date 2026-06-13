/**
 * 
 */
package com.dg.data.dao.impl;

import java.util.List;
import com.dg.data.dao.StateDAO;
import com.dg.data.model.db.State;
import com.dg.data.model.db.mapper.StateMapper;

/**
 * @author DoctorGlobe
 * 
 */

public class StateDAOImpl extends GenericDAOImpl<State>implements StateDAO {

	/**
	 * @param id
	 * @return region
	 */
	public List<State> findByCountry(Integer country) {
		List<State> stateList = null;
		if (country != null) {
			try {
				String query = "SELECT *FROM state WHERE state.country = ?";
				stateList = this.getJdbcTemplate().query(query,
						new Object[] { country }, new StateMapper());
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return stateList;
	}
}
