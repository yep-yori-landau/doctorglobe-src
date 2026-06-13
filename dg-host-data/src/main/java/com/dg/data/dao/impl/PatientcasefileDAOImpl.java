/**
 * 
 */
package com.dg.data.dao.impl;

import java.util.List;

import com.dg.data.dao.PatientcasefileDAO;
import com.dg.data.model.db.Patientcasefile;
import com.dg.data.model.db.mapper.PatientcasefileMapper;

/**
 * This class represent Implementation of PatientcasefileDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */
public class PatientcasefileDAOImpl extends GenericDAOImpl<Patientcasefile>
		implements PatientcasefileDAO {

	@Override
	public List<Patientcasefile> findByPatientCaseId(Integer patientcase) {
		List<Patientcasefile> patientcasefileList = null;
		try {
			String query = "SELECT *FROM patientcasefile where patient_case = ?";
			patientcasefileList = this.getJdbcTemplate().query(query,
					new Object[] { patientcase }, new PatientcasefileMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientcasefileList;
	}
}
