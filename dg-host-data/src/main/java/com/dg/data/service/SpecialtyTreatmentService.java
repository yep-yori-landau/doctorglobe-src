/**
 * 
 */
package com.dg.data.service;

import java.math.BigInteger;
import java.util.List;

import com.dg.data.model.db.SpecialtyTreatment;

/**
 * This is a SpecialtyTreatmentService service interface which includes the most
 * fundamental service operations for SpecialtyTreatmentService object It also
 * extends the generic service CRUD methods
 *
 * @author DoctorGlobe
 */
public interface SpecialtyTreatmentService
		extends GenericService<SpecialtyTreatment> {
	/**
	 * find By Specialty
	 * @param specialty
	 * @return
	 */
	public List<SpecialtyTreatment> findBySpecialty(BigInteger specialty);

}
