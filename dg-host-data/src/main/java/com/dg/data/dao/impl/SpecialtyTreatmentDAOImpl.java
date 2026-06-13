/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.SpecialtyTreatmentDAO;
import com.dg.data.model.db.SpecialtyTreatment;
import com.dg.data.model.db.mapper.SpecialtyTreatmentMapper;

/**
 * @author DoctorGlobe
 * 
 */

public class SpecialtyTreatmentDAOImpl extends
		GenericDAOImpl<SpecialtyTreatment>implements SpecialtyTreatmentDAO {

	/**
	 * @param speciality
	 * @return list
	 */
	@Override
	public List<SpecialtyTreatment> findBySpecialty(BigInteger specialty) {
		List<SpecialtyTreatment> specialtytreatmentList = null;
		try {
			String query = "SELECT *FROM specialty_treatment where specialty = ?";
			specialtytreatmentList = this.getJdbcTemplate().query(query,
					new Object[] { specialty }, new SpecialtyTreatmentMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return specialtytreatmentList;
	}
}
