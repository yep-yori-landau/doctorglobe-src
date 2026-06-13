/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.Patientcasebooking;

/**
 * This is a PatientcasebookingService service interface which includes the most
 * fundamental service operations for PatientcasebookingService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientcasebookingService
		extends GenericService<Patientcasebooking> {

	/**
	 * edit Status
	 * @param pc
	 * @param hcpstmp
	 * @param status
	 * @return
	 */
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp, String status);

	/**
	 * find By Patient Case And Hcpstmp
	 * @param patientcase
	 * @param hcpstmp
	 * @return
	 */
	public List<Patientcasebooking> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp);

	/**
	 * find By Patient And Treatment
	 * @param patient
	 * @param treatment
	 * @return
	 */
	public List<Patientcasebooking> findByPatientAndTreatment(int patient,
			int treatment);

	/**
	 * find By Patient Case
	 * @param patientcase
	 * @return
	 */
	public List<Patientcasebooking> findByPatientCase(int patientcase);

}
