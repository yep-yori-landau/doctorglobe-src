/**
 * 
 */
package com.dg.data.dao;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.Patientcasebooking;

/**
 * This is a Patientcasebooking DAO interface which includes the most
 * fundamental DAO operations (findByPatientCase, etc) for Patientcasebooking
 * object It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientcasebookingDAO extends GenericDAO<Patientcasebooking> {

	/**
	 * Change the status of patientcasebooking object based on below params
	 * @param pc the unique id of patientcase
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @param status the status(Open,Cancel,Closed,Delete) of patientcasebooking
	 * object
	 * @return Integer 1 or 0 if it cannot be updated
	 */
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp, String status);

	/**
	 * Find the list of Patientcasebooking object based on patientcase id and
	 * healthcareprovider_specialty_treatment_method_practitioner id
	 * @param patientcase the unique id of patientcase
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @return
	 */
	public List<Patientcasebooking> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp);

	/**
	 * Find the list of Patientcasebooking object based on patient id and
	 * treatment id
	 * @param patient the unique id of patient
	 * @param treatment the unique id of treatment
	 * @return the list of Patientcasebooking object or null if it cannot be
	 * found
	 */
	public List<Patientcasebooking> findByPatientAndTreatment(Integer patient,
			Integer treatment);

	/**
	 * Find the list of Patientcasebooking object based on patientcase id
	 * @param patientcase the unique id of patientcase
	 * @return the list of Patientcasebooking object or null if it cannot be
	 * found
	 */
	public List<Patientcasebooking> findByPatientCase(int patientcase);
}
