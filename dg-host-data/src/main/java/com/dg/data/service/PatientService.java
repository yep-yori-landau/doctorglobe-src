/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.Patient;
import com.dg.data.model.domain.PatientCountryModel;
import com.dg.data.model.domain.PatientDetailModel;
import com.dg.data.model.domain.PatientLatLonModel;

/**
 * This is a PatientService service interface which includes the most
 * fundamental service operations for PatientService object It also extends the
 * generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientService extends GenericService<Patient> {
	/**
	 * Insert a generic model in the database
	 * @param generic model
	 * @return int id
	 */
	public Integer insert(Patient patient);

	/**
	 * Insert a generic model in the database
	 * @param generic model
	 * @param user id
	 * @param user_type
	 * @return boolean
	 */
	public Integer insert(Patient patient, BigInteger user, String user_type);

	/**
	 * find By Practiioner Id
	 * @param practitioner
	 * @return
	 */
	public List<PatientDetailModel> findByPractiionerId(Integer practitioner);

	/**
	 * find By Patientcase
	 * @param patientcase
	 * @return
	 */
	public List<PatientDetailModel> findByPatientcase(Integer patientcase,
			Integer practitioner);

	/**
	 * reset Password
	 * @param id
	 * @param old_password
	 * @param new_password
	 * @return
	 */
	public Integer resetPassword(int id, String old_password,
			String new_password);

	/**
	 * find Country By Id
	 * @param id
	 * @return
	 */
	public PatientCountryModel findCountryById(int id);

	/**
	 * find Lat Lon By Id
	 * @param id
	 * @return
	 */
	public PatientLatLonModel findLatLonById(Integer id);

	/**
	 * get encrypted password
	 * @param passwordString
	 * @return sha1
	 * @throws Exception
	 */
	public String getSHA1(String passwordString) throws Exception;

	/**
	 * get Lat Long By Address
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public String[] getLatLngByAddress(String city) throws Exception;

	/**
	 * find By Email
	 * @param email
	 * @return
	 */
	public Patient findByEmail(String email, Integer active);
	
	/**
	 * find By phone
	 * @param phone
	 * @return patient model
	 */
	public Patient findByPhone(String phone, Integer active);
}
