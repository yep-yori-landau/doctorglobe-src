/**
 * 
 */
package com.dg.data.dao;

import java.util.List;

import com.dg.data.model.db.Patientcasefile;

/**
 * This is a Patientcasefile DAO interface which includes the most fundamental
 * DAO operations (findByPatientCaseId, etc) for Patientcasefile object It also
 * extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientcasefileDAO extends GenericDAO<Patientcasefile> {

	/**
	 * Find the list of Patientcasefile object based on patientcase id
	 * @param patientcase the unique id of patientcase
	 * @return the list of Patientcasefile object or null if it cannot be found
	 */
	public List<Patientcasefile> findByPatientCaseId(Integer patientcase);

}
