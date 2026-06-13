/**
 * 
 */
package com.dg.data.service;

import java.util.List;
import com.dg.data.model.db.Patientcase;
import com.dg.data.model.domain.PatientcaseDetailModel;

/**
 * This is a PatientcaseService service interface which includes the most
 * fundamental service operations for PatientcaseService object It also extends
 * the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientcaseService extends GenericService<Patientcase> {
	/**
	 * find By Patient Id
	 * @param patient
	 * @return
	 */
	public List<PatientcaseDetailModel> findByPatientId(Integer patient);

	/*
	 * edit Status
	 * 
	 * @param id
	 * 
	 * @param status
	 * 
	 * @return integer
	 */
	public Integer editStatus(int id, String status);
}
