/**
 * 
 */
package com.dg.data.service;

import com.dg.data.model.db.PatientcasePrice;

/**
 * This is a PatientcasePriceService service interface which includes the most
 * fundamental service operations for PatientcasePriceService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface PatientcasePriceService
		extends GenericService<PatientcasePrice> {
	/**
	 * find By Patient case And Hcpstmp
	 * @param patientcase
	 * @param hcpstmp
	 * @return
	 */
	public PatientcasePrice findByPatientcaseAndHcpstmp(Integer patientcase,
			Integer hcpstmp);

}
