/**
 * 
 */
package com.dg.data.service;

import java.util.List;
import com.dg.data.model.db.Patientcasefile;

/**
 * This is a PatientcasefileService service interface which includes the most
 * fundamental service operations for PatientcasefileService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientcasefileService
		extends GenericService<Patientcasefile> {

	/**
	 * find By Patient Case Id
	 * @param patientcase
	 * @return
	 */
	public List<Patientcasefile> findByPatientCaseId(Integer patientcase);

}
