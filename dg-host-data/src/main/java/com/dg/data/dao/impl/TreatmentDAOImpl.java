/**
 * 
 */
package com.dg.data.dao.impl;

import java.util.List;
import com.dg.data.dao.TreatmentDAO;
import com.dg.data.model.db.Treatment;
import com.dg.data.model.db.mapper.TreatmentMapper;
import com.dg.data.model.domain.TreatmentSearchModel;
import com.dg.data.model.domain.mapper.TreatmentSearchMapper;

/**
 * @author DoctorGlobe
 * 
 */

public class TreatmentDAOImpl extends GenericDAOImpl<Treatment>
		implements TreatmentDAO {
	/**
	 * @param name
	 * @return list of treatments
	 */
	@Override
	public List<Treatment> findByName(String name) {
		List<Treatment> treatmentList = null;
		try {
			String query = "SELECT *FROM treatment where name like '%" + name
					+ "%'";
			treatmentList = this.getJdbcTemplate().query(query,
					new TreatmentMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return treatmentList;
	}

	@Override
	public List<TreatmentSearchModel> findByTreatmentName(String name) {
		List<TreatmentSearchModel> treatmentList = null;
		try {
			String query = "SELECT t.id as id,t.name as name,ta.name as alias_name FROM treatment t left join treatment_alias ta on ta.treatment = t.id where t.name like '%"
					+ name + "%' or ta.name like '%" + name + "%'";
			treatmentList = this.getJdbcTemplate().query(query,
					new TreatmentSearchMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return treatmentList;
	}
}
