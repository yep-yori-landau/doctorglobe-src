/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.dao.HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitionerStat;
import com.dg.data.model.db.mapper.HealthcareproviderSpecialtyTreatmentMethodPractitionerStatMapper;

/**
 * This class represent Implementation of
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAOImpl
		extends
		GenericDAOImpl<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat>
		implements
		HealthcareproviderSpecialtyTreatmentMethodPractitionerStatDAO {
	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> findByHstmp(
			BigInteger hstmp) {
		List<HealthcareproviderSpecialtyTreatmentMethodPractitionerStat> healthcareproviderspecialtytreatmentmethodpractitionerstatList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_specialty_treatment_method_practitioner_stat WHERE healthcareprovider_specialty_treatment_method_practitioner = ?";
			healthcareproviderspecialtytreatmentmethodpractitionerstatList = this
					.getJdbcTemplate().query(query, new Object[] { hstmp },
							new HealthcareproviderSpecialtyTreatmentMethodPractitionerStatMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderspecialtytreatmentmethodpractitionerstatList;
	}
}
