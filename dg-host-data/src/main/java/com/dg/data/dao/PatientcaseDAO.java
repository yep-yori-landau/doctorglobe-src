/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.Patientcase;
import com.dg.data.model.domain.PatientcaseDetailModel;

/**
 * This is a Patientcase DAO interface which includes the most fundamental DAO
 * operations (findByPatientId, etc) for Patientcase object It also extends the
 * generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientcaseDAO extends GenericDAO<Patientcase> {

	/**
	 * Find the list of PatientcaseDetailModel object based on patient id
	 * @param patient the unique id of patient
	 * @return the list of PatientcaseDetailModel object or null if it cannot be
	 * found
	 */
	public List<PatientcaseDetailModel> findByPatientId(Integer patient);

	/**
	 * Change the status of patientcase object based on below params
	 * @param id the unique id of patientcase
	 * @param status the status(Open,In Progress,Approved) of patientcase object
	 * @return Integer 1 or 0 if it cannot be updated
	 */
	public Integer editStatus(Integer id, String status);

}
