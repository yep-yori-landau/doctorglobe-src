/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.dg.data.dao.PatientcaseDAO;
import com.dg.data.model.db.Patientcase;
import com.dg.data.model.domain.PatientcaseDetailModel;

/**
 * This class represent Implementation of PatientcaseDAO which can be extended
 * to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class PatientcaseDAOImpl extends GenericDAOImpl<Patientcase>
		implements PatientcaseDAO {

	/**
	 * @param region
	 * @return integer
	 */
	public Integer insert(Patientcase patientcase) {
		Integer result = 0;
		try {
			result = super.insert(patientcase);
			if (result > 0) {
				result = (Integer) this.getJdbcTemplate()
						.queryForObject(
								"select id from patientcase where treatment = ? and patient = ? order by id desc limit 1",
								new Object[] { patientcase.getTreatment(),
										patientcase.getPatient() },
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
	public Integer insert(Patientcase patientcase, BigInteger user,
			String type) {
		Integer result = 0;
		try {
			result = super.insert(patientcase, user, type);
			if (result > 0) {
				result = (Integer) this.getJdbcTemplate()
						.queryForObject(
								"select id from patientcase where treatment = ? and patient = ? order by id desc limit 1",
								new Object[] { patientcase.getTreatment(),
										patientcase.getPatient() },
								Integer.class);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PatientcaseDetailModel> findByPatientId(Integer patient) {
		List<PatientcaseDetailModel> patientcase = null;
		try {
			String query = "select pc.*,t.name as treatment_name from patientcase pc left join treatment t on t.id = pc.treatment left join patientconference p on p.patient_case = pc.id where pc.patient = ? and p.status != 'Delete'";
			patientcase = this.getJdbcTemplate().query(query,
					new Object[] { patient },
					new BeanPropertyRowMapper<PatientcaseDetailModel>(
							PatientcaseDetailModel.class));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientcase;
	}

	@Override
	public Integer editStatus(Integer id, String status) {
		Integer result = 0;
		if (id != null && status != null) {
			try {
				String query = "UPDATE patientcase set status =? WHERE id = ?";
				result = this.getJdbcTemplate().update(query,
						new Object[] { status, id });
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
