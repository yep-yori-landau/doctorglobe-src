/**
 * 
 */
package com.dg.data.dao;

import com.dg.data.model.db.PatientcasePrice;

/**
 * This is a PatientcasePrice DAO interface which includes the most fundamental
 * DAO operations (findByPatientcaseAndHcpstmp, etc) for PatientcasePrice object
 * It also extends the generic DAO CRUD methods
 * 
 * @author DoctorGlobe
 */

public interface PatientcasePriceDAO extends GenericDAO<PatientcasePrice> {

	/**
	 * Find the PatientcasePrice object based on patientcase id and
	 * healthcareprovider_specialty_treatment_method_practitioner id
	 * @param patientcase the unique id of patientcase
	 * @param hcpstmp the unique id of
	 * healthcareprovider_specialty_treatment_method_practitioner
	 * @return the PatientcasePrice object
	 */
	public PatientcasePrice findByPatientcaseAndHcpstmp(Integer patientcase,
			Integer hcpstmp);
}
