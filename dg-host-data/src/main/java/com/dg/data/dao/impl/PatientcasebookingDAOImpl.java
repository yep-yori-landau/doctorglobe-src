/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.dao.PatientcasebookingDAO;
import com.dg.data.model.db.Patientcasebooking;
import com.dg.data.model.db.mapper.PatientcasebookingMapper;

/**
 * This class represent Implementation of PatientcasebookingDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class PatientcasebookingDAOImpl extends
		GenericDAOImpl<Patientcasebooking>implements PatientcasebookingDAO {
	@Override
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp,
			String status) {
		Integer result = 0;
		if (pc != null && hcpstmp != null && status != null) {
			try {
				String query = "UPDATE patientcasebooking set status =? WHERE patient_case = ? and healthcareprovider_specialty_treatment_method_practitioner = ?";
				result = this.getJdbcTemplate().update(query,
						new Object[] { status, pc, hcpstmp });
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<Patientcasebooking> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp) {
		List<Patientcasebooking> PatientcasebookingList = null;
		try {
			String query = "SELECT *FROM patientcasebooking where patient_case = ? and healthcareprovider_specialty_treatment_method_practitioner = ?";
			PatientcasebookingList = this.getJdbcTemplate().query(query,
					new Object[] { patientcase, hcpstmp },
					new PatientcasebookingMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return PatientcasebookingList;
	}

	@Override
	public List<Patientcasebooking> findByPatientAndTreatment(Integer patient,
			Integer treatment) {
		List<Patientcasebooking> patientcasebookingList = null;
		try {
			String query = "select pcb.* from patientcasebooking pcb left join patientcase pc on pcb.patient_case=pc.id where pc.patient= ? and pc.treatment= ? and pcb.status = 'Open'";
			patientcasebookingList = this.getJdbcTemplate().query(query,
					new Object[] { patient, treatment },
					new PatientcasebookingMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientcasebookingList;
	}

	@Override
	public List<Patientcasebooking> findByPatientCase(int patientcase) {
		List<Patientcasebooking> patientcasebookingList = null;
		try {
			String query = "select *from patientcasebooking pcb where pcb.patient_case = ? and pcb.status = 'Open'";
			patientcasebookingList = this.getJdbcTemplate().query(query,
					new Object[] { patientcase },
					new PatientcasebookingMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientcasebookingList;
	}
}
