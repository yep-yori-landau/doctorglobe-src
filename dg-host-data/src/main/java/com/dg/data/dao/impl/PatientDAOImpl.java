/**
 * 
 */
package com.dg.data.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dg.data.dao.PatientDAO;
import com.dg.data.model.db.Patient;
import com.dg.data.model.db.mapper.PatientMapper;
import com.dg.data.model.domain.PatientCountryModel;
import com.dg.data.model.domain.PatientDetailModel;
import com.dg.data.model.domain.PatientLatLonModel;
import com.dg.data.model.domain.mapper.PatientCountryModelMapper;
import com.dg.data.model.domain.mapper.PatientDetailMapper;
import com.dg.data.model.domain.mapper.PatientLatLonMapper;

/**
 * This class represent Implementation of PatientDAO which can be extended to
 * add more specialized DAO methods.
 *
 * @author DoctorGlobe
 */
public class PatientDAOImpl extends GenericDAOImpl<Patient>
		implements PatientDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientDAOImpl.class);

	/**
	 * @param patient
	 * @return integer
	 */
	public Integer insert(Patient patient) {
		Integer result = 0;
		try {
			int row = super.insert(patient);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from patient where email = ?",
						new Object[] { patient.getEmail() }, Integer.class);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * @param patient
	 * @return integer
	 */
	public Integer insert(Patient patient, BigInteger user, String user_type) {
		Integer result = 0;
		try {
			int row = super.insert(patient, user, user_type);
			if (row > 0) {
				result = (Integer) this.getJdbcTemplate().queryForObject(
						"select id from patient where email = ?",
						new Object[] { patient.getEmail() }, Integer.class);
			}
		}
		catch (Exception ex) {
			logger.info("Exception found :" + ex.getMessage());
		}
		return result;
	}

	/**
	 * @param email
	 * @return patient model
	 */
	public Patient findByEmail(String email, Integer active) {
		Patient patient = new Patient();
		if (email != null) {
			try {
				String query = "SELECT *FROM patient WHERE email = ? and active = ?";
				patient = this.getJdbcTemplate().queryForObject(query,
						new Object[] { email, active }, new PatientMapper());
			}
			catch (Exception ex) {
				logger.info("Exception found :" + ex.getMessage());
			}
		}
		return patient;
	}

	@Override
	public List<PatientDetailModel> findByPractitionerId(Integer practitioner) {
		String query = "select a.id as id,concat(a.first_name,' ',a.last_name) as name,TIMESTAMPDIFF(YEAR, a.dob, CURDATE()) AS age, "
				+ " a.email as email,a.phone as phone,a.gender as gender,a.address as address,a.zip_code as zip_code,a.photo as photo,b.id as patientcase_id,b.description as description,"
				+ " b.status as status,b.treatment as treatment,c.id as patientcasefile_id,c.file_type as file_type,c.file_name as file_name,"
				+ " c.description as file_description,c.file_dt as file_dt,c.name as doc_name,d.id as patientconference_id, d.conference_dt as conference_dt,d.status as patientconference_status,d.timezone as conference_timezone,"
				+ " datediff(d.conference_dt,now()) as week_call,d.healthcareprovider_specialty_treatment_method_practitioner,t.name as treatment_name,pcm.id as pcm_id,"
				+ " pcm.sender as sender,pcm.receiver as receiver,pcm.subject,pcm.body as message,pcm.sender_type,"
				+ " pcm.status as pcm_status,pcm.sent_dt,pcb.id as booking_id,pcb.booking_dt,pcb.status as booking_status,pcb.timezone as booking_timezone,ci.name as city,co.name as country,co.code as country_code,e.practitioner as practitioner from patient a "
				+ " left join city ci on a.city = ci.id"
				+ " left join country co on ci.country = co.id"
				+ " left join patientcase b on a.id = b.patient"
				+ " left join treatment t on b.treatment = t.id"
				+ " left join patientcasefile c on b.id = c.patient_case"
				+ " left join patientconference d on b.id = d.patient_case"
				+ " left join healthcareprovider_specialty_treatment_method_practitioner e on d.healthcareprovider_specialty_treatment_method_practitioner =  e.id"
				+ " left join patientcasemessages pcm on b.id = pcm.patient_case"
				+ " left join patientcasebooking pcb on b.id = pcb.patient_case and d.healthcareprovider_specialty_treatment_method_practitioner=pcb.healthcareprovider_specialty_treatment_method_practitioner"
				+ " left join practitioner f on e.practitioner = f.id where f.id = ?";
		logger.info("patient find through practitioner id query = {}", query);
		logger.info("patient find through practitioner id  = {}", practitioner);
		return this.getJdbcTemplate().query(query,
				new Object[] { practitioner }, new PatientDetailMapper());
	}

	@Override
	public List<PatientDetailModel> findByPatientcase(Integer patientcase,
			Integer practitioner) {
		String query = "select a.id as id,concat(a.first_name,' ',a.last_name) as name,TIMESTAMPDIFF(YEAR, a.dob, CURDATE()) AS age, "
				+ " a.email as email,a.phone as phone,a.gender as gender,a.address as address,a.zip_code as zip_code,a.photo as photo,b.id as patientcase_id,b.description as description,"
				+ " b.status as status,b.treatment as treatment,c.id as patientcasefile_id,c.file_type as file_type,c.file_name as file_name,c.name as doc_name,"
				+ " c.description as file_description,c.file_dt as file_dt,d.id as patientconference_id, d.conference_dt as conference_dt,d.status as patientconference_status,d.timezone as conference_timezone,"
				+ " datediff(d.conference_dt,now()) as week_call,d.healthcareprovider_specialty_treatment_method_practitioner,t.name as treatment_name,pcm.id as pcm_id,pcm.subject,"
				+ " pcm.sender as sender,pcm.receiver as receiver,pcm.body as message,pcm.sender_type,"
				+ " pcm.status as pcm_status,pcm.sent_dt,pcb.id as booking_id,pcb.booking_dt,pcb.status as booking_status,pcb.timezone as booking_timezone,ci.name as city,co.name as country,co.code as country_code,e.practitioner as practitioner from patient a "
				+ " left join city ci on a.city = ci.id"
				+ " left join country co on ci.country = co.id"
				+ " left join patientcase b on a.id = b.patient"
				+ " left join treatment t on b.treatment = t.id"
				+ " left join patientcasefile c on b.id = c.patient_case"
				+ " left join patientconference d on b.id = d.patient_case"
				+ " left join healthcareprovider_specialty_treatment_method_practitioner e on d.healthcareprovider_specialty_treatment_method_practitioner =  e.id"
				+ " left join patientcasemessages pcm on b.id = pcm.patient_case"
				+ " left join patientcasebooking pcb on b.id = pcb.patient_case and d.healthcareprovider_specialty_treatment_method_practitioner=pcb.healthcareprovider_specialty_treatment_method_practitioner"
				+ " left join practitioner f on e.practitioner = f.id where (b.id = ? and f.id = ?)";
		return this.getJdbcTemplate().query(query,
				new Object[] { patientcase, practitioner },
				new PatientDetailMapper());
	}

	@Override
	public Integer resetPassword(Integer id, String old_password,
			String new_password) {
		Integer result = 0;
		if (id != null && old_password != null && new_password != null) {
			try {
				String query = "UPDATE patient set password =sha1(?) WHERE id = ? and password = ?";
				result = this.getJdbcTemplate().update(query,
						new Object[] { new_password, id, old_password });
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public PatientCountryModel findCountryById(Integer id) {
		PatientCountryModel model = new PatientCountryModel();
		if (id != null) {
			try {
				String query = "SELECT co.name as country,co.code as country_code,c.name as city,s.name as state FROM patient p left join city c on p.city = c.id left join state s on c.state = s.id left join country co on c.country = co.id WHERE p.id = ?";

				model = this.getJdbcTemplate().queryForObject(query,
						new Object[] { id }, new PatientCountryModelMapper());
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return model;
	}

	@Override
	public PatientLatLonModel findLatLonById(Integer id) {
		PatientLatLonModel model = new PatientLatLonModel();
		if (id != null) {
			try {
				String query = "SELECT p.id as id,co.id as country,c.id as city,p.lat as lat,p.lon as lon,c.lat as city_lat,c.lon as city_lon,c.name as city_name,s.id as state,s.name as state_name,s.code as state_code FROM patient p left join city c on p.city = c.id left join state s on c.state = s.id left join country co on c.country = co.id WHERE p.id = ?";
				model = this.getJdbcTemplate().queryForObject(query,
						new Object[] { id }, new PatientLatLonMapper());
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return model;

	}
	
	/**
	 * Find patient by phone no
	 * @param phone
	 * @param active
	 * @return patient model
	 */
	@Override
	public Patient findByPhone(String phone, Integer active) {
		Patient patient = new Patient();
		if (phone != null && active != null) {
			try {
				String query = "SELECT *FROM patient WHERE (phone = ? or mobile = ?) and active = ? limit 1";
				patient = this.getJdbcTemplate().queryForObject(query,
						new Object[] { phone, phone, active }, new PatientMapper());
			}
			catch (Exception ex) {
				logger.info("Exception found :" + ex.getMessage());
			}
		}
		return patient;
	}

}
