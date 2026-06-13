/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.HealthcareproviderSpecialtyTreatmentMethodDAO;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethod;
import com.dg.data.model.db.mapper.HealthcareproviderSpecialtyTreatmentMethodMapper;

/**
 * This class represent Implementation of
 * HealthcareproviderSpecialtyTreatmentMethodDAO which can be extended to add
 * more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyTreatmentMethodDAOImpl
		extends GenericDAOImpl<HealthcareproviderSpecialtyTreatmentMethod>
		implements HealthcareproviderSpecialtyTreatmentMethodDAO {

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(
			HealthcareproviderSpecialtyTreatmentMethod healthcareproviderspecialtytreatmentmethod) {
		Integer result = 0;
		try {
			int row = super.insert(healthcareproviderspecialtytreatmentmethod);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from healthcareprovider_specialty_treatment_method where treatment = ? and method = ? and healthcareprovider_specialty = ?",
						new Object[] {
								healthcareproviderspecialtytreatmentmethod
										.getTreatment(),
								healthcareproviderspecialtytreatmentmethod
										.getMethod(),
								healthcareproviderspecialtytreatmentmethod
										.getHealthcareproviderSpecialty() },
						Integer.class);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(
			HealthcareproviderSpecialtyTreatmentMethod healthcareproviderspecialtytreatmentmethod,
			BigInteger user, String type) {
		Integer result = 0;
		try {
			int row = super.insert(healthcareproviderspecialtytreatmentmethod,
					user, type);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from healthcareprovider_specialty_treatment_method where treatment = ? and method = ? and healthcareprovider_specialty = ?",
						new Object[] {
								healthcareproviderspecialtytreatmentmethod
										.getTreatment(),
								healthcareproviderspecialtytreatmentmethod
										.getMethod(),
								healthcareproviderspecialtytreatmentmethod
										.getHealthcareproviderSpecialty() },
						Integer.class);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialty(
			BigInteger healthcareproviderSpecialty) {
		List<HealthcareproviderSpecialtyTreatmentMethod> healthcareproviderspecialtytreatmentmethodList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_specialty_treatment_method where healthcareprovider_specialty = ?";
			healthcareproviderspecialtytreatmentmethodList = this
					.getJdbcTemplate().query(query,
							new Object[] { healthcareproviderSpecialty },
							new HealthcareproviderSpecialtyTreatmentMethodMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderspecialtytreatmentmethodList;
	}

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderSpecialtyTreatmentMethod> healthcareproviderspecialtytreatmentmethodList = null;
		try {
			String query = "Select hstm.* from healthcareprovider_specialty_treatment_method hstm left join healthcareprovider_specialty hs on hs.id = hstm.healthcareprovider_specialty"
					+ " left join healthcareprovider h on hs.healthcareprovider = h.id where h.id = ? and hstm.active = 1";
			healthcareproviderspecialtytreatmentmethodList = this
					.getJdbcTemplate().query(query,
							new Object[] { healthcareprovider },
							new HealthcareproviderSpecialtyTreatmentMethodMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderspecialtytreatmentmethodList;
	}

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findByHealthcareproviderSpecialtyTreatment(
			BigInteger healthcareprovider_specialty, BigInteger treatment) {
		List<HealthcareproviderSpecialtyTreatmentMethod> healthcareproviderspecialtytreatmentmethodList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_specialty_treatment_method where healthcareprovider_specialty = ? and treatment = ?";
			healthcareproviderspecialtytreatmentmethodList = this
					.getJdbcTemplate().query(query,
							new Object[] { healthcareprovider_specialty,
									treatment },
							new HealthcareproviderSpecialtyTreatmentMethodMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderspecialtytreatmentmethodList;
	}

	@Override
	public HealthcareproviderSpecialtyTreatmentMethod findByHealthcareproviderSpecialtyTreatmentMethod(
			BigInteger healthcareprovider_specialty, BigInteger treatment,
			BigInteger method) {
		HealthcareproviderSpecialtyTreatmentMethod healthcareproviderSpecialtyTreatmentMethodModel = new HealthcareproviderSpecialtyTreatmentMethod();
		try {
			String query = "SELECT *FROM healthcareprovider_specialty_treatment_method where healthcareprovider_specialty = ? and treatment = ? and method = ?";
			healthcareproviderSpecialtyTreatmentMethodModel = this
					.getJdbcTemplate().queryForObject(query,
							new Object[] { healthcareprovider_specialty,
									treatment, method },
							new HealthcareproviderSpecialtyTreatmentMethodMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderSpecialtyTreatmentMethodModel;
	}

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethod> findBySpecialty(
			BigInteger specialty) {
		List<HealthcareproviderSpecialtyTreatmentMethod> healthcareproviderspecialtytreatmentmethodList = null;
		try {
			String query = "Select hstm.* from healthcareprovider_specialty_treatment_method hstm left join healthcareprovider_specialty hs on hs.id = hstm.healthcareprovider_specialty"
					+ " where hs.specialty = ? and hstm.active = 1";
			healthcareproviderspecialtytreatmentmethodList = this
					.getJdbcTemplate().query(query, new Object[] { specialty },
							new HealthcareproviderSpecialtyTreatmentMethodMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderspecialtytreatmentmethodList;
	}

}
