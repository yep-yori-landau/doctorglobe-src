/**
 * 
 */
package com.dg.data.dao.impl;

import com.dg.data.dao.PatientcasePriceDAO;
import com.dg.data.model.db.PatientcasePrice;
import com.dg.data.model.db.mapper.PatientcasePriceMapper;

/**
 * This class represent Implementation of PatientcasePriceDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class PatientcasePriceDAOImpl extends GenericDAOImpl<PatientcasePrice>
		implements PatientcasePriceDAO {

	@Override
	public PatientcasePrice findByPatientcaseAndHcpstmp(Integer patientcase,
			Integer hcpstmp) {
		PatientcasePrice patientcasePriceModel = new PatientcasePrice();
		try {
			String query = "SELECT *FROM patientcase_price where patient_case = ? and healthcareprovider_specialty_treatment_method_practitioner = ?";
			patientcasePriceModel = this.getJdbcTemplate().queryForObject(query,
					new Object[] { patientcase, hcpstmp },
					new PatientcasePriceMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientcasePriceModel;
	}
}
