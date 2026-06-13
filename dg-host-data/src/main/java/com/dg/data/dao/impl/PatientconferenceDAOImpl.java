/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dg.data.dao.PatientconferenceDAO;
import com.dg.data.model.db.Patientconference;
import com.dg.data.model.db.mapper.PatientconferenceMapper;
import com.dg.data.model.domain.PatientConferenceDetailModel;
import com.dg.data.model.domain.mapper.PatientConferenceDetailMapper;

/**
 * This class represent Implementation of PatientconferenceDAO which can be
 * extended to add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */

public class PatientconferenceDAOImpl extends GenericDAOImpl<Patientconference>
		implements PatientconferenceDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientconferenceDAOImpl.class);

	@Override
	public List<PatientConferenceDetailModel> findByPatientCase(
			Integer patientcase, Integer patient) {
		List<PatientConferenceDetailModel> patientconferenceList = null;
		try {
			String query = "Select a.id as id,a.conference_dt as conference_dt,a.status as status,a.healthcareprovider_specialty_treatment_method_practitioner as healthcareprovider_specialty_treatment_method_practitioner,a.timezone as conference_timezone,"
					+ " a.patient_case as patient_case ,e.id as practitioner,concat(concat(e.title,' ',e.first_name,' ',e.last_name)) as practitioner_name,e.email as practitioner_email,e.photo as practitioner_photo,h.id as healthcareprovider,"
					+ " h.name as healthcareprovider_name,pcm.sender_type as sender_type,pcm.subject as subject,pcm.body as message,pcm.sent_dt as sent_dt,pcm.id as message_id,pcm.sender as sender,pcm.receiver as receiver,pcb.id as booking_id,pcb.booking_dt as booking_dt,pcb.status as booking_status,pcb.timezone as booking_timezone,hstm.id as healthcareprovider_specialty_treatment_method from patientconference a"
					+ " left outer join patientcase b on a.patient_case = b.id"
					+ " left outer join patient c on b.patient = c.id"
					+ " left outer join patientcasemessages pcm on pcm.patient_case = b.id"
					+ " left outer join patientcasebooking pcb on pcb.patient_case = b.id and a.healthcareprovider_specialty_treatment_method_practitioner = pcb.healthcareprovider_specialty_treatment_method_practitioner"
					+ " left outer join healthcareprovider_specialty_treatment_method_practitioner hstmp on a.healthcareprovider_specialty_treatment_method_practitioner = hstmp.id"
					+ " left outer join healthcareprovider_specialty_treatment_method hstm on hstmp.healthcareprovider_specialty_treatment_method = hstm.id"
					+ " left outer join healthcareprovider_specialty hs on hstm.healthcareprovider_specialty = hs.id"
					+ " left outer join healthcareprovider h on hs.healthcareprovider = h.id"
					+ " left outer join practitioner e on hstmp.practitioner = e.id where a.patient_case = ? and c.id = ? and a.status !='Delete'";

			patientconferenceList = this.getJdbcTemplate().query(query,
					new Object[] { patientcase, patient },
					new PatientConferenceDetailMapper());

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientconferenceList;
	}

	@Override
	public List<Patientconference> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp) {
		List<Patientconference> patientconferenceList = null;
		try {
			String query = "SELECT *FROM patientconference where patient_case = ? and healthcareprovider_specialty_treatment_method_practitioner = ?";
			patientconferenceList = this.getJdbcTemplate().query(query,
					new Object[] { patientcase, hcpstmp },
					new PatientconferenceMapper());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return patientconferenceList;
	}

	@Override
	public Boolean findByPatientAndTreatmentAndHcpstmp(Integer patient,
			Integer treatment, Integer hcpstmp) {
		boolean found = false;
		try {
			String query = "select count(*) from patientconference pc left join patientcase p on pc.patient_case = p.id where p.patient= ? and p.treatment = ? and healthcareprovider_specialty_treatment_method_practitioner = ? and pc.status != 'Delete'";
			found = (Boolean) this.getJdbcTemplate().queryForObject(query,
					new Object[] { patient, treatment, hcpstmp },
					Boolean.class);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return found;
	}

	@Override
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp,
			String status) {
		Integer result = 0;
		if (pc != null && hcpstmp != null && status != null) {
			logger.info("patientcase ={}", pc);
			logger.info("hcpstmp ={}", hcpstmp);
			logger.info("status ={}", status);
			try {
				String query = "UPDATE patientconference set status =? WHERE patient_case = ? and healthcareprovider_specialty_treatment_method_practitioner = ?";
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
	public Integer findTotalPatientTreatmentConferenceByPatientAndTreatment(
			Integer patient, Integer treatment) {
		Integer result = 0;
		try {
			String query = "select count(distinct(healthcareprovider_specialty_treatment_method_practitioner)) from patientconference pc left join patientcase p on pc.patient_case = p.id where p.patient= ? and p.treatment = ? and pc.status != 'Delete'";
			result = (Integer) this.getJdbcTemplate().queryForObject(query,
					new Object[] { patient, treatment }, Integer.class);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
