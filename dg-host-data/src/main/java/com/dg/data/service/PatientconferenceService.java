/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;
import com.dg.data.model.db.Patientconference;
import com.dg.data.model.domain.PatientConferenceDetailModel;

/**
 * This is a PatientconferenceService service interface which includes the most
 * fundamental service operations for PatientconferenceService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientconferenceService
		extends GenericService<Patientconference> {

	/**
	 * find By Patient Case
	 * @param patientcase
	 * @return
	 */
	public List<PatientConferenceDetailModel> findByPatientCase(
			Integer patientcase, Integer patient);

	/**
	 * find By Patient Case And Hcpstmp
	 * @param patientcase
	 * @param hcpstmp
	 * @return
	 */
	public List<Patientconference> findByPatientCaseAndHcpstmp(
			Integer patientcase, Integer hcpstmp);

	/**
	 * find By Patient And Treatment And Hcpstmp
	 * @param patient
	 * @param treatment
	 * @param hcpstmp
	 * @return
	 */
	public Boolean findByPatientAndTreatmentAndHcpstmp(int patient,
			int treatment, int hcpstmp);

	/**
	 * edit Status
	 * @param pc
	 * @param hcpstmp
	 * @param status
	 * @return
	 */
	public Integer editStatus(BigInteger pc, BigInteger hcpstmp, String status);

	/**
	 * find Total Patient Treatment Conference By Patient And Treatment
	 * @param patient
	 * @param treatment
	 * @return
	 */
	public Integer findTotalPatientTreatmentConferenceByPatientAndTreatment(
			int patient, int treatment);

}
