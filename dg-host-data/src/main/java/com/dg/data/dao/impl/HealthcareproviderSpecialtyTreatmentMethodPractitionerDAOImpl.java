/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dg.data.dao.HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO;
import com.dg.data.model.db.HealthcareproviderSpecialtyTreatmentMethodPractitioner;
import com.dg.data.model.db.mapper.HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper;
import com.dg.data.model.domain.HospitalPractitionerModel;
import com.dg.data.model.domain.mapper.HospitalPractitionerMapper;

/**
 * This class represent Implementation of
 * HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class HealthcareproviderSpecialtyTreatmentMethodPractitionerDAOImpl
		extends
		GenericDAOImpl<HealthcareproviderSpecialtyTreatmentMethodPractitioner>
		implements HealthcareproviderSpecialtyTreatmentMethodPractitionerDAO {
	private static final Logger logger = LoggerFactory.getLogger(
			HealthcareproviderSpecialtyTreatmentMethodPractitionerDAOImpl.class);

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHstm(
			BigInteger hstm) {
		List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> healthcareproviderSpecialtyTreatmentMethodPractitionerList = null;
		try {
			String query = "SELECT *FROM healthcareprovider_specialty_treatment_method_practitioner where healthcareprovider_specialty_treatment_method = ?";
			healthcareproviderSpecialtyTreatmentMethodPractitionerList = this
					.getJdbcTemplate().query(query, new Object[] { hstm },
							new HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderSpecialtyTreatmentMethodPractitionerList;
	}

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findByHealthcareprovider(
			BigInteger healthcareprovider) {
		List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> healthcareproviderSpecialtyTreatmentMethodPractitionerList = null;
		try {
			String query = "SELECT hstmp.* FROM healthcareprovider_specialty_treatment_method_practitioner hstmp "
					+ " left join healthcareprovider_specialty_treatment_method hstm on hstm.id = hstmp.healthcareprovider_specialty_treatment_method "
					+ " left join healthcareprovider_specialty hs on hs.id = hstm.healthcareprovider_specialty"
					+ " left join healthcareprovider h on hs.healthcareprovider = h.id where h.id = ? and hstmp.active = 1";
			healthcareproviderSpecialtyTreatmentMethodPractitionerList = this
					.getJdbcTemplate().query(query,
							new Object[] { healthcareprovider },
							new HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderSpecialtyTreatmentMethodPractitionerList;
	}

	/**
	 * @param id
	 * @return region
	 */
	public HealthcareproviderSpecialtyTreatmentMethodPractitioner findByHstmPractitioner(
			BigInteger hstm, BigInteger practitioner) {
		HealthcareproviderSpecialtyTreatmentMethodPractitioner healthcareproviderSpecialtyTreatmentMethodPractitioner = new HealthcareproviderSpecialtyTreatmentMethodPractitioner();
		try {
			String query = "SELECT *FROM healthcareprovider_specialty_treatment_method_practitioner WHERE healthcareprovider_specialty_treatment_method = ? and practitioner = ?";
			healthcareproviderSpecialtyTreatmentMethodPractitioner = this
					.getJdbcTemplate().queryForObject(query,
							new Object[] { hstm, practitioner },
							new HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderSpecialtyTreatmentMethodPractitioner;
	}

	@Override
	public List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> findBySpecialty(
			BigInteger specialty) {
		List<HealthcareproviderSpecialtyTreatmentMethodPractitioner> healthcareproviderSpecialtyTreatmentMethodPractitionerList = null;
		try {
			String query = "SELECT hstmp.* FROM healthcareprovider_specialty_treatment_method_practitioner hstmp "
					+ " left join healthcareprovider_specialty_treatment_method hstm on hstm.id = hstmp.healthcareprovider_specialty_treatment_method "
					+ " left join healthcareprovider_specialty hs on hs.id = hstm.healthcareprovider_specialty"
					+ " left join specialty s on hs.specialty = s.id where s.id = ?";
			healthcareproviderSpecialtyTreatmentMethodPractitionerList = this
					.getJdbcTemplate().query(query, new Object[] { specialty },
							new HealthcareproviderSpecialtyTreatmentMethodPractitionerMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return healthcareproviderSpecialtyTreatmentMethodPractitionerList;
	}

	@Override
	public List<HospitalPractitionerModel> findByHstmId(BigInteger hstm) {
		List<HospitalPractitionerModel> hosptialPractitionerList = null;
		try {
			String query = "SELECT hstmp.id as id,hstmp.practitioner as practitioner,concat(p.first_name,' ',p.last_name) as practitioner_name FROM healthcareprovider_specialty_treatment_method_practitioner hstmp"
					+ " left join practitioner p on p.id = hstmp.practitioner WHERE healthcareprovider_specialty_treatment_method = ?";
			hosptialPractitionerList = this.getJdbcTemplate().query(query,
					new Object[] { hstm }, new HospitalPractitionerMapper());
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		return hosptialPractitionerList;
	}
}
